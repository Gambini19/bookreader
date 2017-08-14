package ru.artemdivin.bookreader.MVP.Book.Presenter;

import android.util.Log;

import ru.artemdivin.bookreader.MVP.Book.Model.PageInteractor;
import ru.artemdivin.bookreader.MVP.Book.View.IBookView;

/**
 * Created by admin on 14.08.2017.
 */

public class PagerPresenter implements IPagerPresenter, IGetBookPageCountandFirstpageListener {

    IBookView view;
    PageInteractor interactor;

    public PagerPresenter(IBookView view) {
        this.view = view;
        this.interactor = new PageInteractor();
    }

    @Override
    public void onGetPage(String bookName, int position) {
        interactor.onGetBookPageCountAndFirstPage(this, bookName, position );
    }

    @Override
    public void onGetNextPage(int position) {
       // interactor.onGetBookPageCountAndFirstPage();
       // interactor.onGetNextPage(position, this);
    }

    @Override
    public void OnGetPrevPage() {

    }

    @Override
    public void getBookPageCountandFirstpage(int count, byte[] firstPage, int currentPage) {
        Log.d("tpageListener", "IGetBookPageCountandFirstpageListener");
        view.onOpenBook(count, firstPage, currentPage);
    }
}
