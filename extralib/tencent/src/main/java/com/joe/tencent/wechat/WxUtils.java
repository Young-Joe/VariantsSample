package com.joe.tencent.wechat;

import android.content.Context;

import com.joe.variant.AppConfig;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class WxUtils {

    public static IWXAPI wxapi;

    /**
     * 将应用的appid注册到微信
     *
     * @param context
     */
    public static IWXAPI registerToWx(Context context) {
        wxapi = WXAPIFactory.createWXAPI(context, AppConfig.WECHAT_APP_ID, true);
        wxapi.registerApp(AppConfig.WECHAT_APP_ID);
        return wxapi;
    }

}
