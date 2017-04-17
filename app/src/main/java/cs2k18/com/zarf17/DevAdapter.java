package cs2k18.com.zarf17;

/**
 * Created by MSaqib on 12-04-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DevAdapter extends RecyclerView.Adapter<DevAdapter.MyViewHolder> {

    private static final int DURATION = 250;
    Context context;
    ArrayList<Developer> developers;
    LayoutInflater inflater;

    public DevAdapter(Context context, ArrayList<Developer> developers) {

        this.context = context;
        this.developers = developers;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int position) {

        View view = inflater.inflate(R.layout.developer, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int position) {
        myViewHolder.name.setText(developers.get(position).name);
        myViewHolder.facebook_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent fbintent = new Intent(Intent.ACTION_VIEW);
                    fbintent.setData(Uri.parse(developers.get(position).facebook_url));
                    context.startActivity(fbintent);
                } catch (Exception e) {
                }
            }
        });

        myViewHolder.github_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent fbintent = new Intent(Intent.ACTION_VIEW);
                    fbintent.setData(Uri.parse(developers.get(position).github_url));
                    context.startActivity(fbintent);
                } catch (Exception e) {
                }
            }
        });
        try {
            Glide.with(context).load(developers.get(position).image).error(R.drawable.blank_dp).into(myViewHolder.imageView);
        } catch (Exception e) {

        }

    }

    @Override
    public int getItemCount() {
        return developers.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;
        FloatingActionButton facebook_button;
        FloatingActionButton github_button;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.dev_name);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            facebook_button = (FloatingActionButton) itemView.findViewById(R.id.dev_facebook);
            github_button = (FloatingActionButton) itemView.findViewById(R.id.dev_github);
        }
    }
}
