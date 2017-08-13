package ru.artemdivin.bookreader.Helper;

import android.os.AsyncTask;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.artemdivin.bookreader.Entity.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Start.Presenter.OnLoadBookFinishListener;

/**
 * Created by admin on 10.08.2017.
 */

public class SaverHelper extends AsyncTask<String, Void, Void>
{
    private ArrayList<BookModelEntity> modelEntities = new ArrayList<>();
    private OnLoadBookFinishListener onLoadBookFinishListener;

    public SaverHelper(OnLoadBookFinishListener onLoadBookFinishListener) {
        this.onLoadBookFinishListener = onLoadBookFinishListener;
    }

    @Override
    protected Void doInBackground(String... strings) {
        File file = new File(strings[0]);
        file.isFile();

        byte[] b = new byte[(int) file.length()];
        try {
            RandomAccessFile f = new RandomAccessFile(file, "r");
            f.readFully(b);

            Log.d("BYTEEEEEEEEEEEEE", String.valueOf(b.length));

            Realm realm = Realm.getDefaultInstance();

            BookModelEntity entity = new BookModelEntity();
            entity.setAuthor("A");
            entity.setBookName("C");
            entity.setFavorite(true);
            entity.setFirstString("asadad");
            entity.setTimeCreation(0);
            entity.setBook(b);

       //     modelEntities.add(entity);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(entity);
            realm.commitTransaction();



            } catch (FileNotFoundException e) {
            e.printStackTrace();
            onLoadBookFinishListener.onFailedLoadBook("FILE_NOT_FOUND");
        } catch (IOException e) {
            e.printStackTrace();
            onLoadBookFinishListener.onFailedLoadBook("FAILORE");
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<BookModelEntity> result = realm.where(BookModelEntity.class).findAll();
        onLoadBookFinishListener.onSuccessLoadBook(result);

    }
}
