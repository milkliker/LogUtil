package util;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.os.Vibrator;

public class VibrateUtil {

    private static Application sApplication;
    private static boolean isVirating;

    public static void init(Application application) {
        sApplication = application;
    }


    //震动milliseconds毫秒
    public static void vibrate(long milliseconds) {
        Vibrator vib = (Vibrator) sApplication.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(milliseconds);
    }

    //以pattern[]方式震动
    public static void vibrate(long[] pattern, int repeat) {
        Vibrator vib = (Vibrator) sApplication.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(pattern, repeat);
    }

    //取消震动
    public static void virateCancle() {
        Vibrator vib = (Vibrator) sApplication.getSystemService(Service.VIBRATOR_SERVICE);
        vib.cancel();
    }


}
