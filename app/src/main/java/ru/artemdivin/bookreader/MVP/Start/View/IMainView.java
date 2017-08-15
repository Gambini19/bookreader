package ru.artemdivin.bookreader.MVP.Start.View;

import java.util.ArrayList;

import ru.artemdivin.bookreader.Entity.BookModelEntity;

/**
 * Created by Администратор on 08.08.2017.
 */

public interface IMainView {
    void onGetList(ArrayList<BookModelEntity> modelEntities);
    void onAddBook(BookModelEntity modelEntities);
    void onFailure(String s);
}
