package com.example.iread.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.iread.R;

public class BlankFragment extends Fragment {

    private FloatingActionButton start;
    private LinearLayout lin;
    private ListView list;
    private String[] words = {"Deja Lu","Entran De Lire","A Lire","Recommandation Des Amis"};
    public static BlankFragment newInstance() {
        return (new BlankFragment());
    }

    public interface OnFriendClicklistener{
        void onAddButtonClick(View view);
        void onfriendViewClick(View view);
        void onInvitaionViewClick(View view);
        void onDejaluClick(View view);
        void onEntrainClick(View view);
        void onALireClick(View view);
        void onDefiReqView(View view);
    }
    private BlankFragment.OnFriendClicklistener addCalback;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_blank_page, container, false);

        list = result.findViewById(R.id.fragment_blank_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,words);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        addCalback.onDejaluClick(view);
                        break;
                    case 1:
                        addCalback.onEntrainClick(view);
                        break;
                    case 2:
                        addCalback.onALireClick(view);
                        break;
                    case 3:
                        break;
                }
            }
        });

        start = result.findViewById(R.id.floatingActionbutton);
        lin = result.findViewById(R.id.floatingActionbuttonLinear);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (start.getVisibility()==View.VISIBLE && lin.getVisibility()==View.INVISIBLE){
                    lin.setVisibility(View.VISIBLE);
                }else {
                    lin.setVisibility(View.INVISIBLE);
                }
            }
        });
        result.findViewById(R.id.floatingActionbuttonSearcheFriends).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCalback.onAddButtonClick(v);
            }
        });
        result.findViewById(R.id.floatingActionbuttonFriends).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCalback.onfriendViewClick(v);
            }
        });
        result.findViewById(R.id.floatingActionbuttonRequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCalback.onInvitaionViewClick(v);
            }
        });
        /*
        result.findViewById(R.id.fragment_blank_btn_deja).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCalback.onDejaluClick(v);
            }
        });
        result.findViewById(R.id.fragment_blank_btn_entrain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCalback.onEntrainClick(v);
            }
        });
        result.findViewById(R.id.fragment_blank_a_lire).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCalback.onALireClick(v);
            }
        });*/
        result.findViewById(R.id.floatingActionbuttonChallenge).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCalback.onDefiReqView(v);
            }
        });
        return result;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.createCallbackToParentActivity();
    }

    private void createCallbackToParentActivity(){
        try{
            addCalback = (BlankFragment.OnFriendClicklistener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");        }
    }
}