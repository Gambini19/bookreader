package ru.artemdivin.bookreader.Helper;

import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

import io.realm.Realm;
import ru.artemdivin.bookreader.Entity.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Start.Presenter.OnLoadBookFinishListener;

/**
 * Created by admin on 15.08.2017.
 */

public class SaveFromInternet extends AsyncTask<String, Void, String> {
    HttpURLConnection httpUrl;
    String fileName;

    private OnLoadBookFinishListener onLoadBookFinishListener;

    public SaveFromInternet(OnLoadBookFinishListener onLoadBookFinishListener) {
        this.onLoadBookFinishListener = onLoadBookFinishListener;
    }


    @Override
    protected String doInBackground(String... params) {
        String bookName = "";
        try {
            URL netUrl = new URL(params[0]);
            httpUrl = (HttpURLConnection) netUrl.openConnection();
            InputStream is = httpUrl.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int len;
            byte[] data = new byte[1024];

            while ((len = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, len);
//                Log.d("buffer", buffer.toString());
            }

           byte[] newBook =  buffer.toByteArray();

           bookName = netUrl.toString().substring(netUrl.toString().lastIndexOf('/') + 1);


            Realm realm = Realm.getDefaultInstance();

            try{
                BookModelEntity entity = new BookModelEntity();

                entity.setAuthor(fileName);
                entity.setBookName(bookName);
                entity.setFavorite(true);
                entity.setFirstString("first string...");
                entity.setTimeCreation(Calendar.getInstance().getTimeInMillis());
                entity.setBook(newBook);

                realm.beginTransaction();
                realm.copyToRealm(entity);
                realm.commitTransaction();

            }finally {
                realm.close();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookName;
    }

    @Override
    protected void onPostExecute(String bookName) {
        super.onPostExecute(bookName);
        Log.d("done, bookName ", bookName);

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
