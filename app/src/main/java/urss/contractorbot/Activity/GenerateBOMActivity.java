package urss.contractorbot.Activity;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import urss.contractorbot.Model.BOM;
import urss.contractorbot.Model.BOMItem;
import urss.contractorbot.R;
import urss.contractorbot.SQLite.MaterialSQLiteHelper;
import urss.contractorbot.ViewModel.BOMCursorAdapter;

public class GenerateBOMActivity extends Activity {

    private Bundle extras;
    private Resources res;

    private TextView tvGrandTotal;
    private ListView lvBOM;
    private float grandTotal;

    private BOMCursorAdapter adapter;
    private Cursor cursor;

    private DecimalFormat floatFormat;
    private DecimalFormatSymbols separator;

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

        grandTotal = extras.getFloat("grandTotal");

        db = new MaterialSQLiteHelper(getApplicationContext());

        cursor = db.getAllBOMItem();
        adapter = new BOMCursorAdapter(this, cursor, 0);

        initLayout();
    }

    private void initLayout(){
        setContentView(R.layout.bom_layout);

        separator = new DecimalFormatSymbols(DecimalFormatSymbols.getAvailableLocales()[0]);
        separator.setDecimalSeparator('.');
        floatFormat = new DecimalFormat("#.##", separator);
        floatFormat.setMinimumFractionDigits(2);

        tvGrandTotal = (TextView)findViewById(R.id.tvGrandTotal);
        tvGrandTotal.setText("Total: " + floatFormat.format(grandTotal) + "$");

        lvBOM = (ListView) findViewById(R.id.listViewBOM);
        lvBOM.setAdapter(adapter);
    }
}
