package com.cookandroid.fragcomm3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FragmentMain extends Fragment {

    EditText editText;
    Button btnA ,btnB, btnC;
    FragmentMainListener listener;

    public  interface  FragmentMainListener{
        void onInputASent(CharSequence input);
        void onInputBSent(CharSequence input);
        void onInputCSent(CharSequence input);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentMainListener){
            listener = (FragmentMainListener) context;
        }else {
            throw new RuntimeException(context.toString() +"must implement FragmentAListener");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main,container,false);
        editText = (EditText) v.findViewById(R.id.edit_text);
        btnA = (Button) v.findViewById(R.id.btnfrag1);
        btnB = (Button) v.findViewById(R.id.btnfrag2);
        btnC = (Button) v.findViewById(R.id.btnfrag3);


        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputASent(input);
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputBSent(input);
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputCSent(input);
            }

        });
        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void updateFragAEditText(CharSequence newText){
        editText.setText(newText);
    }
}
