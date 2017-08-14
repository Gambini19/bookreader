package ru.artemdivin.bookreader.MVP.Page.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.artemdivin.bookreader.MVP.Book.View.IBookView;
import ru.artemdivin.bookreader.MVP.Page.Presenter.PagePresenter;
import ru.artemdivin.bookreader.R;



    public class PageFragment extends Fragment implements IPageView {

        static final String ARGUMENT_PAGE_TEXT = "arg_page_text";
        private PagePresenter presenter;
        private byte[] firstPage;
        private byte[] nextP;


        public static PageFragment newInstance(byte[] page) {
            PageFragment pageFragment = new PageFragment();
            Bundle arguments = new Bundle();
            arguments.putByteArray(ARGUMENT_PAGE_TEXT, page);
            pageFragment.setArguments(arguments);
            return pageFragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            firstPage = getArguments().getByteArray(ARGUMENT_PAGE_TEXT);
            presenter = new PagePresenter(this);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_page, null);
            TextView tvPage = (TextView) view.findViewById(R.id.tv_page_fragment);
            String s = "";
            for (int i = 0; i < firstPage.length ; i++) {
                          s+=(char) firstPage[i];
            }

            tvPage.setText("Page " + s);
          //  tvPage.setText(s);
            return view;
        }




        @Override
        public void onGetNextPage() {
            presenter.onGetNextPage();
        }

        @Override
        public void onGetPrevPage() {

        }
    }


