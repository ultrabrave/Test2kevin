package cl.enexo.test2kevin.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import cl.enexo.test2kevin.R;
import cl.enexo.test2kevin.data.MatchData;
import cl.enexo.test2kevin.models.Match;
import cl.enexo.test2kevin.views.match.list.MatchListListener;


public class MatchAdapter extends  RecyclerView.Adapter<MatchAdapter.ViewHolder>{

    private List<Match> match = new MatchData().ObtainListMatch();
    private MatchListListener listener;

    public MatchAdapter(MatchListListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_match, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Match mymatch = match.get(position);
        holder.name.setText(mymatch.getName());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.click(mymatch.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return match.size();
    }

    public void add(Match match)
    {
        this.match.add(0,match);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        Button btn;
        ViewHolder(View view)
        {
            super(view);
            name = (TextView) view.findViewById(R.id.tv_name);
            btn =  (Button) view.findViewById(R.id.btnclick);
            /*status = (CheckBox) view.findViewById(R.id.cb_pending);*/
        }
    }

    public void reset()
    {
        match.clear();
        List<Match> matchList = new MatchData().ObtainListMatch();
        match.addAll(matchList);
        notifyDataSetChanged();
    }

}