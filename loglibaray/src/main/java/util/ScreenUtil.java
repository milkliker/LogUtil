package util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import log.LogUtils;

/**
 * 作者：Tyhj on 2018/10/14 23:01
 * 邮箱：tyhj5@qq.com
 * github：github.com/tyhjh
 * description：
 */

public class ScreenUtil {

    private static Application sApplication;

    public static int screenWidth = 0;
    public static int screenHeight = 0;

    //保存屏幕大小
    public static void init(Application application) {
        sApplication = application;
        DisplayMetrics metrics = sApplication.getResources().getDisplayMetrics();
        screenWidth = metrics.widthPixels;//获取到的是px，像素，绝对像素，需要转化为dpi
        screenHeight = getRealHeight();
    }

    public static int getStatusBarHeight() {
        Resources resources = Resources.getSystem();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = sApplication.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        final float scale = sApplication.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    //获取正确的屏幕高度
    private static int getRealHeight() {
        WindowManager wm = (WindowManager) sApplication.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int screenHeight = 0;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            DisplayMetrics dm = new DisplayMetrics();
            display.getRealMetrics(dm);
            screenHeight = dm.heightPixels;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            try {
                screenHeight = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
            } catch (Exception e) {
                DisplayMetrics dm = new DisplayMetrics();
                display.getMetrics(dm);
                screenHeight = dm.heightPixels;
            }
        }
        return screenHeight;
    }

}

