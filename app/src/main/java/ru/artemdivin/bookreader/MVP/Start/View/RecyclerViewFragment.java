package ru.artemdivin.bookreader.MVP.Start.View;


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

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;
import ru.artemdivin.bookreader.Adapter.ShowBookAdapter;
import ru.artemdivin.bookreader.Helper.IGetDialogResult;
import ru.artemdivin.bookreader.Helper.OpenFileDialog;
import ru.artemdivin.bookreader.Entity.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Start.Presenter.MainPresenter;
import ru.artemdivin.bookreader.R;

public class RecyclerViewFragment extends Fragment implements IMainView{
    @BindView(R.id.rv_main)
    RecyclerView recyclerView;

    MainPresenter presenter;
    ShowBookAdapter adapter;
    private boolean isFABOpen = false;

    FloatingActionButton fab;
    FloatingActionButton fab1;
    FloatingActionButton fab2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        ButterKnife.bind(this, view);
        presenter = new MainPresenter(this);


        fab  = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        fab1 = (FloatingActionButton) view.findViewById(R.id.floatingActionButton1);
        fab2 = (FloatingActionButton) view.findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABOpen){
                    showFABMenu();
                }else{
                    closeFABMenu();
                }
            }
        });

       // FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        fab1.setOnClickListener(new View.OnClickListener() {
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
                //dialog.onCreateDialog(getActivity()).show();
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .
            }
        });








       //adapter = new ShowBookAdapter(modelEntities);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(manager);

        presenter.onGetBookByPath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/1.TXT");

        return view;
    }

    private void showFABMenu(){
        isFABOpen=true;
        fab1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
    }

    private void closeFABMenu(){
        isFABOpen=false;
        fab1.animate().translationY(0);
        fab2.animate().translationY(0);
    }
    @Override
    public void onSuccess(RealmResults<BookModelEntity> modelEntities) {

        Log.d("КНИГА ДОБАВЛЕНА", "КНИГА ДОБАВЛЕНА");
        if (adapter == null) {
            adapter = new ShowBookAdapter(modelEntities);
            recyclerView.setAdapter(adapter);
                            }
        else
            adapter.notifyDataSetChanged();







    }

    @Override
    public void onFailore(String s) {
        Log.d("НЕУДАЧА", "ОШИБКА ЗАГРУЗКИ");
    }


}
