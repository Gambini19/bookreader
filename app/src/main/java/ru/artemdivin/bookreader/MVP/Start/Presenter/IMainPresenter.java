package ru.artemdivin.bookreader.MVP.Start.Presenter;

/**
 * Created by Администратор on 08.08.2017.
 */

public interface IMainPresenter {
    void onGetListFromRepo();
    void onGetBookByPath(String url);

}
