package ru.artemdivin.bookreader.Helper;


import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class FileHelper {





    void reformatText(Activity a) {

        Point size =new Point();
        a.getWindowManager().getDefaultDisplay().getSize(size);
    /*    int stageWidth = p.getWidth();
        int stageHeight = p.getHeight();*/


/*
        Display display = context.getWindowManager().getDefaultDisplay();
        stageWidth = display.getWidth();
        stageHeight = display.getHeigth();


    Display display = getWindowManager().getDefaultDisplay();
    int width = display.getWidth();
    int height = (int) (display.getHeight() - 0.24 * display.getHeight());
    mLinesInPage =(int)(Math.floor(height /mTextSize));
    mPages =(int)(Math.ceil(mLinesInText /mLinesInPage));*/
}
}
