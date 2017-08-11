package ru.artemdivin.bookreader.MVP.View;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.artemdivin.bookreader.Adapter.ShowBookAdapter;
import ru.artemdivin.bookreader.Helper.IGetDialogResult;
import ru.artemdivin.bookreader.Helper.OpenFileDialog;
import ru.artemdivin.bookreader.MVP.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Presenter.MainPresenter;
import ru.artemdivin.bookreader.R;

public class RecyclerViewFragment extends Fragment implements IMainView{
    @BindView(R.id.rv_main)
    RecyclerView recyclerView;

    MainPresenter presenter;
    ShowBookAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        ButterKnife.bind(this, view);


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final IGetDialogResult result = new IGetDialogResult() {
                    @Override
                    public void onGetBookPath(String path) {
                        Log.d("ONGETBOOKRESULT", "ONGETBOOKRESULT");
                        presenter.onGetBookPath(path);
                    }
                };


                OpenFileDialog dialog = new OpenFileDialog(result);
                dialog.onCreateDialog(getActivity()).show();
            }
        });



        presenter = new MainPresenter(this);

        BookModelEntity entity = new BookModelEntity();
        entity.setAuthor("A");
        entity.setBook("as".getBytes());
        entity.setBookName("C");
        entity.setFavorite(true);
        entity.setFirstString("asadad");
        entity.setTimeCreation(0);

        ArrayList<BookModelEntity> modelEntities = new ArrayList<>();
        modelEntities.add(entity);

       adapter = new ShowBookAdapter(modelEntities);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);

        presenter.onGetBookByPath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/1.TXT");

        return view;
    }

    @Override
    public void onSuccess() {

        Log.d("КНИГА ДОБАВЛЕНА", "КНИГА ДОБАВЛЕНА");
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onFailore(String s) {
        Log.d("НЕУДАЧА", "ОШИБКА ЗАГРУЗКИ");
    }


}
