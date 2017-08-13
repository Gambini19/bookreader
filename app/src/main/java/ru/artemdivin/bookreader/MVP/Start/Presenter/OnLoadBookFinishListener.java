package ru.artemdivin.bookreader.MVP.Start.Presenter;

import io.realm.RealmResults;
import ru.artemdivin.bookreader.Entity.BookModelEntity;

/**
 * Created by admin on 10.08.2017.
 */

public interface OnLoadBookFinishListener {
    void onSuccessLoadBook(RealmResults<BookModelEntity> modelEntities);
    void onFailedLoadBook(String error);
}
