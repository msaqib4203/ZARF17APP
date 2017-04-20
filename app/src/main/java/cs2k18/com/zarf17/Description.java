package cs2k18.com.zarf17;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by MSaqib on 20-04-2017.
 */

public class Description extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= 21)
            this.requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        Toast.makeText(this, getIntent().getStringExtra("poster_url"), Toast.LENGTH_SHORT).show();
        ImageView imageView = (ImageView) findViewById(R.id.event_poster);
        // Glide.with(this).load(getIntent().getStringExtra("poster_url")).into(imageView);
    }
}
