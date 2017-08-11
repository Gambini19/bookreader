package ru.artemdivin.bookreader.MVP.Model;

import io.realm.Realm;
import ru.artemdivin.bookreader.Helper.SaverHelper;
import ru.artemdivin.bookreader.MVP.Presenter.IReadyDataBookList;
import ru.artemdivin.bookreader.MVP.Presenter.OnLoadBookFinishListener;


public class ASyncInteractor implements IRepositoryData {


    @Override
    public void onGetRepositoryBookList(IReadyDataBookList listener) {

    }

    @Override
    public void onGetBookFromHTTP(OnLoadBookFinishListener listener, String url, boolean isLocal) {
        SaverHelper helper = new SaverHelper(listener);
        helper.execute(url);

    }
}
