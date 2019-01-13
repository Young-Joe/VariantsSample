package com.joe.variant;

import android.support.annotation.StringDef;

import com.joe.variant_a.BuildConfig;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.joe.variant.AppConfig.*;

/**
 * Description：
 *      App全局配置类
 *      包含:当前variant私有的https请求参数
 *          三方的依赖的id和key
 * @author QiaoJF on 19/1/13.
 */
@StringDef({WECHAT_APP_ID, WECHAT_APP_SECRET, QQ_APP_ID, QQ_APP_KEY, ALI_FEEDBACK_KEY, ALI_FEEDBACK_App_SECRET})
@Retention(RetentionPolicy.SOURCE)
public @interface AppConfig {

    //TODO 添加自己项目申请的id和key
    String WECHAT_APP_ID = "WECHAT_APP_ID";
    String WECHAT_APP_SECRET = "WECHAT_APP_SECRET";

    String QQ_APP_ID = BuildConfig.QQ_APP_ID;
    String QQ_APP_KEY = "QQ_APP_KEY";

    String ALI_FEEDBACK_KEY = "ALI_FEEDBACK_KEY";
    String ALI_FEEDBACK_App_SECRET = "ALI_FEEDBACK_App_SECRET";

}
