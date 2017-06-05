package com.sis.clms.fragment;

import android.widget.TextView;

import com.sis.clms.R;
import com.sis.clms.fragment.base.TitleFragment;

/**
 * 计算器界面
 */

public class CalculatorFragment extends TitleFragment{

    @Override
    protected int setLayoutID() {
        return R.layout.fragment_calculator;
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
        titleView.setTitle(getString(R.string.calculator));
    }
}
