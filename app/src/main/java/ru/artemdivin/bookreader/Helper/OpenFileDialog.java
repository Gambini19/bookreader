package ru.artemdivin.bookreader.Helper;

/**
 * Created by admin on 11.08.2017.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * Created by admin on 20.07.2017.
 */


public class OpenFileDialog {
    private List<File> files = new ArrayList<>();
    private String currentPath = Environment.getExternalStorageDirectory().getPath();
    private AlertDialog alertDialog;
    private AlertDialog.Builder dialog;
    private AlertDialog.Builder ad;
    private IGetDialogResult iGetDialogResult;

    public OpenFileDialog(IGetDialogResult i) {
        iGetDialogResult = i;
    }

    public OpenFileDialog() {
    }

    public AlertDialog onStartDialog(final Context context){
        ad = new AlertDialog.Builder(context);
        ad.setTitle("Choose destination of a your book");
        final EditText input = new EditText(context);
        input.setHint("enter a link of your book here");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
        ad.setView(input);
        ad.setIcon(android.R.drawable.btn_plus);

        ad.setPositiveButton("Cкачать и добавить книгу в список",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String destination = input.getText().toString();
                        if (destination.length() != 0
                                && destination.endsWith(".txt")
                                && destination.endsWith(".html")){
                            ad.create().dismiss();
                            iGetDialogResult.onGetBookPath(String.valueOf(destination));
                        }
                        else

                        {
                            ad.create().dismiss();
                            Toast.makeText(context, "неверная ссылка", Toast.LENGTH_SHORT).show();

                        }

                    }
                });
        ad.setNegativeButton("Выбрать из репо",
        new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ad.create().dismiss();
                onCreateDialog(context).show();

            }
        });
        ad.setCancelable(true);


        return ad.create();
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






