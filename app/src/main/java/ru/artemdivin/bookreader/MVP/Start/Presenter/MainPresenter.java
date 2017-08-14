package ru.artemdivin.bookreader.MVP.Start.Presenter;

import android.util.Log;
import android.webkit.URLUtil;

import java.io.File;

import io.realm.RealmResults;
import ru.artemdivin.bookreader.Helper.IGetDialogResult;
import ru.artemdivin.bookreader.Entity.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Start.Model.ASyncInteractor;
import ru.artemdivin.bookreader.MVP.Start.View.IMainView;

/**
 * Created by Администратор on 08.08.2017.
 */

public class MainPresenter implements IMainPresenter, OnLoadBookFinishListener, IGetDialogResult {

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



    }

    @Override
    public void onSuccessLoadBook(RealmResults<BookModelEntity> modelEntities) {
        Log.d("onSuccessLoadBook", "onSuccessLoadBook");
        view.onSuccess(modelEntities);
    }

    @Override
    public void onFailedLoadBook(String error) {
        Log.d("onFAiledLoadBook", "onFailedLoadBook");
        view.onFailore(error);
    }


    @Override
    public void onGetBookPath(String path) {
        if (URLUtil.isHttpsUrl(path) || path.endsWith(".html"))
            interactor.onGetBookFromHTTP(this, path, false);

        else if (new File(path).isFile())
            interactor.onGetBookFromHTTP(this, path, true);

        else view.onFailore("не подходящий файл");
    }
}
