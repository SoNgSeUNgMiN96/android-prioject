package com.cookandroid.movievoting;

import android.app.ActionBar;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class FragmentDialog extends DialogFragment {

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    private Fragment fragment;
    ImageView image;
    TextView texttitle , textlike;
    int images[] = {R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10};
    String titles[] = {"제목 1", "제목 2", "제목 3", "제목 4", "제목 5", "제목 6", "제목 7", "제목 8", "제목 9","제목 10","제목 11","제목 12","제목 13","제목 14","제목 15","제목 16","제목 17","제목 18","제목 19","제목 20"};
    ImageButton like;

    public FragmentDialog(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog, container,false);
        Bundle args = getArguments();
        like = (ImageButton)view.findViewById(R.id.likeicon);
        textlike = (TextView)view.findViewById(R.id.textLike);
        image = (ImageView)view.findViewById(R.id.image);
        texttitle = (TextView)view.findViewById(R.id.texttitle);
        final String value = args.getString("key");
        myHelper = new myDBHelper(getContext());
        sqlDB = myHelper.getWritableDatabase();


        Cursor  cursororin;
        cursororin = sqlDB.rawQuery("SELECT likeNum FROM movieTBL WHERE movieTitle like '제목 "+(Integer.parseInt(value))+"'",null);
        cursororin.moveToNext();
        String likenum = cursororin.getString(0);
        textlike.setText("Likes : "+likenum);

        fragment = getActivity().getSupportFragmentManager().findFragmentByTag("tag");
        switch (Integer.parseInt(value)){
            default:
                if (Integer.parseInt(value)>=0&&Integer.parseInt(value)<=20)
                    image.setImageResource(images[(Integer.parseInt(value)-1)%10]);
                    texttitle.setText(titles[(Integer.parseInt(value)-1)]);
                break;
        }

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int likeCounter;
                Cursor  cursor;
                cursor = sqlDB.rawQuery("SELECT likeNum FROM movieTBL WHERE movieTitle like '제목 "+(Integer.parseInt(value))+"'",null);
                cursor.moveToNext();
                String liketemp = cursor.getString(0);
                likeCounter = Integer.parseInt(liketemp);
                sqlDB.execSQL("UPDATE movieTBL SET likeNum = '"+(++likeCounter)+"' WHERE movieTitle like '제목 "+(Integer.parseInt(value))+"'");
                cursor = sqlDB.rawQuery("SELECT likeNum FROM movieTBL WHERE movieTitle like '제목 "+(Integer.parseInt(value))+"'",null);
                cursor.moveToNext();
                liketemp = cursor.getString(0);
                textlike.setText("Likes : "+liketemp);
            }
        });


        return view;

    }
}
