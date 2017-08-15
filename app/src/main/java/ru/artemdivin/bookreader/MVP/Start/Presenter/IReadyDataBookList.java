package ru.artemdivin.bookreader.MVP.Start.Presenter;

import java.util.ArrayList;

import ru.artemdivin.bookreader.Entity.BookModelEntity;

/**
 * Created by Администратор on 08.08.2017.
 */

public interface IReadyDataBookList {

         void onGetListBook(ArrayList<BookModelEntity> listBook);
    }

