package ru.artemdivin.bookreader.MVP.Presenter;

import java.util.ArrayList;

import io.realm.RealmResults;
import ru.artemdivin.bookreader.MVP.BookModelEntity;

/**
 * Created by admin on 10.08.2017.
 */

public interface OnLoadBookFinishListener {
    void onSuccessLoadBook(RealmResults<BookModelEntity> modelEntities);
    void onFailedLoadBook(String error);
}
