package ru.artemdivin.bookreader.MVP.Pager.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.artemdivin.bookreader.R;

import static ru.artemdivin.bookreader.MVP.Pager.View.ViewPagerFragment.PAGE_COUNT;


public class ViewPagerFragment extends Fragment {


    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }*/


    static final String TAG = "myLogs";
    static final int PAGE_COUNT = 10;

    ViewPager pager;
    PagerAdapter pagerAdapter;

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view  = inflater.inflate(R.layout.fragment_view_pager, container, false);
         pager = (ViewPager) view.findViewById(R.id.pager);
         pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
         pager.setAdapter(pagerAdapter);



        return view;
    }

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_view_pager);

        pager = (ViewPager) view.findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        pager.setAdapter(pagerAdapter);*/

   /*     pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected, position = " + position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });*/
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

    }


