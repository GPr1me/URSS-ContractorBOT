package urss.contractorbot;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private MySQLiteHelper db;
    private Cursor cursor;
    private MaterialCursorAdapter adapter;
    private ListView lvMaterial;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.content_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_material_list);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_commands);
        initLayout();

        db = new MySQLiteHelper(this);
        db.initDB();
        /*cursor = db.getAllMaterials();
        adapter = new MaterialCursorAdapter(this, cursor, 0);
        lvMaterial.setAdapter(adapter);
        lvMaterial.setItemChecked(0, true);*/

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void initLayout()
    {
        lvMaterial = (ListView)findViewById(R.id.listViewMaterial);
    }
}
