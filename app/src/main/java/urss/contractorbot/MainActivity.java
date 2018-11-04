package urss.contractorbot;

import android.content.Intent;
import android.os.Bundle;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.database.Cursor;

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
                    activite = new Intent(MainActivity.this, TestBluetooth.class);
                    MainActivity.this.startActivity(activite);
                    return true;
                case R.id.navigation_notifications:
                    activite = new Intent(MainActivity.this, ChooseMaterialActivity.class);
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
