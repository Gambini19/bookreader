package ru.artemdivin.bookreader;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class BookApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);


        byte[] key = new byte[64];
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .encryptionKey(key)
                .build();

        Realm.setDefaultConfiguration(config);


    }
}
