package com.sis.clms.utils;

import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;

import java.text.DecimalFormat;

/**
 * 作者： LYJ
 * 功能： 格式化工具
 * 创建日期： 2017/5/9
 */

public class FormatUtils {

    /**
     * 保留两位小数
     *
     * @param values
     * @return
     */
    public static String getKeepTwoDecimalPlaces(double values) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(values);
    }

    /**
     * 获取中间部分的时间
     * @param string
     * @return
     */
    public static String getMiddleMessage(String string){
        return string.substring(1,string.length()-1).trim();
    }
}
