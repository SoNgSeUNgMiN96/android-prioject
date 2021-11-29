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

public class FragmentA extends Fragment {

    EditText editText;
    Button btnok;
    FragmentAListener listener;

    public  interface  FragmentAListener{
        void onInputASent(CharSequence input);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListener){
            listener = (FragmentAListener) context;
        }else {
            throw new RuntimeException(context.toString() +"must implement FragmentAListener");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a,container,false);
        editText = (EditText) v.findViewById(R.id.edit_text);
        btnok = (Button) v.findViewById(R.id.btnok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputASent(input);
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
