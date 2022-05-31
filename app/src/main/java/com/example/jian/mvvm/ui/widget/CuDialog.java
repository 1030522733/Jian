package com.example.jian.mvvm.ui.widget;

import android.content.Context;
import android.view.View;

import com.example.jian.R;
import com.example.jian.databinding.DialogCuBinding;
import com.example.jtowers.base.BaseDialog;
import com.example.jtowers.base.NullVM;

/**
 * @Author: JianTours
 * @Data: 2022/5/28 15:42
 * @Description:
 */
public class CuDialog extends BaseDialog<NullVM, DialogCuBinding> {

    public CuDialog(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_cu;
    }

    @Override
    protected void init() {

        binding.layoutCu.setOnClickListener(view -> {});
    }

    public CuDialog setListener(View.OnClickListener listener){
        binding.btCu.setOnClickListener(listener);
        return this;
    }
}
