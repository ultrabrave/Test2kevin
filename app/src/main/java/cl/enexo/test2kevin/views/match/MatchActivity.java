package cl.enexo.test2kevin.views.match;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cl.enexo.test2kevin.R;
import cl.enexo.test2kevin.models.Match;
import cl.enexo.test2kevin.views.match.add.CallbackValidationAddMatch;
import cl.enexo.test2kevin.views.match.add.FragmentMatchFormAdd;
import cl.enexo.test2kevin.views.match.list.FragmentMatchList;

/**
 * Created by Kevin on 13-11-2016.
 */

public class MatchActivity extends AppCompatActivity implements CallbackValidationAddMatch {
    private ImageView imglist;
    private ImageView imgadd;
    private LinearLayout linearAdd;
    private LinearLayout lineaList;
    private FragmentMatchList fragmentMatchList;
    private FragmentMatchFormAdd fragmentMatchFormAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list);
        iniValues();
        imgadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineaList.setVisibility(View.GONE);
                linearAdd.setVisibility(View.VISIBLE);
            }
        });

        imglist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineaList.setVisibility(View.VISIBLE);
                linearAdd.setVisibility(View.GONE);
            }
        });
    }

    private void iniValues()
    {
        imgadd = (ImageView) findViewById(R.id.imgadd);
        imglist = (ImageView) findViewById(R.id.imgEye);
        lineaList = (LinearLayout) findViewById(R.id.linear_list);
        linearAdd = (LinearLayout) findViewById(R.id.linear_add);
        fragmentMatchFormAdd = (FragmentMatchFormAdd) getSupportFragmentManager().findFragmentById(R.id.fragmentMatchFormAdd);
        fragmentMatchList = (FragmentMatchList) getSupportFragmentManager().findFragmentById(R.id.FragmentMatchList);
    }


    @Override
    public void ok(Match match) {
        fragmentMatchList.addMatch(match);
        mensaje("Datos agregados correctamente");
    }

    @Override
    public void fail() {
        mensaje("Debe ingresar datos solicitados");
    }

    public void mensaje(String cadena) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alerta:");
        alertDialog.setMessage(cadena);
        alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }
}
