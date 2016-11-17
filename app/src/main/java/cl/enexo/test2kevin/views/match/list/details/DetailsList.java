package cl.enexo.test2kevin.views.match.list.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

import cl.enexo.test2kevin.R;
import cl.enexo.test2kevin.models.Match;

import static cl.enexo.test2kevin.R.id.imgadd;

/**
 * Created by Kevin on 16-11-2016.
 */

public class DetailsList extends AppCompatActivity{
    private TextView txtname;
    private TextView txtplace;
    private TextView txtduration;
    private TextView txtdate;
    private Match match;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_list);
        iniValues();
        long matchid = getIntent().getLongExtra("ID",0);
        match = Match.findById(Match.class,matchid);
        putData(match);
    }

    private void iniValues()
    {
        txtname = (TextView) findViewById(R.id.txtname);
        txtplace = (TextView) findViewById(R.id.txtplace);
        txtduration = (TextView) findViewById(R.id.txtduration);
        txtdate = (TextView) findViewById(R.id.txtdate);

    }

    private void putData(Match m)
    {
        txtname.setText(m.getName());
        txtplace.setText(m.getPlace());
        txtduration.setText(m.getTime() + " hrs");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String currentDateandTime = sdf.format(m.getDatematch());
        txtdate.setText("Fecha " + currentDateandTime);
    }
}
