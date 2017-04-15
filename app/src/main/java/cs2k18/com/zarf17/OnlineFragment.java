package cs2k18.com.zarf17;

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
 * Created by HP on 15-04-2017.
 */

public class OnlineFragment extends Fragment {
    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 10;
    public ArrayList<Event> items = new ArrayList<>();

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    public static OnlineFragment newInstance() {
        return new OnlineFragment();
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

        String o_event[] = getResources().getStringArray(R.array.online_events);
        String o_name[] = getResources().getStringArray(R.array.online_events2);
        for (int i = 0; i < 13; ++i) {
            items.add(new Event(o_name[i], o_event[i]));
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
