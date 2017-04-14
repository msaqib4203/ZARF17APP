package cs2k18.com.zarf17;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by MSaqib on 09-04-2017.
 */

public class OurTeam extends AppCompatActivity {


    static ArrayList<Member> members = new ArrayList<>();
    public String names[] = {"Mohannad Ali Khan", "Shahbaz Ahmad", "Shivani Shrotriya", "Madiha Mariyam", "Mohd. Shavez Khan",
            "Mohd. Yaqzan", "Mohd. Faisal Noor", "Saiful Wali Khan", "Taha Waseem",
            "Mohd. Zubair", "Anas Abdullah", "Iffat Alam", "Mohd. Bilal Khan Sherwani", "Saiful Haque", "Mohd. Amir Khan",
            "Mohd. Faizan", "Kunaal Khemani", "Danish Khan", "Arsam Naim", "Zeeshan Shahab", "Osama Aslam"};

    public String post[] = {"Convener", "Co-Convener", "Girl's Coordinator", "Girl's Co-Coordinator", "Cultural Coordinator", "Cultural Co-Coordinator",
            "Literary Coordinator", "Literary Co-Coordinator", "Technical Coordinator", "Technical Co-Coordinator",
            "Coordinator, Q.Incharge", "Co-Coordinator, Q.Incharge", "Sports Coordinator", "Sports Co-Coordinator", "DC, Coordinator",
            "Creative Coordinator", "Creative Co-Coordinator", "P.R.O", "EDC Coordinator", "EDC Co-Coordinator", "Online Coordinator"};

    public String mob[] = {"8979849800", "9456865614", "null", "null", "7895167747", "7535040540", "9528243119", "7417725973",
            "7895172099", "7599388153", "8171318385", "null", "9997444906", "8439196335", "8791472934", "8604222134", "7417194719",
            "9045179288", "9045674714", "8791410956", "9045759481"};
    RecyclerView recyclerView;
    TeamAdapter myAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i=0;i<11;i++){
            members.add(new Member(names[i], post[i], i + 1, mob[i]));
        }
        setContentView(R.layout.ourteam);
        //getSupportActionBar().setHomeButtonEnabled(true);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),1,false));
        myAdapter = new TeamAdapter(OurTeam.this, members);
        recyclerView.setAdapter(myAdapter);

      //  makeSnack();
    }
}

