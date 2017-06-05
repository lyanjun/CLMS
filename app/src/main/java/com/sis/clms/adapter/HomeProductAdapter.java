package com.sis.clms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.sis.clms.R;
import com.sis.clms.network.entity.response.HomeProductList;

import java.util.List;

/**
 * Created by DELL on 2017/6/5.
 */

public class HomeProductAdapter extends BaseAdapter{
    private Context mContext;//上下文
    private List<HomeProductList.BodyBean.BasprddefViewBean> list;//数据列表
    private LayoutInflater mInflater;//控件填充器

    public HomeProductAdapter(Context mContext, List<HomeProductList.BodyBean.BasprddefViewBean> list) {
        this.mContext = mContext;
        this.list = list;
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_home_product_list,parent,false);
            convertView.setTag(holder);
            holder.bankname = (TextView) convertView.findViewById(R.id.bankname);
            holder.prdname = (TextView) convertView.findViewById(R.id.prdname);
            holder.about = (TextView) convertView.findViewById(R.id.about);
            holder.score = (RatingBar) convertView.findViewById(R.id.score);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        HomeProductList.BodyBean.BasprddefViewBean bean = list.get(position);
        holder.prdname.setText(bean.getPrdname());
        holder.bankname.setText(bean.getBankname());
        holder.score.setRating(Float.parseFloat(bean.getScore()));
        String sendFlag = mContext.getString(R.string.send_flag);
        holder.about.setText(sendFlag + "：" + bean.getFlag() + "（" +bean.getTerm() +"）");
        return convertView;
    }

    /**
     * 复用类
     */
    static class ViewHolder{
        private TextView prdname,bankname,about;
        private RatingBar score;
    }
}
