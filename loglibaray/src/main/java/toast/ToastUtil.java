package toast;

import android.content.Context;
import android.widget.Toast;

import log.LogUtils;

/**
 * Created by Tyhj on 2018/4/2.
 */

public class ToastUtil {

    private static Toast mToast;

    private static Context context;

    public static void init(Context context) {
        ToastUtil.context = context;
    }

    private static void toast(String msg, int time) {
        if (context == null) {
            LogUtils.d("未初始化ToastUtil");
            return;
        }
        if (msg == null)
            return;
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, time);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    public static void showShort(String msg) {
        toast(msg, Toast.LENGTH_SHORT);
    }

    public static void showLong(String msg) {
        toast(msg, Toast.LENGTH_LONG);
    }


}
