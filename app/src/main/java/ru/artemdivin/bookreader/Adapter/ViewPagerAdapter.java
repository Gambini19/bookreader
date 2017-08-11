package ru.artemdivin.bookreader.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ru.artemdivin.bookreader.MVP.Book.view.BookFragment;

/**
 * Created by admin on 11.08.2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
        public int getCount() {
            return 10;
        }


        @Override
        public Fragment getItem(int position) {
            return new BookFragment();
        }
    }

