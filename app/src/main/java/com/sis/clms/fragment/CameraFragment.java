package com.sis.clms.fragment;

import android.widget.TextView;

import com.sis.clms.R;
import com.sis.clms.fragment.base.TitleFragment;

/**
 * 相机界面
 */

public class CameraFragment extends TitleFragment{

    @Override
    protected int setLayoutID() {
        return R.layout.fragment_camera;
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
        titleView.setTitle(getString(R.string.camera));
    }
}
