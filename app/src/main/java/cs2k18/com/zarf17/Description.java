package cs2k18.com.zarf17;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.elyeproj.loaderviewlibrary.LoaderImageView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by MSaqib on 20-04-2017.
 */

public class Description extends AppCompatActivity {
    TextView textView;
    SharedPreferences myPrefs;
    LoaderImageView imageView2;
    String event_name;
    String url_name;
    Toolbar toolbar;
    CardView cardView;
    SwipeRefreshLayout swipeRefreshLayout;
    private SimpleTarget target2 = new SimpleTarget<Bitmap>(350, 170) {

        @Override
        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
            cardView.setVisibility(View.VISIBLE);
            imageView2.setImageBitmap(resource);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= 21)
            this.requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        event_name = getIntent().getStringExtra("event_name");
        toolbar = (Toolbar) findViewById(R.id.description_toolbar);
        toolbar.setTitle(event_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cardView = (CardView) findViewById(R.id.card_view_event_desc);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        LoaderImageView imageView = (LoaderImageView) findViewById(R.id.event_poster);
        Glide.with(this).load(getIntent().getStringExtra("url")).into(imageView);
        imageView2 = (LoaderImageView) findViewById(R.id.event_poster_desc);
        url_name = event_name.replaceAll(" ", "_");
        url_name = url_name.toLowerCase();
        Glide.with(this).load("https://msaqib.000webhostapp.com/description/" + url_name + ".jpg").asBitmap().
                into(target2);
        textView = (TextView) findViewById(R.id.event_description);
        myPrefs = this.getSharedPreferences("myPrefs", MODE_PRIVATE);
        String prefName = myPrefs.getString(getIntent().getStringExtra("event_name"), null);
        if (prefName == null) {
            swipeRefreshLayout.setRefreshing(true);
            new myTask(getIntent().getStringExtra("event_name")).execute();
        } else
            textView.setText(prefName);

    }

    private class myTask extends AsyncTask<Void, Void, Void> {

        String body = "";
        String name;

        public myTask(String x) {
            name = x;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect("https://msaqib.000webhostapp.com/description/" + url_name + ".txt").timeout(7000).get();
                this.body = doc.text();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            String no = "No description available!";
            if (this.body.length() > 0) {
                String[] tempText = body.split("xxx");
                String desc = "";
                for (String c : tempText)
                    desc += c + "\n\n";
                textView.setText(desc);
                SharedPreferences.Editor prefsEditor = myPrefs.edit();
                prefsEditor.putString(getIntent().getStringExtra("event_name"), desc);
                prefsEditor.apply();
            } else if (this.body.length() == 0)
                textView.setText(no);
            else
                Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();
            swipeRefreshLayout.setRefreshing(false);


            super.onPostExecute(aVoid);
        }
    }
}
