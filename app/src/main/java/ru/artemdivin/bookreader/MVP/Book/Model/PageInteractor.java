package ru.artemdivin.bookreader.MVP.Book.Model;

import io.realm.Realm;
import ru.artemdivin.bookreader.Entity.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Book.Presenter.IGetBookPageCountandFirstpageListener;

/**
 * Created by admin on 14.08.2017.
 */

public class PageInteractor implements IPagerInteractor {

    @Override
    public void onGetBookPageCountAndFirstPage(IGetBookPageCountandFirstpageListener listener, String bookName, int position) {


        Realm r = Realm.getDefaultInstance();
        BookModelEntity entity = r.where(BookModelEntity.class)
                .contains("bookName", bookName)
                .findFirst();

        int countPage = entity.getBook().length / 200;

        String textPage = "";

        if (entity.getBook().length > 200)
        {
            textPage = new String(entity.getBook(), 100*(position+1), 650*(position+1) );}

        else { textPage = new String(entity.getBook(), 100*(position+1), entity.getBook().length );
        countPage = 1;
        }

        int currentPage = 1;


        listener.getBookPageCountandFirstpage(countPage, textPage.getBytes(), currentPage );
        r.close();
    }




}
