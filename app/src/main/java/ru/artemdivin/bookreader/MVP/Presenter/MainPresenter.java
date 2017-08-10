package ru.artemdivin.bookreader.MVP.Presenter;

import android.webkit.URLUtil;

import java.io.File;

import ru.artemdivin.bookreader.MVP.Model.ASyncInteractor;
import ru.artemdivin.bookreader.MVP.View.IMainView;

/**
 * Created by Администратор on 08.08.2017.
 */

public class MainPresenter implements IMainPresenter, OnLoadBookFinishListener {

    IMainView view;
    ASyncInteractor interactor;

    public MainPresenter(IMainView view) {
            this.view = view;
            this.interactor = new ASyncInteractor();
    }

    @Override
    public void onGetListFromRepo() {




    }

    @Override
    public void onGetBookByPath(String url) {
        if (URLUtil.isHttpsUrl(url))
            interactor.onGetBookFromHTTP(this, url, false);

        else if (new File(url).isFile())
            interactor.onGetBookFromHTTP(this, url, true);

    }

    @Override
    public void onSuccessLoadBook() {

    }

    @Override
    public void onFailedLoadBook() {

    }
}
