package ru.artemdivin.bookreader.MVP.Book.Model;

import java.util.ArrayList;

import io.realm.Realm;
import ru.artemdivin.bookreader.Entity.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Book.Presenter.IGetBookPageCountandFirstpageListener;

/**
 * Created by admin on 14.08.2017.
 */

public class PageInteractor implements IPagerInteractor {

    @Override
    public void onGetBookPageCountAndFirstPage(IGetBookPageCountandFirstpageListener listener, String bookName) {


        Realm r = Realm.getDefaultInstance();
        BookModelEntity entity = r.where(BookModelEntity.class)
                .contains("bookName", bookName)
                .findFirst();

        //int countPage =  entity.getBook().length / 200;

        BookModelEntity bookEntity = r.copyFromRealm(entity);
        byte[] book = bookEntity.getBook();

        ArrayList<String> pageOfBook = new ArrayList<>();
        String text = "";
        for (int i = 0;i < book.length ; i++) {
            text += (char)book[i];
            if (text.length() == 1000)
            {
                pageOfBook.add(text);
                text = "";
            }
        }
        pageOfBook.add(text);
        listener.getBookPageCountandFirstpage(pageOfBook.size(), pageOfBook );
        r.close();
    }




}
