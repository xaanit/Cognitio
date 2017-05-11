package me.xaanit.cognitio.internal;

import me.xaanit.cognitio.handlers.impl.Header;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by Jacob on 5/9/2017.
 */
public class Requests {

    public static boolean makePutRequest(OkHttpClient client, MediaType type, String bodyString, String url, Header... headers) throws IOException {

        RequestBody body = RequestBody.create(type, bodyString);
        Request.Builder requestBuilder = new Request.Builder().url(url);
        requestBuilder.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:44.0) Gecko/20100101 Firefox/44.0");
        for (Header h : headers)
            requestBuilder.addHeader(h.getKey(), h.getValue());
        requestBuilder.put(body);
        Request request = requestBuilder.build();
        Response response = client.newCall(request).execute();
        boolean success = response.isSuccessful();
        response.close();
        return success;
    }

    public static String makeGetRequest(OkHttpClient client, String url, Header... headers) throws IOException {
        Request.Builder requestBuilder = new Request.Builder().url(url);
        for (Header h : headers)
            requestBuilder.addHeader(h.getKey(), h.getValue());

        Request request = requestBuilder.build();
        Response response = client.newCall(request).execute();
        String res = response.body().string();
        response.close();
        return res;
    }


}
