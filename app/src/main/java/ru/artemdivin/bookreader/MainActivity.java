package ru.artemdivin.bookreader;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.mikepenz.materialdrawer.DrawerBuilder;

import ru.artemdivin.bookreader.Helper.OpenFileDialog;
import ru.artemdivin.bookreader.Helper.SaverHelper;
import ru.artemdivin.bookreader.MVP.Presenter.OnLoadBookFinishListener;
import ru.artemdivin.bookreader.MVP.View.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, new RecyclerViewFragment())
                .commit();


    }

    public void init() {
        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        new DrawerBuilder().withToolbar(toolbar).withActivity(this).build();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
