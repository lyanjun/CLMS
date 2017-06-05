package com.sis.clms.app;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by DELL on 2017/6/5.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("测试").logLevel(LogLevel.FULL);
    }
}
