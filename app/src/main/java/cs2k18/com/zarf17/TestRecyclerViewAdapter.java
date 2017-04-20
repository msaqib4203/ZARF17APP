package cs2k18.com.zarf17;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        try {
            Glide.with(context).load(events.get(position).image_url).into(myViewHolder.poster);
        } catch (Exception e) {
        }

        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Description will be available soon!", Toast.LENGTH_SHORT).show();
            }
        });
        //Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/BOOKERLY-REGULAR.TTF");
        //myViewHolder.title.setTypeface(type);

        //myViewHolder.title.setText(events.get(position).name);
  /*      myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Description.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if(Build.VERSION.SDK_INT>=21) {
                    Pair pair = new Pair(myViewHolder.poster, myViewHolder.poster.getTransitionName());
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Events) context, pair);
                    context.startActivity(intent, options.toBundle());
                }else
                    context.startActivity(intent);
            }
        });
*/

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        LoaderImageView poster;

        CardView cardView;


        public MyViewHolder(View itemView) {
            super(itemView);
            poster = (LoaderImageView) itemView.findViewById(R.id.event_poster);
            cardView = (CardView) itemView.findViewById(R.id.card_view_event);
        }
    }
}
