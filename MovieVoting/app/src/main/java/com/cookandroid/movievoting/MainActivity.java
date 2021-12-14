package com.cookandroid.movievoting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer;
    NavigationView navigationView;
    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("영화투표 앱");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);

        navigationView = (NavigationView)findViewById(R.id.nav_view);
        myHelper = new myDBHelper(this);

        /*
        sqlDB = myHelper.getWritableDatabase();
        myHelper.onCreate(sqlDB);
        sqlDB.close();
        */

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_massage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new VotingFragment()).addToBackStack("MessageFrag").commit();
                        break;
                    case  R.id.nav_chat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new ResultFragment()).addToBackStack("ChatFrag").commit();
                        break;
                    case R.id.nav_profile:
                        sqlDB = myHelper.getWritableDatabase();
                        myHelper.onUpgrade(sqlDB,1,2);
                        sqlDB.close();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new ResetFragment()).addToBackStack("ProfileFrag").commit();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    /*
    public class myDBHelper extends SQLiteOpenHelper{
        public myDBHelper(Context context){
            super(context,"movieDB",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE movieTBL (movieNum INTEGER PRIMARY KEY, likeNum INTEGER);");
            for (int i=0;i<20;i++){
                db.execSQL("INSERT INTO movieTBL VALUES ( "+i+", 0);");
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS movieTBL");
            onCreate(db);
        }
    }*/

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else super.onBackPressed();
    }
}


