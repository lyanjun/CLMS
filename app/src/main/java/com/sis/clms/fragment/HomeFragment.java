package com.sis.clms.fragment;

import android.widget.TextView;

import com.sis.clms.R;
import com.sis.clms.fragment.base.TitleFragment;
import com.sis.clms.utils.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页界面
 */

public class HomeFragment extends TitleFragment{

    private Banner banner;
    @Override
    protected int setLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        banner = (Banner) findViewById(R.id.banner);
    }

    /**
     * 设置功能
     */
    @Override
    public void setFunction() {
        titleView.setTitle(getString(R.string.home));
        titleView.setFitsSystemWindows(true);
        List<Integer> list=new ArrayList<>();
        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);



        banner.setImages(list).setImageLoader(new GlideImageLoader()).start();
    }


    @Override
    public void onResume() {
        banner.startAutoPlay();
        super.onResume();
    }


    @Override
    public void onPause() {
        banner.stopAutoPlay();
        super.onPause();
    }
}
