package log;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogUtils {

    private static OnLogInfoListener onLogInfoListener = null;


    private static int LOG_E = 0;
    private static int LOG_D = 1;
    private static int LOG_I = 2;

    public interface OnLogInfoListener {
        void onLog(String logFrom, String logInfo);
    }

    private static boolean ISDEBUG = true;

    public static void init(boolean isDebug, OnLogInfoListener onLogInfoListener) {
        LogUtils.ISDEBUG = isDebug;
        LogUtils.onLogInfoListener = onLogInfoListener;
    }


    /**
     * 打印日志
     *
     * @param content
     * @param args
     */
    public static void e(String content, Object... args) {
        log(content, LOG_E);
    }


    public static void d(String content, Object... args) {
        log(content, LOG_D);
    }

    public static void i(String content, Object... args) {
        log(content, LOG_I);
    }


    /**
     * 打印json格式的日志
     *
     * @param content
     * @param args
     */
    public static void jsonE(String content, Object... args) {
        log(FormatUtil.formatJson(content), LOG_E);
    }


    public static void jsonD(String content, Object... args) {
        log(FormatUtil.formatJson(content), LOG_D);
    }

    public static void jsonI(String content, Object... args) {
        log(FormatUtil.formatJson(content), LOG_I);
    }


    private static void log(String content, int type) {
        if (ISDEBUG) {
            String logFrom = getTargetStackTraceElement();
            switch (type) {
                case 0:
                    Log.e("logFrom", logFrom);
                    Log.e("logInfo", content);
                    break;
                case 1:
                    Log.d("logFrom", logFrom);
                    Log.d("logInfo", content);
                    break;
                case 2:
                    Log.i("logFrom", logFrom);
                    Log.i("logInfo", content);
                    break;
                default:
                    break;
            }


        }
        if (onLogInfoListener != null) {
            onLogInfoListener.onLog(getTargetStackTraceElement(), content);
        }
    }




    /**
     * 获取日志出处
     *
     * @return
     */
    private static String getTargetStackTraceElement() {
        // find the target invoked method
        StackTraceElement targetStackTrace = null;
        boolean shouldTrace = false;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            boolean isLogMethod = stackTraceElement.getClassName().equals(LogUtils.class.getName());
            if (shouldTrace && !isLogMethod) {
                targetStackTrace = stackTraceElement;
                break;
            }
            shouldTrace = isLogMethod;
        }

        return "(" + targetStackTrace.getFileName() + ":"
                + targetStackTrace.getLineNumber() + ")";
    }


}