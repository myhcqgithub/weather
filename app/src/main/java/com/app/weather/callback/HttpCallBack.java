package com.app.weather.callback;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.internal.$Gson$Types;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by wangshuo on 16/8/22.
 */
public abstract class HttpCallBack<T> extends Callback<T> {
    private static final String TAG = "HttpCallBack";

    private final Gson gson;
    private final Type mType;

    public HttpCallBack() {
        gson = new GsonBuilder().create();
        mType = getSuperclassTypeParameter(getClass());

    }

    static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        String str = response.body().string();
        Logger.e(TAG, "parseNetworkResponse  -->   string:" + str);
        Object o;
        try {
            o = gson.fromJson(str, mType);
        } catch (JsonParseException e) {
            throw new JsonParseException("json  parse error");
        }
        return (T) o;
    }



    @Override
    public boolean validateReponse(Response response, int id) {
        return super.validateReponse(response, id);
    }

    //执行之后
    @Override
    public void onAfter(int id) {
        Logger.e(TAG, "onAfter  -->  " + id);
//        UiUtils.hide();
    }

    //执行之前
    @Override
    public void onBefore(Request request, int id) {
//        Object tag = request.tag();
//        if (tag instanceof Activity) {
//            UiUtils.show((Context) tag, "读取中...");
//        }
//        L.e(TAG, "onBefore  -->  ");
        StringBuffer sb = new StringBuffer("onBefore  --> " + " id :" + id +
                "  headers:" + request.headers() != null ? "" : request.headers().toString());
        if (request != null && request.body() != null) {
            sb.append("Request  :" + request.toString());
        }
        Logger.e(TAG, sb.toString());
    }
}
