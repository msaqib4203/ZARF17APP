package cs2k18.com.zarf17;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by MSaqib on 08-01-2017.
 */

public class TabActivity extends AppCompatActivity {
    static boolean notific_received = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notific_received = true;
        Intent callingIntent = getIntent();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(callingIntent.getStringExtra("url")));
        startActivity(i);
    }
}
