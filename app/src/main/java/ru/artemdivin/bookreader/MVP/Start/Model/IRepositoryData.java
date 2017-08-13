package ru.artemdivin.bookreader.MVP.Start.Model;

import ru.artemdivin.bookreader.MVP.Start.Presenter.IReadyDataBookList;
import ru.artemdivin.bookreader.MVP.Start.Presenter.OnLoadBookFinishListener;

/**
 * Created by Администратор on 08.08.2017.
 */

public interface IRepositoryData {
    void onGetRepositoryBookList(IReadyDataBookList listener);
    void onGetBookFromHTTP(OnLoadBookFinishListener listener, String url, boolean isLocal);
}
