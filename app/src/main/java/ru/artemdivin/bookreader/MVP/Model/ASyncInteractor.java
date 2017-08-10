package ru.artemdivin.bookreader.MVP.Model;

import io.realm.Realm;
import ru.artemdivin.bookreader.MVP.Presenter.IReadyDataBookList;
import ru.artemdivin.bookreader.MVP.Presenter.OnLoadBookFinishListener;

/**
 * Created by Администратор on 08.08.2017.
 */

public class ASyncInteractor implements IRepositoryData {

    @Override
    public void onGetRepositoryBookList(IReadyDataBookList listener) {

    }

    @Override
    public void onGetBookFromHTTP(OnLoadBookFinishListener listener, String url, boolean isLocal) {
        listener.onSuccessLoadBook();
    }
}
