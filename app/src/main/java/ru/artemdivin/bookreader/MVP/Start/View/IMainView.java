package ru.artemdivin.bookreader.MVP.Start.View;

import ru.artemdivin.bookreader.Entity.BookModelEntity;

/**
 * Created by Администратор on 08.08.2017.
 */

public interface IMainView {
    void onSuccess(BookModelEntity modelEntities);
    void onFailore(String s);
}
