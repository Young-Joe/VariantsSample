package com.joe.variantssample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.widget.Toast;

import com.joe.base.AppUtils;
import com.joe.tencent.qq.QQUtils;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.joe.variantssample.ShareUtil.Platform.MAIL;
import static com.joe.variantssample.ShareUtil.Platform.QQ;
import static com.joe.variantssample.ShareUtil.Platform.WECHAT;
import static com.joe.variantssample.ShareUtil.Platform.WECHAT_CIRCLE;


/**
 * Description：
 *
 * @author QiaoJF on 19/1/7.
 */
public class ShareUtil {

    @StringDef({QQ, WECHAT, WECHAT_CIRCLE, MAIL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Platform {
        String QQ = "QQ";
        String WECHAT = "wechat";
        String WECHAT_CIRCLE = "wechatCircle";
        String MAIL = "mail";
    }

    public interface OnShareEndListener {
        void onShareEnd(String shareUrl);
    }

    public static void share (@Platform String platform, Activity context, String shareUrl, String shareTitle, String shareContent) {
        switch (platform) {
            case Platform.QQ:
                share2QQ(context, shareUrl, shareTitle, shareContent, null, null);
                break;
            case Platform.WECHAT:
            case Platform.WECHAT_CIRCLE:
                //TODO
                break;
            case Platform.MAIL:
                shareToEmail(shareTitle, shareContent);
                break;
        }
    }

    public static void share2QQ(Activity context, String shareUrl, String shareTitle, String shareContent,
                                 String shareIconUrl,
                                 OnShareEndListener onShareEndListener) {
        if (AppUtils.isInstallApp("com.tencent.mobileqq")) {
            Tencent tencent = QQUtils.createInstance(context);
            Bundle bundle = new Bundle();
            //这条分享消息被好友点击后的跳转URL。
            bundle.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
            bundle.putString(QQShare.SHARE_TO_QQ_TARGET_URL, shareUrl);
            //分享的标题。注：PARAM_TITLE、PARAM_IMAGE_URL、PARAM_ SUMMARY不能全为空，最少必须有一个是有值的。
            bundle.putString(QQShare.SHARE_TO_QQ_TITLE, shareTitle);
            //分享的图片URL
            bundle.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, shareIconUrl);
            //分享的消息摘要，最长50个字
            bundle.putString(QQShare.SHARE_TO_QQ_SUMMARY, shareContent);
            //手Q客户端顶部，替换“返回”按钮文字，如果为空，用返回代替
            //bundle.putString(Constants.PARAM_APPNAME, "??我在测试");
            //标识该消息的来源应用，值为应用名称+AppId。
            //bundle.putString(Constants.PARAM_APP_SOURCE, "星期几" + AppId);
            tencent.shareToQQ(context, bundle, new IUiListener() {
                @Override
                public void onComplete(Object o) {
                }

                @Override
                public void onError(UiError uiError) {
                    showToast("Error:" + uiError.toString());
                }

                @Override
                public void onCancel() {

                }
            });
            shareEnd(onShareEndListener, shareUrl);
        } else {
            showToast("未检测到QQ");
        }
    }

    /**
     * 分享到邮箱
     *
     */
    public static void shareToEmail(String shareTitle, String shareSummary) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, shareTitle);
        intent.putExtra(Intent.EXTRA_TEXT, shareSummary);
        MainApplication.getContext().startActivity(intent);
    }

    private static void shareEnd(OnShareEndListener onShareEndListener, String shareUrl) {
        if (onShareEndListener != null) {
            onShareEndListener.onShareEnd(shareUrl);
        }
    }

    private static void showToast(String toast) {
        Toast.makeText(MainApplication.getContext(), toast, Toast.LENGTH_SHORT).show();
    }

}
