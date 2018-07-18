package toast;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Tyhj on 2018/4/2.
 */

public class ToastUtil {

    private static Toast mToast;

    public static void toast(Context context, String msg) {
        if (msg == null)
            return;
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
