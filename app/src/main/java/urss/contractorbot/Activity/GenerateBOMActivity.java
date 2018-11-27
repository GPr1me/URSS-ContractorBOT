package urss.contractorbot.Activity;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

import urss.contractorbot.Model.BOM;
import urss.contractorbot.Model.BOMItem;
import urss.contractorbot.R;
import urss.contractorbot.SQLite.MaterialSQLiteHelper;
import urss.contractorbot.ViewModel.BOMCursorAdapter;

public class GenerateBOMActivity extends Activity {

    private Bundle extras;
    private Resources res;

    private ListView lvBOM;

    private BOMCursorAdapter adapter;
    private Cursor cursor;

    private MaterialSQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();

        if (savedInstanceState == null) {
            extras = getIntent().getExtras();
        } else {
            extras = savedInstanceState;
        }

        db = new MaterialSQLiteHelper(getApplicationContext());

        cursor = db.getAllBOMItem();
        adapter = new BOMCursorAdapter(this, cursor, 0);

        initLayout();
    }

    private void initLayout(){
        setContentView(R.layout.bom_layout);

        lvBOM = (ListView) findViewById(R.id.listViewBOM);
        lvBOM.setAdapter(adapter);
    }
}
