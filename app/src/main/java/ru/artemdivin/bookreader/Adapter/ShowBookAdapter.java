package ru.artemdivin.bookreader.Adapter;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.artemdivin.bookreader.Entity.BookModelEntity;
import ru.artemdivin.bookreader.MVP.Book.View.ViewPagerFragment;
import ru.artemdivin.bookreader.MVP.Start.View.IFragmentOpener;
import ru.artemdivin.bookreader.R;

/**
 * Created by Администратор on 08.08.2017.
 */

public class ShowBookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<BookModelEntity> list;

    public ShowBookAdapter(ArrayList<BookModelEntity> list) {
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_author) TextView tvAuthor;
        @BindView(R.id.tv_book_name)TextView tvBookName;
        @BindView(R.id.tv_first_string)TextView tvFirstString;
        @BindView(R.id.tv_time_creation)TextView tvTimeCreation;
        @BindView(R.id.cb_favorites)CheckBox cbFavorites;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            if (activity != null && activity instanceof IFragmentOpener){
                //((IFragmentActivityView)activity).onSelectFragment(IFragmentActivityView.TYPE_BOOK);
         //       BookFragment.instance(list.get(getAdapterPosition()).getBookName());*/
                // Fragment fr = new ViewPagerFragment();
                ((IFragmentOpener)activity).displayFragment(ViewPagerFragment.instance(list.get(getAdapterPosition()).getBookName()));

            }
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
        Date date = new Date();
        date.setTime(list.get(position).getTimeCreation());
        SimpleDateFormat df_min = new SimpleDateFormat("mm", Locale.ENGLISH);
        SimpleDateFormat df_our = new SimpleDateFormat("mm", Locale.ENGLISH);
        String time = "";
        if (Calendar.getInstance().getTimeInMillis() - list.get(position).getTimeCreation() < 3600000 ) {
            date.setTime(Calendar.getInstance().getTimeInMillis() - list.get(position).getTimeCreation());
            time = df_min.format(date) + " min";
        }
        else if (Calendar.getInstance().getTimeInMillis() - list.get(position).getTimeCreation() > 3600000)
        {
            date.setTime(Calendar.getInstance().getTimeInMillis() - list.get(position).getTimeCreation());
            time = df_our.format(date) + " hr";
        }

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvAuthor.setText(list.get(position).getAuthor());
        viewHolder.tvBookName.setText(list.get(position).getBookName());
        viewHolder.tvFirstString.setText(list.get(position).getFirstString());
        viewHolder.tvTimeCreation.setText(time);
        viewHolder.cbFavorites.setChecked(false);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addBook(BookModelEntity book){
        list.add(0, book);
    }
}
