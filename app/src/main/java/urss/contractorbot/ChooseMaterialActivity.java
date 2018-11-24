package urss.contractorbot;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class ChooseMaterialActivity extends EditSurfaceActivity {

    private TextView tvChooseMaterialTitle;
    private MaterialSQLiteHelper db;
    private Cursor cursor;
    private MaterialCursorAdapter adapter;
    private ListView lvMaterial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDB();
        initLayout();
    }

    private void initLayout()
    {
        setContentView(R.layout.materiallayout);
        lvMaterial = (ListView)findViewById(R.id.listViewMaterial);
        lvMaterial.setAdapter(adapter);

//        tvChooseMaterialTitle = (TextView)findViewById(R.id.tvChooseMaterial);
//        tvChooseMaterialTitle.setText(R.string.title_material_list);
    }

    private void initDB()
    {
        db = new MaterialSQLiteHelper(getApplicationContext());
        db.resetDB();
        db.initDB();

        cursor = db.getAllMaterials();
        adapter = new MaterialCursorAdapter(this, cursor, 0);
    }
}
