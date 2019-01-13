package com.joe.variant;

import android.support.annotation.StringDef;

import com.joe.variant_b.BuildConfig;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Description：
 *
 * @author QiaoJF on 19/1/13.
 */
@StringDef({AppConfig.APP, AppConfig.WECHAT_APP_ID, AppConfig.WECHAT_APP_SECRET, AppConfig.QQ_APP_ID, AppConfig.QQ_APP_KEY, AppConfig.ALI_FEEDBACK_KEY, AppConfig.ALI_FEEDBACK_App_SECRET})
@Retention(RetentionPolicy.SOURCE)
public @interface AppConfig {

    String APP = "40068980X4_1";

    String WECHAT_APP_ID = "wxf0ee64b013a2173b";
    String WECHAT_APP_SECRET = "d426c6405ed8d412b543738d062bd538";

    String QQ_APP_ID = BuildConfig.QQ_APP_ID;
    String QQ_APP_KEY = "QplnqNS22e1uBe9E";

    /**
     * 阿里百川意见反馈
     */
    String ALI_FEEDBACK_KEY = "24624325";
    String ALI_FEEDBACK_App_SECRET = "1f7e5e844b4873464787252d49224cbd";

}
