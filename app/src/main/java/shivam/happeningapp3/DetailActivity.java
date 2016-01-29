package shivam.happeningapp3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class DetailActivity extends ActionBarActivity {

    EditText et1,et2,et3,et4,et5,et6;
    DBManager detaildb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        et1 = (EditText)findViewById(R.id.name);
        et2 = (EditText)findViewById(R.id.email);
        et3 = (EditText)findViewById(R.id.location);
        et4 = (EditText)findViewById(R.id.research);
        et5 = (EditText)findViewById(R.id.phone);
        et6 = (EditText)findViewById(R.id.disc);

        detaildb = new DBManager(this, null, null,1);

    }

    public void AddDeatail(View view)
    {
        DetailsSyntex ds = new DetailsSyntex(et1.getText().toString(),et2.getText().toString(),et3.getText().toString(),
                et4.getText().toString(),et5.getText().toString(),et6.getText().toString());
        detaildb.adddisc(ds);
    }



}
