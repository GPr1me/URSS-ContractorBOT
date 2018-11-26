package urss.contractorbot;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EditSurfaceActivity extends AppCompatActivity {

    private TextView txtWall1;
    private TextView txtWall2;
    private TextView txtWall3;
    private TextView txtWall4;
    private TextView txtFloor;
    private TextView txtCeiling;

    private Button btnWall1;
    private Button btnWall2;
    private Button btnWall3;
    private Button btnWall4;
    private Button btnFloor;
    private Button btnCeiling;
    private Button btnGenerateBOM;

    private float SurfaceX;
    private float SurfaceY;
    private float SurfaceZ;

    private ArrayList<MaterialListPosition> materialsWall1;
    private ArrayList<MaterialListPosition> materialsWall2;
    private ArrayList<MaterialListPosition> materialsWall3;
    private ArrayList<MaterialListPosition> materialsWall4;
    private ArrayList<MaterialListPosition> materialsFloor;
    private ArrayList<MaterialListPosition> materialsCeiling;

    private Bundle extras;
    private Resources res;
    private String Area;

    private Intent activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();

        if (savedInstanceState == null) {
            extras = getIntent().getExtras();
        } else {
            extras = savedInstanceState;
        }


        Area = res.getString(R.string.area);
        SurfaceX = extras.getFloat("SurfaceX");
        SurfaceY = extras.getFloat("SurfaceY");
        SurfaceZ = extras.getFloat("SurfaceZ");


        materialsWall1 = (ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall1");
        if(materialsWall1 == null) {
            materialsWall1 = new ArrayList<MaterialListPosition>();
        }

        materialsWall2 = (ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall2");
        if(materialsWall2 == null) {
            materialsWall2 = new ArrayList<MaterialListPosition>();
        }

        materialsWall3 = (ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall3");
        if(materialsWall3 == null) {
            materialsWall3 = new ArrayList<MaterialListPosition>();
        }

        materialsWall4 = (ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall4");
        if(materialsWall4 == null) {
            materialsWall4 = new ArrayList<MaterialListPosition>();
        }

        materialsFloor = (ArrayList<MaterialListPosition>) extras.getSerializable("materialsFloor");
        if(materialsFloor == null) {
            materialsFloor = new ArrayList<MaterialListPosition>();
        }

        materialsCeiling = (ArrayList<MaterialListPosition>) extras.getSerializable("materialsCeiling");
        if(materialsCeiling == null) {
            materialsCeiling = new ArrayList<MaterialListPosition>();
        }


        initLayout();
    }

    private void initLayout(){

        setContentView(R.layout.activity_edit_surface);

        txtWall1 = (TextView) findViewById(R.id.txt_Wall1Area);
        txtWall2 = (TextView) findViewById(R.id.txt_Wall2Area);
        txtWall3 = (TextView) findViewById(R.id.txt_Wall3Area);
        txtWall4 = (TextView) findViewById(R.id.txt_Wall4Area);
        txtFloor = (TextView) findViewById(R.id.txt_FloorArea);
        txtCeiling = (TextView) findViewById(R.id.txt_CeilingArea);

        txtWall1.setText(Area + SurfaceX);
        txtWall2.setText(Area + SurfaceY);
        txtWall3.setText(Area + SurfaceX);
        txtWall4.setText(Area + SurfaceY);
        txtFloor.setText(Area + SurfaceZ);
        txtCeiling.setText(Area + SurfaceZ);

        btnWall1 = (Button) findViewById(R.id.btn_Wall1);
        btnWall2 = (Button) findViewById(R.id.btn_Wall2);
        btnWall3 = (Button) findViewById(R.id.btn_Wall3);
        btnWall4 = (Button) findViewById(R.id.btn_Wall4);
        btnFloor = (Button) findViewById(R.id.btn_Floor);
        btnCeiling = (Button) findViewById(R.id.btn_Ceiling);
        btnGenerateBOM = (Button) findViewById(R.id.btn_GenerateBOM);

        btnWall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMaterial("materialsWall1", materialsWall1);
            }
        });

        btnWall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMaterial("materialsWall2", materialsWall2);
            }
        });

        btnWall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMaterial("materialsWall3", materialsWall3);
            }
        });

        btnWall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMaterial("materialsWall4", materialsWall4);
            }
        });

        btnFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMaterial("materialsFloor", materialsFloor);
            }
        });

        btnCeiling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMaterial("materialsCeiling", materialsCeiling);
            }
        });


        if(!AllMaterialsAreSelected()){
            btnGenerateBOM.setEnabled(false);
            btnGenerateBOM.setVisibility(View.GONE);
        }

    }

    private void chooseMaterial(String listName, ArrayList<MaterialListPosition> materials){

        activity = new Intent(EditSurfaceActivity.this, ChooseMaterialActivity.class);
        keepMemoryAlive();
        activity.putExtra(listName, materials);
        activity.putExtra("listName", listName);
        EditSurfaceActivity.this.startActivity(activity);
    }

    private boolean AllMaterialsAreSelected(){
        return !materialsWall1.isEmpty()
                && !materialsWall2.isEmpty()
                && !materialsWall3.isEmpty()
                && !materialsWall4.isEmpty()
                && !materialsFloor.isEmpty()
                && !materialsCeiling.isEmpty();
    }

    // very dumb but I don't have time on my side
    private void keepMemoryAlive(){
        activity.putExtra("SurfaceX", extras.getFloat("SurfaceX"));
        activity.putExtra("SurfaceY", extras.getFloat("SurfaceY"));
        activity.putExtra("SurfaceZ", extras.getFloat("SurfaceZ"));
        activity.putExtra("materialsWall1", (ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall1"));
        activity.putExtra("materialsWall2", (ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall2"));
        activity.putExtra("materialsWall3",(ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall3"));
        activity.putExtra("materialsWall4",(ArrayList<MaterialListPosition>) extras.getSerializable("materialsWall4"));
        activity.putExtra("materialsFloor",(ArrayList<MaterialListPosition>) extras.getSerializable("materialsFloor"));
        activity.putExtra("materialsCeiling",(ArrayList<MaterialListPosition>) extras.getSerializable("materialsCeiling"));
    }
}
