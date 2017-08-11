package ru.artemdivin.bookreader;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import com.mikepenz.materialdrawer.DrawerBuilder;
import ru.artemdivin.bookreader.MVP.View.IFragmentOpener;
import ru.artemdivin.bookreader.MVP.View.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity  implements IFragmentOpener{

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

    @Override
    public void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.frame, fragment)
                .commit();
    }
}
