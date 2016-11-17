package cl.enexo.test2kevin.views.match.add;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import cl.enexo.test2kevin.R;
import cl.enexo.test2kevin.adapters.MatchAdapter;
import cl.enexo.test2kevin.models.Match;

import static android.R.attr.fingerprintAuthDrawable;
import static android.R.attr.name;

/**
 * Created by Kevin on 16-11-2016.
 */

public class FragmentMatchFormAdd extends Fragment {
    private MatchAdapter matchAdapter;
    private EditText etname;
    private EditText etplace;
    private SeekBar sbduration;
    private Button btnadd;
    private AddMatchValidation addmatchvalidation;
    private CallbackValidationAddMatch callback;
    private TextView counter;

    public FragmentMatchFormAdd() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (CallbackValidationAddMatch) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form_add_match, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etname = (EditText) view.findViewById(R.id.et_namematch);
        etplace = (EditText) view.findViewById(R.id.et_place);
        sbduration = (SeekBar) view.findViewById(R.id.sb_drink);
        btnadd = (Button) view.findViewById(R.id.btn_addmatch);
        addmatchvalidation = new AddMatchValidation(callback);
        counter = (TextView) view.findViewById(R.id.tv_counter);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etname.getText().toString();
                String place = etplace.getText().toString();
                int duration = sbduration.getProgress();
                addmatchvalidation.newMatch(name,place,duration);
            }
        });

        sbduration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                counter.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
