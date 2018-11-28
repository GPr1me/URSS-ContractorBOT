package urss.contractorbot.Activity;

import android.content.Intent;
import android.content.res.Resources;
import android.drm.DrmStore;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import urss.contractorbot.BLE.DeviceControlActivity;
import urss.contractorbot.BLE.DeviceScanActivity;
import urss.contractorbot.Model.BOM;
import urss.contractorbot.Model.BOMItem;
import urss.contractorbot.Model.Material;
import urss.contractorbot.Model.MaterialListPosition;
import urss.contractorbot.Model.MaterialSupplier;
import urss.contractorbot.Model.MaterialType;
import urss.contractorbot.R;
import urss.contractorbot.SQLite.MaterialSQLiteHelper;

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

    private AppBarLayout titleBar;

    private float SurfaceX;
    private float SurfaceY;
    private float SurfaceZ;

    private DecimalFormat floatFormat;
    private DecimalFormatSymbols separator;
    private String unit = "pi\u00B2";

    private ArrayList<MaterialListPosition> materialsWall1;
    private ArrayList<MaterialListPosition> materialsWall2;
    private ArrayList<MaterialListPosition> materialsWall3;
    private ArrayList<MaterialListPosition> materialsWall4;
    private ArrayList<MaterialListPosition> materialsFloor;
    private ArrayList<MaterialListPosition> materialsCeiling;

    private Bundle extras;
    private Resources res;
    private MaterialSQLiteHelper db;

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

        SurfaceX = extras.getFloat("SurfaceX");
        SurfaceY = extras.getFloat("SurfaceY");
        SurfaceZ = extras.getFloat("SurfaceZ");

        separator = new DecimalFormatSymbols(DecimalFormatSymbols.getAvailableLocales()[0]);
        separator.setDecimalSeparator('.');
        floatFormat = new DecimalFormat("#.##", separator);


        generateLists();

        initLayout();
    }

    private void generateLists(){
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
    }

    private void initLayout(){

        setContentView(R.layout.activity_edit_surface);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        txtWall1 = (TextView) findViewById(R.id.txt_Wall1Area);
        txtWall2 = (TextView) findViewById(R.id.txt_Wall2Area);
        txtWall3 = (TextView) findViewById(R.id.txt_Wall3Area);
        txtWall4 = (TextView) findViewById(R.id.txt_Wall4Area);
        txtFloor = (TextView) findViewById(R.id.txt_FloorArea);
        txtCeiling = (TextView) findViewById(R.id.txt_CeilingArea);

        txtWall1.setText(floatFormat.format(SurfaceX) + unit);
        txtWall2.setText(floatFormat.format(SurfaceY) + unit);
        txtWall3.setText(floatFormat.format(SurfaceX) + unit);
        txtWall4.setText(floatFormat.format(SurfaceY) + unit);
        txtFloor.setText(floatFormat.format(SurfaceZ) + unit);
        txtCeiling.setText(floatFormat.format(SurfaceZ) + unit);

        //region buttons init
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
        if(!materialsWall1.isEmpty()){
            btnWall1.setBackgroundColor(ContextCompat.getColor(EditSurfaceActivity.this, R.color.colorAccent));
        }

        btnWall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMaterial("materialsWall2", materialsWall2);
            }
        });
        if(!materialsWall2.isEmpty()){
            btnWall2.setBackgroundColor(ContextCompat.getColor(EditSurfaceActivity.this, R.color.colorAccent));
        }

        btnWall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMaterial("materialsWall3", materialsWall3);
            }
        });
        if(!materialsWall3.isEmpty()){
            btnWall3.setBackgroundColor(ContextCompat.getColor(EditSurfaceActivity.this, R.color.colorAccent));
        }

        btnWall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMaterial("materialsWall4", materialsWall4);
            }
        });
        if(!materialsWall4.isEmpty()){
            btnWall4.setBackgroundColor(ContextCompat.getColor(EditSurfaceActivity.this, R.color.colorAccent));
        }

        btnFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMaterial("materialsFloor", materialsFloor);
            }
        });
        if(!materialsFloor.isEmpty()){
            btnFloor.setBackgroundColor(ContextCompat.getColor(EditSurfaceActivity.this, R.color.colorAccent));
        }

        btnCeiling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseMaterial("materialsCeiling", materialsCeiling);
            }
        });
        if(!materialsCeiling.isEmpty()){
            btnCeiling.setBackgroundColor(ContextCompat.getColor(EditSurfaceActivity.this, R.color.colorAccent));
        }

        btnGenerateBOM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateBOM();
            }
        });
        if(!AllMaterialsAreSelected()){
            btnGenerateBOM.setEnabled(false);
            btnGenerateBOM.setVisibility(View.GONE);
        }
        //endregion
    }

    private void chooseMaterial(String listName, ArrayList<MaterialListPosition> materials){
        activity = new Intent(EditSurfaceActivity.this, ChooseMaterialActivity.class);
        keepMemoryAlive();
        activity.putExtra(listName, materials);
        activity.putExtra("listName", listName);
        EditSurfaceActivity.this.startActivity(activity);
    }

    private void generateBOM(){

        BOM bom = new BOM();

        bom.addList(materialsWall1, (int)Math.ceil(SurfaceX));
        bom.addList(materialsWall2, (int)Math.ceil(SurfaceY));
        bom.addList(materialsWall3, (int)Math.ceil(SurfaceX));
        bom.addList(materialsWall4, (int)Math.ceil(SurfaceY));
        bom.addList(materialsFloor, (int)Math.ceil(SurfaceZ));
        bom.addList(materialsCeiling, (int)Math.ceil(SurfaceZ));

        activity = new Intent(EditSurfaceActivity.this, GenerateBOMActivity.class);

        activity.putExtra("grandTotal", bom.calculateGrandTotal());

        db = new MaterialSQLiteHelper(getApplicationContext());
        db.resetDB();
        db.initDB();
        db.fillBOM(bom);
        EditSurfaceActivity.this.startActivity(activity);
    }

    // On back button click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            keepMemoryAlive();
            super.finish();
        }

        return super.onOptionsItemSelected(item);
    }

//    private void returnToControls(){
//        activity = new Intent(EditSurfaceActivity.this, DeviceControlActivity.class);
//        EditSurfaceActivity.this.startActivity(activity);
//    }

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
        activity.putExtra("materialsCeiling",(ArrayList<Material>) extras.getSerializable("materialsCeiling"));
    }
}
