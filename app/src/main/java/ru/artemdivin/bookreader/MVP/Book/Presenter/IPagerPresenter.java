package ru.artemdivin.bookreader.MVP.Book.Presenter;

/**
 * Created by admin on 14.08.2017.
 */

interface IPagerPresenter {
    void onGetBook(String bookName);
    void onGetNextPage(int position);
    void OnGetPrevPage();
}
