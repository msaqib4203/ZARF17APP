package cs2k18.com.zarf17;

/**
 * Created by HP on 16-04-2017.
 */

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class About extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/BOOKERLY-REGULAR.TTF");
        //TextView tv = (TextView)findViewById(R.id.desc);


    }
}