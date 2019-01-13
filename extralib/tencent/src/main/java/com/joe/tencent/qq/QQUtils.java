package com.bjgoodwill.mobilemrb.qq;


import android.content.Context;

import com.joe.variant.AppConfig;
import com.tencent.tauth.Tencent;


public class QQUtils {

    public static Tencent createInstance(Context context) {
        return Tencent.createInstance(AppConfig.QQ_APP_ID, context);
    }

}
