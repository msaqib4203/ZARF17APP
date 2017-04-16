package cs2k18.com.zarf17;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Developers extends AppCompatActivity {

    public ArrayList<Developer> developers = new ArrayList<>();
    public RecyclerView recyclerView;
    public DevAdapter devAdapter;
    private String dev_names[] = {"Mohammad Saqib", "Hashir Ahmad", "Aman Varshney", "Vanshika Varshney", "Abu Huzaifa Khan"};
    private int images_id[] = {R.drawable.blank_dp};
    private String facebook_url[];
    private String github_url[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        facebook_url = getResources().getStringArray(R.array.facebook_urls);
        github_url = getResources().getStringArray(R.array.github_urls);
        for (int i = 0; i < 5; i++)
            developers.add(new Developer(dev_names[i], images_id[0], facebook_url[i], github_url[i]));

        recyclerView = (RecyclerView) findViewById(R.id.developer_recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), 1, false));
        devAdapter = new DevAdapter(Developers.this, developers);
        recyclerView.setAdapter(devAdapter);
    }
}