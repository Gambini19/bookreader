package ru.artemdivin.bookreader.Helper;

import android.os.AsyncTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import io.realm.Realm;
import ru.artemdivin.bookreader.MVP.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Presenter.OnLoadBookFinishListener;

/**
 * Created by admin on 10.08.2017.
 */

public class SaverHelper extends AsyncTask<String, Void, Void>
{
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

            Realm realm = Realm.getDefaultInstance();

            BookModelEntity entity = new BookModelEntity();
            entity.setBook(b);
            realm.beginTransaction();
            realm.copyToRealm(entity);
            realm.commitTransaction();
            realm.close();


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
        onLoadBookFinishListener.onSuccessLoadBook();
    }
}
