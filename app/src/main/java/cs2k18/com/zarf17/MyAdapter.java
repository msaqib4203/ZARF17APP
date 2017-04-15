package cs2k18.com.zarf17;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by MSaqib on 26-10-2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Member> members;
    LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<Member> members) {

        this.context = context;
        this.members = members;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int position) {
        View view = inflater.inflate(R.layout.member, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int position) {

        myViewHolder.designation.setText(members.get(position).post);
        myViewHolder.title.setText(members.get(position).name);
        myViewHolder.contact_info.setText(members.get(position).contact);
        Glide.with(context).load(members.get(position).url).placeholder(R.drawable.blank_dp)
                .error(R.drawable.blank_dp).into(myViewHolder.photo);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView designation;
        CircleImageView photo;
        TextView contact_info;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.faculty_name);
            designation = (TextView) itemView.findViewById(R.id.designation);
            photo = (CircleImageView) itemView.findViewById(R.id.team_photo);
            contact_info = (TextView) itemView.findViewById(R.id.contact_no);
        }
    }
}
