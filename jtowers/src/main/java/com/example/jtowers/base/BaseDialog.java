package com.example.jtowers.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.jtowers.R;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: JianTours
 * @Data: 2022/5/28 15:13
 * @Description:
 */
public abstract  class BaseDialog<VM extends BaseVM, VDB extends ViewDataBinding> extends AppCompatDialog {

    /**
     * 上下文
     */
    public Context mContext;
    protected VDB binding;

    /**
     * 初始化binding
     */
    protected abstract int getLayoutId();

    /**
     * 初始化
     */
    protected abstract void init();

    public BaseDialog(Context context) {
        super(context, R.style.DialogStyle);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context),getLayoutId(),null,false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getContext();
        setContentView(binding.getRoot());

        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        onWindowAttributesChanged(layoutParams);
        setCanceledOnTouchOutside(false);

        init();
    }

}
