package com.joe.base;

import android.app.Application;
import android.content.Context;

/**
 * Description：
 *      初始化Context
 * @author QiaoJF on 18/11/18.
 */
public class BaseApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }

}
