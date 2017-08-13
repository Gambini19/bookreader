package ru.artemdivin.bookreader.MVP.Start.Model;

import ru.artemdivin.bookreader.Helper.SaverHelper;
import ru.artemdivin.bookreader.MVP.Start.Presenter.IReadyDataBookList;
import ru.artemdivin.bookreader.MVP.Start.Presenter.OnLoadBookFinishListener;


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
