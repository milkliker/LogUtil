package util;

import android.graphics.Outline;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewOutlineProvider;

/**
 * 作者：Tyhj on 2018/11/30 00:24
 * 邮箱：tyhj5@qq.com
 * github：github.com/tyhjh
 * description：
 */

public class UiUtil {


    /**
     * 设置裁剪为圆形
     *
     * @param view
     * @param pading
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void setCircleShape(View view, final int pading) {
        view.setClipToOutline(true);
        view.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int margin = Math.min(view.getWidth(), view.getHeight()) / pading;
                outline.setOval(margin, margin, view.getWidth() - margin, view.getHeight() - margin);
            }
        });
    }


    /**
     * 设置圆角
     *
     * @param view
     * @param pading
     * @param cornerRadius 圆角
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void setCornerRadius(View view, final int pading, final int cornerRadius) {
        view.setClipToOutline(true);
        view.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                final int margin = Math.min(view.getWidth(), view.getHeight()) / pading;
                outline.setRoundRect(margin, margin, view.getWidth() - margin, view.getHeight() - margin, cornerRadius);
            }
        });
    }

}
