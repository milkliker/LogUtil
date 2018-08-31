package log;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogUtils {

    private static OnLogInfoListener onLogInfoListener = null;

    public interface OnLogInfoListener {
        void onLog(String logFrom, String logInfo);
    }

    private static final int JSON_INDENT = 6;
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
    public static void log(String content, Object... args) {
        logE(content);
    }


    /**
     * 打印json格式的日志
     *
     * @param content
     * @param args
     */
    public static void logJson(String content, Object... args) {
        logE(getPrettyJson(content));
    }


    private static void logE(String content) {
        if (ISDEBUG) {
            Log.e("logFrom", getTargetStackTraceElement());
            Log.e("logInfo", content);
        }
        if (onLogInfoListener != null) {
            onLogInfoListener.onLog(getTargetStackTraceElement(), content);
        }
    }


    /**
     * string转json格式
     *
     * @param jsonStr
     * @return
     */
    private static String getPrettyJson(String jsonStr) {
        try {
            jsonStr = jsonStr.trim();
            if (jsonStr.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(jsonStr);
                return jsonObject.toString(JSON_INDENT);
            }
            if (jsonStr.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(jsonStr);
                return jsonArray.toString(JSON_INDENT);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "Invalid Json, Please Check: " + jsonStr;
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