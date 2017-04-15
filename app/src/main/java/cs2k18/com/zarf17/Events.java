package cs2k18.com.zarf17;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.grantland.widget.AutofitTextView;

public class Events extends DrawerActivity {


    public static int selected_tab = 0;
    public String events_category[] = {"Online", "Technical", "Cultural", "Literary", "Sports"};
    public int color_id[] = {R.color.green, R.color.blue, R.color.cyan, R.color.red, R.color.lime};
    public int url_string[] = {R.string.url1, R.string.url2, R.string.url3, R.string.url4,
            R.string.url5};
    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        setTitle("");
        ButterKnife.bind(this);
        /*Typeface type = Typeface.createFromAsset(getAssets(),"BOOKERLY-REGULAR.TTF");
        TextView tv = (TextView)findViewById(R.id.event_name);
        tv.setTypeface(type);*/
        final Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 5) {
                    case 4:
                        return RecyclerViewSportsFragment.newInstance();
                    default:
                        return RecyclerViewFragment.newInstance();
                }

            }

            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public CharSequence getPageTitle(int position) {

                return events_category[position % 5];

            }
        });

        final View logo = findViewById(R.id.logo_white);
        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                selected_tab = page;
                final AutofitTextView textView = (AutofitTextView) findViewById(R.id.logo_white);
                textView.setText(events_category[page].toUpperCase() + " EVENTS");
                return HeaderDesign.fromColorResAndUrl(color_id[page], getString(url_string[page]));
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());


        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    //Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
