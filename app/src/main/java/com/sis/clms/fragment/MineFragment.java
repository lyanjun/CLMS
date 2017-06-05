package com.sis.clms.fragment;

import android.widget.TextView;

import com.sis.clms.R;
import com.sis.clms.fragment.base.TitleFragment;

/**
 * 我的界面
 * Created by DELL on 2017/6/2.
 */

public class MineFragment extends TitleFragment{

    @Override
    protected int setLayoutID() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {
        TextView textView = (TextView) findViewById(R.id.test);
        textView.setTextColor(0xffff0000);
    }
    /**
     * 设置功能
     */
    @Override
    public void setFunction() {
        super.setFunction();
    }

    @Override
    protected void setTitleView() {
        super.setTitleView();
        titleView.setTitle(getString(R.string.mine));
    }
}
