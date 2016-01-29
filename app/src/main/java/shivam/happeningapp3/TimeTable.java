package shivam.happeningapp3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class TimeTable extends ActionBarActivity {

    EditText e1,e2,e3,e4;
    DBManager mydbmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        e1 = (EditText) findViewById(R.id.day);
        e2 = (EditText) findViewById(R.id.date);
        e3 = (EditText) findViewById(R.id.time);
        e4 = (EditText) findViewById(R.id.task);

        mydbmanager = new DBManager(this, null, null ,1);

    }

    public void add(View view)
    {
        mytimetable tb = new mytimetable(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString());
        mydbmanager.addtimetable(tb);
    }

    public void back(View view)
    {
        Intent i = new Intent(this,MainActivity.class );
        startActivity(i);
    }

}
