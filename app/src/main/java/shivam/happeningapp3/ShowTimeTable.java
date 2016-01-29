package shivam.happeningapp3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ShowTimeTable extends ActionBarActivity {

    TextView text ;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_time_table);

        text = (TextView)findViewById(R.id.timetable);
        dbManager = new DBManager(this, null,null,1);
    }

    public void showtime(View view){
        String dbstring = dbManager.databasetostring();
        text.setText(dbstring);
    }

    public void backmenu(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void deletett(View view)
    {
        dbManager.deletetimetable();
    }

}
