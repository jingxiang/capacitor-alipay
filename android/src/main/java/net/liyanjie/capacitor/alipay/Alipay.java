package net.liyanjie.capacitor.alipay;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.os.Handler;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;

import java.util.Map;

public class Alipay {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public static final int SDK_PAY_FLAG = 1;
    public static final int SDK_AUTH_FLAG = 2;

    @SuppressLint(value = "HandlerLeak")
    public Handler messageHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            PluginCall call = AlipayPlugin.getCall();
            JSObject result = new JSObject();

            switch (message.what) {
                case SDK_PAY_FLAG -> {
                    @SuppressWarnings("unchecked")
                    AlipayPayResult payResult = new AlipayPayResult((Map<String, String>) message.obj);
                    result.put("resultStatus", payResult.getResultStatus());
                    result.put("result", payResult.getResult());
                    result.put("memo", payResult.getMemo());
                    call.resolve(result);
                }
                case SDK_AUTH_FLAG -> {
                    @SuppressWarnings("unchecked")
                    AlipayAuthResult authResult = new AlipayAuthResult((Map<String, String>) message.obj, true);
                    result.put("resultStatus", authResult.getResultStatus());
                    result.put("memo", authResult.getMemo());
                    result.put("result", authResult.getResult());
                    result.put("resultCode", authResult.getResultCode());
                    result.put("authCode", authResult.getAuthCode());
                    result.put("alipayOpenId", authResult.getAlipayOpenId());
                    call.resolve(result);
                }
                default -> {
                }
            }
        }
    };
}
