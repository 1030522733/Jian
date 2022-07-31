package com.example.jian.mvvm.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;

import com.example.jian.R;
import com.example.jian.databinding.ActivityMainBinding;
import com.example.jian.mvvm.ui.squirrels.SquirrelsAct;
import com.example.jtowers.base.BaseAct;
import com.example.jtowers.base.NullVM;

public class MainActivity extends BaseAct<NullVM, ActivityMainBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void init() {
        binding.btPuzzle.setOnClickListener(view -> setIntent(SquirrelsAct.class));
    }

}