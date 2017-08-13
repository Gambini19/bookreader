package ru.artemdivin.bookreader.Entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Администратор on 08.08.2017.
 */

public class BookModelEntity extends RealmObject {
    @PrimaryKey
    private String bookName;
    private String author;
    private String firstString;
    private byte[] book;
    private  long timeCreation;
    private boolean isFavorite;


    public String getAuthor() {return author;}

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getFirstString() {
        return firstString;
    }

    public void setFirstString(String firstString) {
        this.firstString = firstString;
    }

    public byte[] getBook() {
        return book;
    }

    public void setBook(byte[] book) {
        this.book = book;
    }

    public long getTimeCreation() {
        return timeCreation;
    }

    public void setTimeCreation(long timeCreation) {
        this.timeCreation = timeCreation;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
