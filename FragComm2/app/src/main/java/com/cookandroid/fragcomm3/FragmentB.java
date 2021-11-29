package com.cookandroid.fragcomm3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {

    EditText editText;
    Button btnok;
    FragmentB.FragmentBListener listener;


    public  interface  FragmentBListener{
        void onInputBSent(CharSequence input);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentB.FragmentBListener){
            listener = (FragmentB.FragmentBListener) context;
        }else {
            throw new RuntimeException(context.toString() +"must implement FragmentAListener");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b,container,false);
        editText = (EditText) v.findViewById(R.id.edit_text);
        btnok = (Button) v.findViewById(R.id.btnok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputBSent(input);
            }
        });
        return v;
    }

    public void updateFragBEditText(CharSequence newText){
        editText.setText(newText);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


}
