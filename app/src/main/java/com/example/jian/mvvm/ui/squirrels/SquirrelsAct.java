package com.example.jian.mvvm.ui.squirrels;

import com.example.jian.R;
import com.example.jian.databinding.ActivitySquirrelsBinding;
import com.example.jian.mvvm.vm.SquirrelsVM;
import com.example.jtowers.base.BaseAct;

/**
 * @Author: JianTours
 * @Data: 2022/6/1 23:49
 * @Description:
 */
public class SquirrelsAct extends BaseAct<SquirrelsVM, ActivitySquirrelsBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_squirrels;
    }

    @Override
    protected void init() {

    }
}
