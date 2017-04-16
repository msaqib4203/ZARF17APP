package cs2k18.com.zarf17;

/**
 * Created by HP on 16-04-2017.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class About extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        FloatingActionButton fab1, fab2, fab3;
        fab1 = (FloatingActionButton) findViewById(R.id.zarf_web);
        fab2 = (FloatingActionButton) findViewById(R.id.insta_zarf);
        fab3 = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent fbintent = new Intent(Intent.ACTION_VIEW);
                    fbintent.setData(Uri.parse("https://zarf.co.in/online"));
                    startActivity(fbintent);
                } catch (Exception e) {
                }
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent fbintent = new Intent(Intent.ACTION_VIEW);
                    fbintent.setData(Uri.parse("https://fb.com/zarf17"));
                    startActivity(fbintent);
                } catch (Exception e) {
                }
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent fbintent = new Intent(Intent.ACTION_VIEW);
                    fbintent.setData(Uri.parse("https://instagram.com/zarf17"));
                    startActivity(fbintent);
                } catch (Exception e) {
                }
            }
        });
    }
}