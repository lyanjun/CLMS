package com.sis.clms.fragment.base;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sis.clms.listener.UIListener;

/**
 * 作者： LYJ
 * 功能： fragment基类
 * 创建日期： 2017/5/2
 */

public abstract class BaseFragment extends MPermissionsFragment implements UIListener {
    protected Context mContext;
    protected Activity mActivity;
    protected View mView;
    /**
     * 当视图被加载到Activity中时候调用
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        this.mActivity = (Activity) context;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView  = inflater.inflate(setLayoutID(),container,false);
        initView();//初始化控件
        setListener();//设置监听
        setFunction();//设置功能
        return mView;
    }

    /**
     * 设置布局
     * @return
     */
    @LayoutRes
    protected abstract int setLayoutID();

    /**
     * 跳转界面
     * @param clazz
     * @return
     */
    protected final <T extends Activity>Intent activity(Class<T> clazz){
        return new Intent(mActivity,clazz);
    }
    /**
     * 管理服务
     * @param clazz
     * @param <T>
     * @return
     */
    protected final <T extends Service>Intent service(Class<T> clazz){
        return new Intent(mActivity,clazz);
    }

    /**
     * 初始化空间
     * @param viewID
     * @return
     */
    protected final View findViewById(@IdRes int viewID){
        return mView.findViewById(viewID);
    }
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
