package ru.artemdivin.bookreader.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;
import ru.artemdivin.bookreader.MVP.BookModelEntity;
import ru.artemdivin.bookreader.R;

/**
 * Created by Администратор on 08.08.2017.
 */

public class ShowBookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<BookModelEntity> list;

    public ShowBookAdapter(ArrayList<BookModelEntity> list) {
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_author) TextView tvAuthor;
        @BindView(R.id.tv_book_name)TextView tvBookName;
        @BindView(R.id.tv_first_string)TextView tvFirstString;
        @BindView(R.id.tv_time_creation)TextView tvTimeCreation;
        @BindView(R.id.cb_favorites)CheckBox cbFavorites;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvAuthor.setText(list.get(position).getAuthor());
        viewHolder.tvBookName.setText(list.get(position).getBookName());
        viewHolder.tvFirstString.setText(list.get(position).getFirstString());
//        viewHolder.tvTimeCreation.setText(0);
        viewHolder.cbFavorites.setChecked(false);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
