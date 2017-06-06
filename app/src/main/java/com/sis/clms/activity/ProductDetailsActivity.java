package com.sis.clms.activity;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.sis.clms.R;
import com.sis.clms.activity.base.TitleActivity;
import com.sis.clms.constant.ServiceCode;
import com.sis.clms.network.HttpCode;
import com.sis.clms.network.HttpHelper;
import com.sis.clms.network.HttpUtils;
import com.sis.clms.network.entity.request.Body;
import com.sis.clms.network.entity.request.Header;
import com.sis.clms.network.entity.request.SendMessage;
import com.sis.clms.network.entity.response.HomeProductList;
import com.sis.clms.utils.FormatUtils;
import com.sis.clms.utils.StaticUtils;

/**
 * 商品详情界面
 */
public class ProductDetailsActivity extends TitleActivity {
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case HttpCode.NET_CODE_1://产品列表数据
                    String jsonStr = FormatUtils.getMiddleMessage(String.valueOf(msg.obj));
                    Logger.t("首页产品详情数据").json(jsonStr);

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
     * @return
     */
    @Override
    protected int setLayoutID() {
        return R.layout.activity_product_details;
    }

    @Override
    public void setFunction() {
        //设置标题名称
        titleBar.setTitle(getString(R.string.product_details));
        downLoad();//下载网络数据
    }
    /**
     * 下载网络数据
     * cs00001
     * 000300
     * 191
     */
    private void downLoad() {
        Intent intent = getIntent();
        HomeProductList.BodyBean.BasprddefViewBean bean = (HomeProductList.BodyBean.BasprddefViewBean) intent.getSerializableExtra(StaticUtils.PRODUCT);
        SendMessage sendMessage = new SendMessage(new Header(ServiceCode.PRODUCT_DETAILS_CODE),new Body(bean.getGid()));
        final String jsonStr = new Gson().toJson(sendMessage);
        Logger.i(jsonStr);
        HttpUtils.HttpPostJson(handler, HttpHelper.HTTP_URL, jsonStr, HttpCode.NET_CODE_1);
    }
}
