package me.xaanit.cognitio.internal;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import me.xaanit.cognitio.handlers.impl.Header;
import okhttp3.*;
import org.json.JSONArray;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jacob on 5/9/2017.
 */
public class Requests {

    public static boolean makePostRequest(OkHttpClient client, MediaType type, String bodyString, String url, Header... headers) throws IOException {
        RequestBody body = RequestBody.create(type, bodyString);
        Request.Builder requestBuilder = new Request.Builder().url(url);
        for (Header h : headers)
            requestBuilder.addHeader(h.getKey(), h.getValue());
        requestBuilder.post(body);
        Request request = requestBuilder.build();
        Response response = client.newCall(request).execute();
        return response.isSuccessful();
    }

    public static String makeGetRequest(OkHttpClient client, String url, Header... headers) throws IOException {
        Request.Builder requestBuilder = new Request.Builder().url(url);
        for (Header h : headers)
            requestBuilder.addHeader(h.getKey(), h.getValue());
        Request request = requestBuilder.build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String unirest(String url, Header... headers) throws IOException, UnirestException {
        Map<String, String> map = new HashMap<>();
        Arrays.asList(headers).forEach(h -> map.put(h.getKey(), h.getValue()));
        GetRequest request = Unirest.get(url).header(headers[0].getKey(), headers[0].getValue());
        try {
            JSONArray arr = request.asJsonAsync().get().getBody().getArray();
            for (Object t : arr)
                System.out.println(t.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return request.asString().getBody();
    }
}
