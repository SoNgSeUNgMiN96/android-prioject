package com.cookandroid.movievoting;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {


    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    TextView [] textViews = new TextView[20];
    RatingBar [] ratingBars = new RatingBar[20];
    int [] textids = {R.id.title01, R.id.title02,R.id.title03,R.id.title04,R.id.title05,R.id.title06,R.id.title07,R.id.title08,R.id.title09,R.id.title10,R.id.title11,R.id.title12,R.id.title13,R.id.title14,R.id.title15,R.id.title16,R.id.title17,R.id.title18,R.id.title19,R.id.title20};
    int [] ratingids = {R.id.raingbar01, R.id.raingbar02,R.id.raingbar03,R.id.raingbar04,R.id.raingbar05,R.id.raingbar06,R.id.raingbar07,R.id.raingbar08,R.id.raingbar09,R.id.raingbar10,R.id.raingbar11,R.id.raingbar12,R.id.raingbar13,R.id.raingbar14,R.id.raingbar15,R.id.raingbar16,R.id.raingbar17,R.id.raingbar18,R.id.raingbar19,R.id.raingbar20};
    String titles[] = {"제목 1", "제목 2", "제목 3", "제목 4", "제목 5", "제목 6", "제목 7", "제목 8", "제목 9","제목 10","제목 11","제목 12","제목 13","제목 14","제목 15","제목 16","제목 17","제목 18","제목 19","제목 20"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_result,container,false);
        Cursor cursorortemp;
        String ratetemp;
        myHelper = new myDBHelper(getContext());
        sqlDB = myHelper.getWritableDatabase();

        for (int i=0;i<20;i++){
            textViews[i] = (TextView)v.findViewById(textids[i]);
            textViews[i].setText(titles[i]);
        }

        for (int i=0;i<20;i++){
            ratingBars[i] = (RatingBar)v.findViewById(ratingids[i]);
            cursorortemp = sqlDB.rawQuery("SELECT likeNum FROM movieTBL WHERE movieTitle like '제목 "+(i+1)+"'",null);
            cursorortemp.moveToNext();
            ratetemp = cursorortemp.getString(0);
            ratingBars[i].setRating(Integer.parseInt(ratetemp));
        }


        return v;
    }
}
