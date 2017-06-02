package com.sis.clms.activity;


import android.hardware.camera2.CaptureFailure;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.sis.clms.R;
import com.sis.clms.activity.base.BaseActivity;
import com.sis.clms.fragment.CalculatorFragment;
import com.sis.clms.fragment.CameraFragment;
import com.sis.clms.fragment.HomeFragment;
import com.sis.clms.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup radioGroup;//底部切换按钮
    private List<Fragment> fragments;//Fragment集合
    /**
     * 设置界面的布局
     *
     * @return
     */
    @Override
    protected int setLayoutID() {
        return R.layout.activity_main;
    }


    /**
     * 初始化
     */
    @Override
    public void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.bottombar);//初始化控件
        fragments = new ArrayList<>();//初始化集合
    }

    /**
     * 设置监听
     */
    @Override
    public void setListener() {
        radioGroup.setOnCheckedChangeListener(this);//设置单选的选择监听
    }
    /**
     * 设置功能
     */
    @Override
    public void setFunction() {
        radioGroup.check(R.id.b_home);//默认展示商城界面
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window window = getWindow();
//            // Translucent status bar
//            window.setFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
    }
    /**
     * 选择切换界面
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (checkedId) {
            case R.id.b_home://商城
                selectFragmentShow(transaction, HomeFragment.class);
                break;
            case R.id.b_calculator://分类
                selectFragmentShow(transaction, CalculatorFragment.class);
                break;
            case R.id.b_camera://购物车
                selectFragmentShow(transaction, CameraFragment.class);
                break;
            case R.id.b_mine://我的
                selectFragmentShow(transaction, MineFragment.class);
                break;
        }
        transaction.commit();
    }
    /**
     * 选择要显示的Fragment
     *
     * @param transaction
     * @param <T>
     * @return
     */
    private <T extends Fragment> T selectFragmentShow(FragmentTransaction transaction, Class<T> clazz) {
        T fragment = null;
        boolean isHave = false;
        if (fragments.size() == 0) {//默认就添加
            fragment = addFragment(transaction, clazz);
            return fragment;
        }
        //判断集合中是否有这个元素
        for (int i = 0, length = fragments.size(); i < length; i++) {
            fragment = (T) fragments.get(i);
            if (fragment.getClass().equals(clazz)) {
                transaction.show(fragment);
                isHave = true;
                continue;
            }
            transaction.hide(fragments.get(i));
        }
        if (isHave == false) {
            fragment = addFragment(transaction, clazz);
        }
        return fragment;
    }

    /**
     * 添加元素
     *
     * @param transaction
     * @param clazz
     * @param <T>
     * @return
     */
    private <T extends Fragment> T addFragment(FragmentTransaction transaction, Class<T> clazz) {
        T fragment = null;
        try {
            fragment = clazz.newInstance();
            transaction.add(R.id.body, fragment).show(fragment);
            fragments.add(fragment);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fragment;

    }
}
