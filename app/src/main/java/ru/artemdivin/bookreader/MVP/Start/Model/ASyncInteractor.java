package ru.artemdivin.bookreader.MVP.Start.Model;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.artemdivin.bookreader.Entity.BookModelEntity;
import ru.artemdivin.bookreader.Helper.SaveFromInternet;
import ru.artemdivin.bookreader.Helper.SaverHelper;
import ru.artemdivin.bookreader.MVP.Start.Presenter.IReadyDataBookList;
import ru.artemdivin.bookreader.MVP.Start.Presenter.OnLoadBookFinishListener;


public class ASyncInteractor implements IRepositoryData {


    @Override
    public void onGetRepositoryBookList(IReadyDataBookList listener) {
        Realm realm = Realm.getDefaultInstance();
        try {
            RealmResults<BookModelEntity> list = realm.where(BookModelEntity.class).findAll();
            ArrayList<BookModelEntity> listBook = (ArrayList<BookModelEntity>) realm.copyFromRealm(list);
            listener.onGetListBook(listBook);
        }finally {
            realm.close();
        }

    }

    @Override
    public void onGetBookFromHTTP(OnLoadBookFinishListener listener, String url, boolean isLocal) {
        if (isLocal)
        {   SaverHelper helper = new SaverHelper(listener);
            helper.execute(url);

        }
        else {
            SaveFromInternet saver = new SaveFromInternet(listener);
            saver.execute(url);
        }


    }
}
