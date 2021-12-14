package com.cookandroid.movievoting;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResetFragment extends Fragment {

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    TextView movietitlereset , preference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_reset, container , false);
        myHelper = new myDBHelper(getContext());
        sqlDB = myHelper.getWritableDatabase();
        movietitlereset = (TextView)v.findViewById(R.id.movietitlereset);
        preference = (TextView)v.findViewById(R.id.preference);
        String strTitle="제목\r\n========\r\n", strRate="선호도\r\n=======\r\n";
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM movieTBL;",null);

        while (cursor.moveToNext()){
            strTitle += cursor.getString(0)+"\r\n";
            strRate += cursor.getString(1)+"\r\n";
        }
        movietitlereset.setText(strTitle);
        preference.setText(strRate);


        return v;
    }
}
