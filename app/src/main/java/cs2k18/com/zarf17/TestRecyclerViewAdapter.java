package cs2k18.com.zarf17;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.elyeproj.loaderviewlibrary.LoaderImageView;

import java.util.ArrayList;

/**
 * Created by MSaqib on 26-10-2016.
 */
public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<Event> events;
    LayoutInflater inflater;

    public TestRecyclerViewAdapter(ArrayList<Event> events, Context context) {

        this.context = context;
        this.events = events;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int position) {
        View view = inflater.inflate(R.layout.list_item_card_small, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int position) {
        Glide.with(context).load(events.get(position).image_url).into(myViewHolder.poster);

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        LoaderImageView poster;

        public MyViewHolder(View itemView) {
            super(itemView);
            poster = (LoaderImageView) itemView.findViewById(R.id.event_poster);
        }
    }
}
