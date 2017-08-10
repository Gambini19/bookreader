package ru.artemdivin.bookreader.Helper;

import android.os.AsyncTask;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by admin on 10.08.2017.
 */

public class SaverHelper extends AsyncTask<String, Void, Void>
{

    @Override
    protected Void doInBackground(String... strings) {
        File file = new File("http://tgftp.nws.noaa.gov/data/observations/metar/cycles/14Z.TXT");

        byte[] b = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
            for (int i = 0; i < b.length; i++) {
                System.out.print((char)b[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        }
        catch (IOException e1) {
            System.out.println("Error Reading The File.");
            e1.printStackTrace();
        }
        return null;
    }
}
