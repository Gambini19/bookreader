package ru.artemdivin.bookreader.MVP.Book.Model;

import ru.artemdivin.bookreader.MVP.Book.Presenter.IGetBookPageCountandFirstpageListener;

/**
 * Created by admin on 14.08.2017.
 */

public interface IPagerInteractor {
    void onGetBookPageCountAndFirstPage(IGetBookPageCountandFirstpageListener listener, String bookName, int position);

}
