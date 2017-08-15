package ru.artemdivin.bookreader.MVP.Start.Presenter;

import android.util.Log;
import android.webkit.URLUtil;

import java.io.File;
import java.util.ArrayList;

import ru.artemdivin.bookreader.Helper.IGetDialogResult;
import ru.artemdivin.bookreader.Entity.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Start.Model.ASyncInteractor;
import ru.artemdivin.bookreader.MVP.Start.View.IMainView;

/**
 * Created by Администратор on 08.08.2017.
 */

public class MainPresenter implements IMainPresenter, OnLoadBookFinishListener, IGetDialogResult, IReadyDataBookList {

    IMainView view;
    ASyncInteractor interactor;

    public MainPresenter(IMainView view) {
            this.view = view;
            this.interactor = new ASyncInteractor();
    }

    @Override
    public void onGetListFromRepo() {
        interactor.onGetRepositoryBookList(this);
    }

    @Override
    public void onGetBookByPath(String url) {



    }

    @Override
    public void onSuccessLoadBook(BookModelEntity modelEntities) {
        Log.d("onSuccessLoadBook", "onSuccessLoadBook");
        view.onAddBook(modelEntities);
    }

    @Override
    public void onFailedLoadBook(String error) {
        Log.d("onFAiledLoadBook", "onFailedLoadBook");
        view.onFailure(error);
    }


    @Override
    public void onGetBookPath(String path) {
         if (new File(path).isFile())
            interactor.onGetBookFromHTTP(this, path, true);

          else if (path.toLowerCase().endsWith(".txt"))
            interactor.onGetBookFromHTTP(this, path, false);



        else view.onFailure("не подходящий файл");
    }

    @Override
    public void onGetListBook(ArrayList<BookModelEntity> listBook) {
        view.onGetList(listBook);
    }
}
