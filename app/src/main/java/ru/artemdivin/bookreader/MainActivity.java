package ru.artemdivin.bookreader;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.mikepenz.materialdrawer.DrawerBuilder;
import ru.artemdivin.bookreader.MVP.Start.View.IFragmentOpener;
import ru.artemdivin.bookreader.MVP.Start.View.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity  implements IFragmentOpener{
    public RecyclerViewFragment rFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        rFragment = new RecyclerViewFragment();


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame, rFragment)
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

    @Override
    public void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .hide(rFragment)
                .add(R.id.frame, fragment)
                .addToBackStack("back")
                .commit();
    }

}
