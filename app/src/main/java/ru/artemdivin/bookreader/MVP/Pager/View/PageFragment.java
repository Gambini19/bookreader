package ru.artemdivin.bookreader.MVP.Pager.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.artemdivin.bookreader.R;

/*
public class PageFragment extends Fragment {*/



/*    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false);
    }*/

    public class PageFragment extends Fragment {

        static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

        int pageNumber;
        int backColor;

        static PageFragment newInstance(int page) {
            PageFragment pageFragment = new PageFragment();
            Bundle arguments = new Bundle();
            arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
            pageFragment.setArguments(arguments);
            return pageFragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_page, null);
            TextView tvPage = (TextView) view.findViewById(R.id.tv_page_fragment);
            tvPage.setText("Page " + pageNumber);
            return view;
        }
    }


