package urss.contractorbot;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import urss.contractorbot.SQLite.MaterialCursorAdapter;
import urss.contractorbot.SQLite.MaterialSQLiteHelper;
import urss.contractorbot.ViewModel.MaterialView;

public class ChooseMaterialActivity extends EditSurfaceActivity {

    private TextView tvChooseMaterialTitle;
    private MaterialSQLiteHelper db;
    private Cursor cursor;
    private MaterialCursorAdapter adapter;
    private ListView lvMaterial;
    private Button btnCancel;
    private Button btnOk;

    private ArrayList<MaterialListPosition> materials;
    private String listName;

    private Resources res;
    private Intent activity;
    private Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        res = getResources();
        activity = new Intent(ChooseMaterialActivity.this, EditSurfaceActivity.class);


        if (savedInstanceState == null) {
            extras = getIntent().getExtras();
        } else {
            extras = savedInstanceState;
        }

        keepMemoryAlive();

        listName = extras.getString("listName");
        materials = (ArrayList<MaterialListPosition>)extras.getSerializable(listName);
        if(materials == null){
            materials = new ArrayList<>();
        }

        initDB();
        initLayout();
    }

    private void initLayout()
    {
        setContentView(R.layout.materiallayout);
        lvMaterial = (ListView)findViewById(R.id.listViewMaterial);
        lvMaterial.setAdapter(adapter);

        lvMaterial.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id){
                Material material = ((MaterialView)view).getMaterial();
                if(materials.contains(material)){
                    view.setSelected(false);
//                    view.setBackgroundColor(ContextCompat.getColor(ChooseMaterialActivity.this, R.color.blanc));
                    materials.remove(new MaterialListPosition(((MaterialView)view).getMaterial(), position));
                } else{
                    view.setSelected(true);
//                    view.setBackgroundColor(ContextCompat.getColor(ChooseMaterialActivity.this, R.color.colorAccent));
                    materials.add(new MaterialListPosition(((MaterialView)view).getMaterial(), position));
                }

            }
        });

        for(MaterialListPosition material: materials){
            View view = lvMaterial.getAdapter().getView(material.getPosition(), null, null);
            view.setSelected(true);
            view.isSelected();
//            view.setBackgroundColor(ContextCompat.getColor(ChooseMaterialActivity.this, R.color.colorAccent));
            view.invalidate();
        }

        lvMaterial.invalidate();

        btnCancel = (Button)findViewById(R.id.btn_Cancel);
        btnOk = (Button)findViewById(R.id.btn_OK);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leaveView();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!materials.isEmpty()){
                    selectMaterials(materials);
                } else{
                    Toast.makeText(getApplicationContext(), R.string.errorNoMaterialSelected, Toast.LENGTH_LONG).show();
                }

            }
        });

//        tvChooseMaterialTitle = (TextView)findViewById(R.id.tvChooseMaterial);
//        tvChooseMaterialTitle.setText(R.string.title_material_list);

        this.setFinishOnTouchOutside(false);
    }

    private void initDB()
    {
        db = new MaterialSQLiteHelper(getApplicationContext());
        db.resetDB();
        db.initDB();

        cursor = db.getAllMaterials();
        adapter = new MaterialCursorAdapter(this, cursor, 0);
    }

    private void leaveView(){
        ChooseMaterialActivity.this.startActivity(activity);
    }

    private void selectMaterials(ArrayList<MaterialListPosition> materials){
        activity.putExtra(listName, materials);
        leaveView();
    }

    // very dumb but I don't have time on my side
    private void keepMemoryAlive(){
        activity.putExtra("SurfaceX", extras.getFloat("SurfaceX"));
        activity.putExtra("SurfaceY", extras.getFloat("SurfaceY"));
        activity.putExtra("SurfaceZ", extras.getFloat("SurfaceZ"));
        activity.putExtra("materialsWall1", (ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall1"));
        activity.putExtra("materialsWall2", (ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall2"));
        activity.putExtra("materialsWall3", (ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall3"));
        activity.putExtra("materialsWall4", (ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall4"));
        activity.putExtra("materialsFloor", (ArrayList<MaterialListPosition>) extras.getSerializable("materialsFloor"));
        activity.putExtra("materialsCeiling", (ArrayList<MaterialListPosition>) extras.getSerializable("materialsCeiling"));
    }
}
