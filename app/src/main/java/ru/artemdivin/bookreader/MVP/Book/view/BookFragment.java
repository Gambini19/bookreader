package ru.artemdivin.bookreader.MVP.Book.view;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.artemdivin.bookreader.Adapter.ViewPagerAdapter;
import ru.artemdivin.bookreader.R;

public class BookFragment extends Fragment implements IOpenerBook {
    private static final String ARG_POSITION = "ARG_POSITION";
    ViewPagerAdapter adapter;
    ViewPager pager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(adapter);


        return view;
    }

    public static BookFragment instance(String bookID) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_POSITION, bookID);

        BookFragment fragment = new BookFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onOpenBook() {

    }

    @Override
    public void onOpenBookFailed() {

    }


}