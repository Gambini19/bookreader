package ru.artemdivin.bookreader.MVP.View;

import java.util.ArrayList;

import io.realm.RealmResults;
import ru.artemdivin.bookreader.MVP.BookModelEntity;

/**
 * Created by Администратор on 08.08.2017.
 */

public interface IMainView {
    void onSuccess(RealmResults<BookModelEntity> modelEntities);
    void onFailore(String s);
}
