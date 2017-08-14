package ru.artemdivin.bookreader.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ru.artemdivin.bookreader.MVP.Page.View.PageFragment;


/**
 * Created by admin on 14.08.2017.
 */

public class ViewStatePagerAdapter  extends FragmentStatePagerAdapter {
        int countPage = 0;
        byte[] mastext;


        public ViewStatePagerAdapter (FragmentManager fm, int count, byte[] text) {
            super(fm);
            countPage = count;
            mastext = text;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(mastext);
        }

        @Override
        public int getCount() {
            return countPage;
        }

    @Override
    public CharSequence getPageTitle(int position) {

        return "Страница " + (position+1) ;

    }



}



