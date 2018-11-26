package urss.contractorbot.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.database.Cursor;

import urss.contractorbot.BLE.DeviceScanActivity;
import urss.contractorbot.R;
import urss.contractorbot.ViewModel.MaterialCursorAdapter;
import urss.contractorbot.SQLite.MaterialSQLiteHelper;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private MaterialSQLiteHelper db;
    private Cursor cursor;
    private MaterialCursorAdapter adapter;
    private ListView lvMaterial;
    private Intent activite;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    activite = new Intent(MainActivity.this, DeviceScanActivity.class);
                    MainActivity.this.startActivity(activite);
                    return true;
                case R.id.navigation_notifications:
                    activite = new Intent(MainActivity.this, EditSurfaceActivity.class);
                    activite.putExtra("SurfaceX", (float)423.24);
                    activite.putExtra("SurfaceY", (float)5678.64);
                    activite.putExtra("SurfaceZ", (float)65432.23);
                    MainActivity.this.startActivity(activite);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();
    }

    public void initLayout()
    {
        setContentView(R.layout.main_activity);
        mTextMessage = (TextView)findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView)findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
