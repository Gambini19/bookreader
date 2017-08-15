package ru.artemdivin.bookreader.Helper;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.artemdivin.bookreader.Entity.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Start.Presenter.OnLoadBookFinishListener;

/**
 * Created by admin on 10.08.2017.
 */

public class SaverHelper extends AsyncTask<String, Object, String>
{

    private OnLoadBookFinishListener onLoadBookFinishListener;

    public SaverHelper(OnLoadBookFinishListener onLoadBookFinishListener) {
        this.onLoadBookFinishListener = onLoadBookFinishListener;
    }

    @Override
    protected String doInBackground(String... strings) {
        File file = new File(strings[0]);


        byte[] b = new byte[(int) file.length()];
        try {
            RandomAccessFile f = new RandomAccessFile(file, "r");
            f.readFully(b);

            BufferedReader br = new BufferedReader(new FileReader(file));

            int c = 0;
            while ((c = br.read()) >=0 )
            {
                String s = br.readLine();
                //Log.d("s", s);


            }



            Log.d("BYTEEEEEEEEEEEEE", String.valueOf(b.length));

            Realm realm = Realm.getDefaultInstance();

            try{
                BookModelEntity entity = new BookModelEntity();

            entity.setAuthor(file.getName());
            entity.setBookName(file.getName());
            entity.setFavorite(true);
            entity.setFirstString("first string...");
            entity.setTimeCreation(Calendar.getInstance().getTimeInMillis());
            entity.setBook(b);

            realm.beginTransaction();
            realm.copyToRealm(entity);
            realm.commitTransaction();

            }finally {
                realm.close();
            }
            }
            catch (FileNotFoundException e) {
            e.printStackTrace();
            onLoadBookFinishListener.onFailedLoadBook("FILE_NOT_FOUND");
        } catch (IOException e) {
            e.printStackTrace();
            onLoadBookFinishListener.onFailedLoadBook("FAILURE");
        }

        return file.getName();
    }

    @Override
    protected void onPostExecute(String bookName) {
        Realm realm = Realm.getDefaultInstance();
        try {
            BookModelEntity book = realm.where(BookModelEntity.class).equalTo("bookName", bookName).findFirst();
            BookModelEntity newBook = realm.copyFromRealm(book);
            onLoadBookFinishListener.onSuccessLoadBook(newBook);
        }finally {
            realm.close();
        }

        }
}

