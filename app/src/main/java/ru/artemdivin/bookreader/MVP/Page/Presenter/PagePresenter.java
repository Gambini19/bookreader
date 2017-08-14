package ru.artemdivin.bookreader.MVP.Page.Presenter;

import ru.artemdivin.bookreader.MVP.Book.Model.PageInteractor;
import ru.artemdivin.bookreader.MVP.Page.View.IPageView;

/**
 * Created by admin on 14.08.2017.
 */

public class PagePresenter implements IPagePresenter {
    IPageView view;
    PageInteractor interactor;

    public PagePresenter(IPageView view) {
        this.view = view;
        this.interactor = new PageInteractor();
    }


    @Override
    public void onGetNextPage() {

    }

    @Override
    public void onGetPrevPage() {

    }
}
