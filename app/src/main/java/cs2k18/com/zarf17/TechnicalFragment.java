package cs2k18.com.zarf17;

/**
 * Created by MSaqib on 10-04-2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class TechnicalFragment extends Fragment {

    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 10;
    public ArrayList<Event> items = new ArrayList<>();

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    public static TechnicalFragment newInstance() {
        return new TechnicalFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        items.removeAll(items);
        //Toast.makeText(getContext(), String.valueOf(Events.selected_tab), Toast.LENGTH_SHORT).show();

        String tech_event[] = getResources().getStringArray(R.array.tech_events);
        String tech_name[] = getResources().getStringArray(R.array.tech_events2);
        for (int i = 0; i < 25; ++i) {
            items.add(new Event(tech_name[i], "x"));
        }


        //setup materialviewpager

        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(new TestRecyclerViewAdapter(items, view.getContext()));
    }
}