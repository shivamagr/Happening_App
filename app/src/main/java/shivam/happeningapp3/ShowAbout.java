package shivam.happeningapp3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ShowAbout extends ActionBarActivity {

    EditText edt;
    TextView text12;
    DBManager showmdbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_about);

        edt = (EditText)findViewById(R.id.input);
        text12 = (TextView)findViewById(R.id.showmedetail);

        showmdbManager = new DBManager(this, null, null, 1);

    }

    public void detailshowm (View view)
    {
        String st = "";
        st += showmdbManager.showprofdetail(edt.getText().toString());
        text12.setText(st);
    }

    public void ListOfProf (View view){
        String string = "";
        string += showmdbManager.findprof(edt.getText().toString());
        text12.setText(string);
    }

}
