package shivam.happeningapp3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void directpath(View view)
    {
        Intent pathintent = new Intent(this,PathActivity.class);
        startActivity(pathintent);
    }

    public void addetails(View view)
    {
        Intent detailintent = new Intent(this, DetailActivity.class);
        startActivity(detailintent);
    }

    public void addtimetable(View view)
    {
        Intent addtimeintent = new Intent(this, TimeTable.class);
        startActivity(addtimeintent);
    }

    public void showtime(View view)
    {
        Intent show = new Intent(this, ShowTimeTable.class);
        startActivity(show);
    }

    public void ShowDetails(View view)
    {
        Intent intent = new Intent(this, ShowAbout.class);
        startActivity(intent);
    }
}
