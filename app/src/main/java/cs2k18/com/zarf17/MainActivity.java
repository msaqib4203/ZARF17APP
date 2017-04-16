package cs2k18.com.zarf17;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
/** mergin test by msaqib*/
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EditText email_msg = null, name_msg = null, feedback_msg = null;
    PanoramaImageView panoramaImageView1;
    CardView cardView1;
    EditText name, contact, query;
    AlertDialog.Builder builder;
    SliderLayout mDemoSlider;
    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond;
    private TextView tvEvent;
    private Handler handler;
    private Runnable runnable;
    private GyroscopeObserver gyroscopeObserver;

    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    Date futureDate = dateFormat.parse("2017-04-17");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtTimerDay.setText("" + String.format("%02d", days));
                        txtTimerHour.setText("" + String.format("%02d", hours));
                        txtTimerMinute.setText(""
                                + String.format("%02d", minutes));
                        txtTimerSecond.setText(""
                                + String.format("%02d", seconds));
                    } else {
                        tvEvent.setVisibility(View.VISIBLE);
                        tvEvent.setText("The event started!");
                        textViewGone();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTimerDay = (TextView) findViewById(R.id.txtTimerDay);
        txtTimerHour = (TextView) findViewById(R.id.txtTimerHour);
        txtTimerMinute = (TextView) findViewById(R.id.txtTimerMinute);
        txtTimerSecond = (TextView) findViewById(R.id.txtTimerSecond);
        //tvEvent = (TextView) findViewById(R.id.tvhappyevent);
        countDownStart();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        gyroscopeObserver = new GyroscopeObserver();
        gyroscopeObserver.setMaxRotateRadian(Math.PI/9);
        panoramaImageView1 = (PanoramaImageView) findViewById(R.id.panorama_image_view1);
        cardView1 = (CardView)findViewById(R.id.cardview1);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fadein);
        cardView1.startAnimation(animation);
        panoramaImageView1.setGyroscopeObserver(gyroscopeObserver);


        //panoramaImageView2.setGyroscopeObserver(gyroscopeObserver);
        //panoramaImageView3.setGyroscopeObserver(gyroscopeObserver);
    }

    public void textViewGone() {
        findViewById(R.id.LinearLayout10).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout11).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout12).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout13).setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register GyroscopeObserver.
        gyroscopeObserver.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister GyroscopeObserver.
        gyroscopeObserver.unregister();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about_app) {
            LayoutInflater layoutInflater = getLayoutInflater();
            new AlertDialog.Builder(this)
                    .setView(layoutInflater.inflate(R.layout.dialog_layout2, null))
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            return true;
        }

        if (id == R.id.rate_app) {
            try {
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("market://details?id=cs2k18.com.zarf17"));
                startActivity(intent1);
            } catch (Exception e) {
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_events) {
            //Toast.makeText(this,"Will be updated soon....!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Events.class));
        } else if (id == R.id.nav_team) {
            startActivity(new Intent(this,OurTeam.class));
        } else if (id == R.id.nav_developer) {
            startActivity(new Intent(this,Developers.class));
        } else if (id == R.id.nav_query) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            builder = new AlertDialog.Builder(this);
            LayoutInflater layoutInflater = getLayoutInflater();
            builder.setView(layoutInflater.inflate(R.layout.dialog_layout,null));
            AlertDialog dialog = null;
            //  EditText email_msg=null,name_msg=null,feedback_msg=null;
            builder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            String email, name, feedback;
                            if (email_msg.getText().toString().trim().equals("")
                                    || feedback_msg.getText().toString().trim().equals("") ||
                                    name_msg.getText().toString().trim().equals("")) {
                                CoordinatorLayout cd = (CoordinatorLayout) findViewById(R.id.cd);
                                Snackbar.make(cd, "All fields are required", Snackbar.LENGTH_SHORT).show();
                                return;
                            } else {
                                email = email_msg.getText().toString();
                                name = name_msg.getText().toString();
                                feedback = feedback_msg.getText().toString();
                                new myTask(email, name, feedback).execute();
                            }

                            dialog.dismiss();
                        }
                    });
            builder.setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();
                        }
                    });
            dialog = builder.create();
            dialog.show();
            email_msg = (EditText) dialog.findViewById(R.id.query_contact);
            name_msg = (EditText) dialog.findViewById(R.id.query_name);
            feedback_msg = (EditText) dialog.findViewById(R.id.query_feedback);
            return true;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class myTask extends AsyncTask<Void, Void, Void> {

        String name, email, feedback;
        String response;
        boolean success = true;
        int count = -1;

        public myTask(String a, String b, String c) {
            this.name = a;
            this.email = b;
            this.feedback = c;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect("https://msaqib.000webhostapp.com/events/query.php?name=" + name + "&contact=" + email +
                        "&feedback=" + feedback).timeout(8000).get();
                response = doc.outerHtml();

            } catch (Exception e) {
                success = false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            if (success) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
            }
            super.onPostExecute(aVoid);

        }

    }
}

