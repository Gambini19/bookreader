package ru.artemdivin.bookreader.MVP.Book.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.artemdivin.bookreader.Adapter.ViewStatePagerAdapter;
import ru.artemdivin.bookreader.MVP.Book.Presenter.PagerPresenter;
import ru.artemdivin.bookreader.R;


public class ViewPagerFragment extends Fragment implements IBookView {
    ViewPager pager;
    PagerAdapter pagerAdapter;
    PagerPresenter presenter;
    String bookName = "";


    public ViewPagerFragment() {
    }

    public static  ViewPagerFragment instance(String bookName){
        Bundle b = new Bundle();
        b.putString("BOOK_NAME", bookName);

        ViewPagerFragment fr = new ViewPagerFragment();
        fr.setArguments(b);
        return fr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        pager = (ViewPager) view.findViewById(R.id.view_pager);
        bookName = getArguments().getString("BOOK_NAME");

        presenter = new PagerPresenter(this);

        presenter.onGetPage(bookName, 0);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("ON_PAGE_SCROLLED", "ON_PAGE_SCROLLED" + position + " " + positionOffset);

                presenter.onGetPage(bookName, position);

            }

            @Override
            public void onPageSelected(int position) {

                Log.d("ON_PAGE_SCROLLED", "ON_PAGE_SCROLLED " + position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d(" onPageScrollStateC", "State " + state);
            }
        });

        return view;
    }


    @Override
    public void onOpenBook(int count, byte[] textPage, int currentPage) {
        //pagerAdapter = new ViewStatePagerAdapter(getChildFragmentManager(), count, textPage );
        pagerAdapter = new ViewStatePagerAdapter(getChildFragmentManager(), count, textPage );
        pager.setAdapter(pagerAdapter);
    }


}



