package manager;

import android.app.Application;

import toast.ToastUtil;
import util.ClipbordUtil;
import util.InternetUtil;
import util.ScreenUtil;
import util.SharedPreferencesUtil;
import util.VibrateUtil;

public class UtilManager {

    public static void initAll(Application application) {
        ToastUtil.init(application);
        ScreenUtil.init(application);
        ClipbordUtil.init(application);
        InternetUtil.init(application);
        SharedPreferencesUtil.init(application);
        VibrateUtil.init(application);
    }

}
