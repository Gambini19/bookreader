package ru.artemdivin.bookreader.MVP.Start.View;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.artemdivin.bookreader.Adapter.ShowBookAdapter;
import ru.artemdivin.bookreader.Helper.IGetDialogResult;
import ru.artemdivin.bookreader.Helper.OpenFileDialog;
import ru.artemdivin.bookreader.Entity.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Start.Presenter.MainPresenter;
import ru.artemdivin.bookreader.R;

import static com.mikepenz.materialdrawer.R.attr.layoutManager;

public class RecyclerViewFragment extends Fragment implements IMainView{
    @BindView(R.id.rv_main) RecyclerView recyclerView;

    MainPresenter presenter;
    ShowBookAdapter adapter;
    FloatingActionButton fab;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        ButterKnife.bind(this, view);
        initial(view);
        presenter = new MainPresenter(this);
        presenter.onGetListFromRepo();

        return view;
    }


    @Override
    public void onGetList(ArrayList<BookModelEntity> modelEntities) {
        ArrayList<BookModelEntity>  list= new ArrayList<>();
        Log.d("list", list.toString());
        Log.d("КНИГА ДОБАВЛЕНА", "КНИГА ДОБАВЛЕНА");
        if (adapter == null) {

            //list.add(modelEntities);
            adapter = new ShowBookAdapter(modelEntities);
            recyclerView.setAdapter(adapter);
            Log.d("КНИГА ДОБАВЛЕНА", "КНИГА ДОБАВЛЕНА111");
            Log.d("Adapter", String.valueOf(adapter));
        }
        else
        {
            Log.d("Adapter", String.valueOf(adapter));
            /*adapter.addBook(modelEntities);
            adapter.notifyDataSetChanged();*/
            Log.d("КНИГА ДОБАВЛЕНА", "КНИГА ДОБАВЛЕНА222");
        }
    }

    @Override
    public void onAddBook(BookModelEntity modelEntities) {
        ArrayList<BookModelEntity>  list;
        Log.d("КНИГА ДОБАВЛЕНА", "КНИГА ДОБАВЛЕНА");
        if (adapter == null) {
            list= new ArrayList<>();
            list.add(modelEntities);
            adapter = new ShowBookAdapter(list);
            recyclerView.setAdapter(adapter);
            Log.d("КНИГА ДОБАВЛЕНА", "КНИГА ДОБАВЛЕНА111");
            Log.d("Adapter", String.valueOf(adapter));
                            }
        else
            {
                Log.d("Adapter", String.valueOf(adapter));
            adapter.addBook(modelEntities);
            adapter.notifyDataSetChanged();
        Log.d("КНИГА ДОБАВЛЕНА", "КНИГА ДОБАВЛЕНА222");
            }
    }

    @Override
    public void onFailure(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
        Log.d("НЕУДАЧА", "ОШИБКА ЗАГРУЗКИ");
    }

    private void initial(View view) {

        fab  = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
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
                dialog.onStartDialog(getActivity()).show();

            }
        });


        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
    }


}
