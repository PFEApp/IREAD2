package com.example.iread.controller;

import android.os.Bundle;

import com.example.iread.R;
import com.example.iread.base.BaseActivity;

public class RecommendActivity  extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
    }

    @Override
    public int getFragmentLayout() {
        return 0;
    }
}
