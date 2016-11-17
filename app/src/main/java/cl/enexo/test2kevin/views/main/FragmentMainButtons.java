package cl.enexo.test2kevin.views.main;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import cl.enexo.test2kevin.R;
import cl.enexo.test2kevin.views.match.MatchActivity;

import static android.R.attr.start;

/**
 * Created by Kevin on 12-11-2016.
 */

public class FragmentMainButtons extends Fragment {
    private Button btn11,btn7,btn6,btn5;
    private Dialog dialog;
    private ImageView imgsplash;
    private Button btndialog;
    public FragmentMainButtons() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_buttons, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn11 = (Button) view.findViewById(R.id.btn_soccer);
        btn7 = (Button) view.findViewById(R.id.btn_soccer7);
        btn6 = (Button) view.findViewById(R.id.btn_soccer6);
        btn5 = (Button) view.findViewById(R.id.btn_soccer5);

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                versionPaid();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                versionPaid();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                versionPaid();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), MatchActivity.class);
                startActivity(i);
            }
        });
    }

    private void versionPaid()
    {
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_error);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        imgsplash = (ImageView) dialog.findViewById(R.id.img_splash_error);
        imgsplash.setBackgroundResource(R.drawable.error);
        AnimationDrawable gyroAnimation = (AnimationDrawable) imgsplash.getBackground();
        gyroAnimation.start();
        dialog.show();
        btndialog = (Button) dialog.findViewById(R.id.btn_ok_error);
        btndialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
