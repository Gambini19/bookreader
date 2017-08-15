package ru.artemdivin.bookreader.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import ru.artemdivin.bookreader.MVP.Page.View.PageFragment;


/**
 * Created by admin on 14.08.2017.
 */

public class ViewStatePagerAdapter  extends FragmentStatePagerAdapter {
        int countPage = 0;
        ArrayList<String> textpage;


        public ViewStatePagerAdapter (FragmentManager fm, int count, ArrayList<String> text) {
            super(fm);
            countPage = count;
            textpage = text;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(textpage.get(position));
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



