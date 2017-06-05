package com.sis.clms.fragment;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.sis.clms.R;
import com.sis.clms.adapter.HomeProductAdapter;
import com.sis.clms.constant.ServiceCode;
import com.sis.clms.fragment.base.TitleFragment;
import com.sis.clms.network.HttpCode;
import com.sis.clms.network.HttpHelper;
import com.sis.clms.network.HttpUtils;
import com.sis.clms.network.entity.request.Body;
import com.sis.clms.network.entity.request.Header;
import com.sis.clms.network.entity.request.SendMessage;
import com.sis.clms.network.entity.response.HomeProductList;
import com.sis.clms.utils.GlideImageLoader;
import com.sis.clms.utils.ToastUtils;
import com.sis.clms.view.ScrollListView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页界面
 */

public class HomeFragment extends TitleFragment {

    private Banner banner;//广告轮播图
    private ScrollListView listView;//产品列表
    private List<HomeProductList.BodyBean.BasprddefViewBean> list;//数据列表
    private HomeProductAdapter adapter;//适配器\

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case HttpCode.NET_CODE_1://产品列表数据
                    String result = String.valueOf(msg.obj);
                    Logger.t("截取前").json(result);
                    String jsonStr = result.substring(1,result.length() - 1);
                    Logger.t("首页产品列表数据").w(jsonStr);
                    Logger.t("首页产品列表数据").json(jsonStr);
                    HomeProductList homeProductList = new Gson().fromJson(jsonStr,HomeProductList.class);
                    list = homeProductList.getBody().getBasprddefView();//产品数据
                    adapter = new HomeProductAdapter(mContext,list);
                    listView.setAdapter(adapter);
                    break;
                case HttpCode.ERROR:
                    Logger.w("请求错误！");
                    break;
            }
            return false;
        }
    });

    /**
     * 设置界面的布局
     *
     * @return
     */
    @Override
    protected int setLayoutID() {
        return R.layout.fragment_home;
    }

    /**
     * 初始化控件
     */
    @Override
    public void initView() {
        banner = (Banner) findViewById(R.id.banner);
        listView = (ScrollListView) findViewById(R.id.product_list);
    }

    /**
     * 设置功能
     */
    @Override
    public void setFunction() {
        super.setFunction();
        //广告位
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.test1);
        list.add(R.drawable.test2);
        list.add(R.drawable.test3);
        banner.setImages(list).setImageLoader(new GlideImageLoader()).start();;
        downLoad();//下载数据
    }

    /**
     * 下载网络数据
     */
    private void downLoad() {
        SendMessage sendMessage = new SendMessage(new Header(ServiceCode.PRODUCT_LIST_CODE),new Body(1,4));
        final String jsonStr = new Gson().toJson(sendMessage);
        Logger.i(jsonStr);
        HttpUtils.HttpPostJson(handler, HttpHelper.HTTP_URL, jsonStr, HttpCode.NET_CODE_1);
    }

    /**
     * 设置标题栏
     */
    @Override
    protected void setTitleView() {
        super.setTitleView();
        titleView.setTitle(getString(R.string.home));
        TextView textView = new TextView(mContext, null, 0, R.style.SignedBankTxtStyle);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.shortToast(mContext, "签约银行");
            }
        });
        titleView.addLeftView(textView);
    }

    /**
     * 运行
     */
    @Override
    public void onResume() {
        banner.startAutoPlay();
        super.onResume();
    }

    /**
     * 暂停
     */
    @Override
    public void onPause() {
        banner.stopAutoPlay();
        super.onPause();
    }

    /**
     * 显示发生改变
     *
     * @param hidden false -> 正在显示 ， true -> 已经隐藏
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        Logger.i(hidden + "");
    }
}
