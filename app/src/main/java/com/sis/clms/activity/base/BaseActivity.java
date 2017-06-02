package com.sis.clms.activity.base;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.sis.clms.listener.UIListener;


/**
 * 作者： LYJ
 * 功能： Activity基类
 * 创建日期： 2017/5/2
 */

public abstract class BaseActivity extends MPermissionsActivity implements UIListener {

    /**
     * 初始化
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateCustom();//初始化
    }

    /**
     * 初始化
     */
    protected void onCreateCustom() {
        setContentView(setLayoutID());
        initView();//初始化控件
        setListener();//设置监听
        setFunction();//设置功能
    }

    /**
     * 跳转界面
     * @param clazz
     * @return
     */
    protected final <T extends Activity>Intent activity(Class<T> clazz){
        return new Intent(this,clazz);
    }
    /**
     * 管理服务
     * @param clazz
     * @param <T>
     * @return
     */
    protected final <T extends Service>Intent service(Class<T> clazz){
        return new Intent(this,clazz);
    }
    @LayoutRes
    protected abstract int setLayoutID();
    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void setFunction() {

    }
}
