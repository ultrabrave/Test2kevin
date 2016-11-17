package cl.enexo.test2kevin.views.match.list;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import cl.enexo.test2kevin.R;
import cl.enexo.test2kevin.adapters.MatchAdapter;
import cl.enexo.test2kevin.models.Match;
import cl.enexo.test2kevin.views.match.list.details.DetailsList;

/**
 * Created by Kevin on 15-11-2016.
 */

public class FragmentMatchList extends Fragment implements MatchListListener{
    private Button btn11,btn7,btn6,btn5;
    private Dialog dialog;
    private ImageView imgsplash;
    private Button btndialog;
    private MatchAdapter matchAdapter;

    public FragmentMatchList() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_match, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.matchRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        matchAdapter = new MatchAdapter(this);
        recyclerView.setAdapter(matchAdapter);

        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) view;
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        matchAdapter.reset();
                        refreshLayout.setRefreshing(false);
                    }
                },800);
            }
        });
    }

    @Override
    public void click(long id) {
        Intent intent = new Intent(getActivity(), DetailsList.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }

    public void addMatch(Match match)
    {
        matchAdapter.add(match);
    }
}
