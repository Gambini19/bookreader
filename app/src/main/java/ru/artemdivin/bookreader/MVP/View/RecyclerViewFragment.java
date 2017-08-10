package ru.artemdivin.bookreader.MVP.View;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.artemdivin.bookreader.Adapter.ShowBookAdapter;
import ru.artemdivin.bookreader.MVP.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Presenter.MainPresenter;
import ru.artemdivin.bookreader.R;

public class RecyclerViewFragment extends Fragment implements IMainView{
    @BindView(R.id.rv_main)
    RecyclerView recyclerView;

    MainPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        ButterKnife.bind(this, view);

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

        ShowBookAdapter adapter = new ShowBookAdapter(modelEntities);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);

        presenter.onGetBookByPath("www.mybook.com/1.txt");

        return view;
    }

    @Override
    public void onSuccess() {


    }

    @Override
    public void onFailore() {

    }
}
