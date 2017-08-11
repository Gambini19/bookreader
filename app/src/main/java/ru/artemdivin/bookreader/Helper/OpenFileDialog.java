package ru.artemdivin.bookreader.Helper;

/**
 * Created by admin on 11.08.2017.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 * Created by admin on 20.07.2017.
 */


public class OpenFileDialog {
    private List<File> files = new ArrayList<>();
    private String currentPath = Environment.getExternalStorageDirectory().getPath();
    private AlertDialog alertDialog;
    private AlertDialog.Builder dialog;
    private IGetDialogResult iGetDialogResult;

    public OpenFileDialog(IGetDialogResult i) {
        iGetDialogResult = i;
    }

    public OpenFileDialog() {
    }

    public AlertDialog onCreateDialog(Context context){
        dialog = new AlertDialog.Builder(context);
        files.addAll(getFiles(currentPath));
        dialog.setNegativeButton(android.R.string.cancel,null);
        ListView listView = createListView(context);
        listView.setAdapter(new FileAdapter(context, files));
        dialog.setView(listView);
        alertDialog = dialog.create();



        return alertDialog;

    }

    private void RebuildFiles(ArrayAdapter<File> adapter) {
        files.clear();
        files.addAll(getFiles(currentPath));
        adapter.notifyDataSetChanged();
    }

    private ListView createListView(Context context) {
        ListView listView = new ListView(context);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                final ArrayAdapter<File> adapter = (FileAdapter) adapterView.getAdapter();
                File file = adapter.getItem(index);
                if (file.isDirectory()) {
                    currentPath = file.getPath();
                    RebuildFiles(adapter);
                }
                else  {


                    alertDialog.dismiss();

                    iGetDialogResult.onGetBookPath(file.toString());
              //      Toast.makeText(context, file.toString(), Toast.LENGTH_SHORT).show();

                }
            }
        });
        return listView;
    }

    private List<File> getFiles(String directoryPath) {
        File directory = new File(directoryPath);
        List<File> fileList = Arrays.asList(directory.listFiles());

        return fileList;
    }

    private class FileAdapter extends ArrayAdapter<File> {

        public FileAdapter(Context context, List<File> files) {
            super(context, android.R.layout.simple_list_item_1, files);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getView(position, convertView, parent);
            File file = getItem(position);
            view.setText(file.getName());
            return view;
        }

    }
}






