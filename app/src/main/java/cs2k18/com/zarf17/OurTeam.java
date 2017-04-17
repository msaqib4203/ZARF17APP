package cs2k18.com.zarf17;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by MSaqib on 09-04-2017.
 */

public class OurTeam extends AppCompatActivity {
    static ArrayList<Member> members = new ArrayList<>();
    public String names[] = {"Mohannad Ali Khan","Shahbaz Ahmad","Shivani Shrotriya","Madiha Mariyam",
            "Mohd. Faisal Noor","Saiful Wali Khan","Mohd. Shavez Khan","Mohd. Yaqzan","Taha Waseem",
            "Mohd. Zubair", "Anas Abdullah", "Iffat Alam", "Bilal Khan Sherwani", "Safiul Haque", "Mohd. Amir Khan",
            "Mohd. Faizan", "Kunaal Khemani", "Danish Khan", "Arsam Naim", "Zeeshan Shahab", "Osama Aslam", "Amir Ishaq"};
    public String post[] = {"Convener", "Co-Convener", "Girl's Coordinator", "Girl's Co-Coordinator", "Literary Coordinator", "Literary Co-Coordinator",
            "Cultural Coordinator", "Cultural Co-Coordinator", "Technical Coordinator", "Technical Co-Coordinator",
            "Coordinator, Q.Incharge","Co-Coordinator, Q.Incharge","Sports Coordinator","Sports Co-Coordinator","DC, Coordinator",
            "Creative Coordinator", "Creative Co-Coordinator", "P.R.O", "EDC Coordinator", "EDC Co-Coordinator", "Online Coordinator"
            , "Online Co-Coordinator"};
    public String mob[] = {"8979849800", "9456865614", "9456614401", "N/A", "9528243119", "7417725971", "7895167747", "7535040540",
            "7895172099", "7599388153", "8171318385", "N/A", "9997444906", "9058631890", "8791472934", "8604222134", "7417194719",
            "9045179288", "9045674714", "8791410956", "9045759481", "7417389656"};
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        members.removeAll(members);
        for (int i = 0; i < 22; i++) {
            members.add(new Member(names[i], post[i], i + 1, mob[i]));
        }
        setContentView(R.layout.ourteam);
        CoordinatorLayout cd = (CoordinatorLayout) findViewById(R.id.cd_team);
        Snackbar.make(cd, "Select card to call number", Snackbar.LENGTH_SHORT).show();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),1,false));
        myAdapter = new MyAdapter(OurTeam.this,members);
        recyclerView.setAdapter(myAdapter);
    }
}

