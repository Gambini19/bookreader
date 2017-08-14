package ru.artemdivin.bookreader.MVP.Book.Presenter;

/**
 * Created by admin on 14.08.2017.
 */

interface IPagerPresenter {
    void onGetPage(String bookName, int position);
    void onGetNextPage(int position);
    void OnGetPrevPage();
}
