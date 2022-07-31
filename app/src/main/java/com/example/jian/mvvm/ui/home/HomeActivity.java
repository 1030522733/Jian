package com.example.jian.mvvm.ui.home;

import android.Manifest;
import android.annotation.SuppressLint;

import com.example.jian.R;
import com.example.jian.app.utils.FileUtils;
import com.example.jian.databinding.ActivityHomeBinding;
import com.example.jtowers.base.BaseAct;
import com.example.jtowers.base.NullVM;
import com.xm.permissions.OnRequestPermissionsCallback;
import com.xm.permissions.XmPermissions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeActivity extends BaseAct<NullVM, ActivityHomeBinding> implements OnRequestPermissionsCallback {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void init() {
        XmPermissions.newInstance(this).setOnRequestPermissionsCallback(this)
                .requestPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE);




        String oldback = "/sdcard/Android/data/jianghuchuanshuo.mod/files/modcache/WXWX_JC/saves";
        String backup = "/sdcard/Android/data/jianghuchuanshuo.mod/files/modcache/save/";

        String oldpath = "/sdcard/Android/data/jianghuchuanshuo.mod/files/modcache/WXWX_JC/saves/autosave";
        String newpath = "/sdcard/Android/data/jianghuchuanshuo.mod/files/modcache/WXWX_JC/saves/save1";

        binding.btBookup.setOnClickListener(view -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd日HH:mm");
            Date date = new Date(System.currentTimeMillis());
            String name = simpleDateFormat.format(date);
            try {
                FileUtils.createFile(backup+name,"");
                Thread.sleep(100);
                FileUtils.copy(oldback,backup+name+"/");
            }catch (Exception e){
                e.printStackTrace();
            }

        });

        binding.btDelete.setOnClickListener(view -> {
            FileUtils.deleteFiles(newpath);
        });

        binding.btSave.setOnClickListener(view -> {
            FileUtils.renameFile(oldpath,newpath);
        });

    }

    @Override
    public void onDenied(String[] strings) {

    }

    @Override
    public void onGranted() {

    }

    @Override
    public void onPermanentlyDenied(String[] strings) {

    }

    @Override
    public void onSettingBackDenied(String[] strings) {

    }
}