package com.joe.base;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;


/**
 * Description：
 *      获取Res文件内资源类
 *
 * Created by QiaoJF on 17/12/22.
 */
public class ResUtil {

    public static Drawable getDrawable(@DrawableRes int resourceId) {
        return BaseApplication.getContext().getResources().getDrawable(resourceId);
    }

    public static String getString(@StringRes int stringRes) {
        return BaseApplication.getContext().getResources().getString(stringRes);
    }

    public static int getDimension(@DimenRes int dimenRes){
        return (int) BaseApplication.getContext().getResources().getDimension(dimenRes);
    }

    public static int getColor(@ColorRes int colorRes) {
        return BaseApplication.getContext().getResources().getColor(colorRes);
    }

}
