package me.xaanit.cognitio.handlers.impl;

import com.google.gson.Gson;
import me.xaanit.cognitio.handlers.ITUser;
import me.xaanit.cognitio.handlers.IUserHandler;
import me.xaanit.cognitio.internal.Endpoints;
import me.xaanit.cognitio.internal.Requests;
import me.xaanit.cognitio.util.LogLevel;
import me.xaanit.cognitio.util.SimpleLogger;
import okhttp3.OkHttpClient;

import java.io.IOException;

/**
 * Created by Jacob on 5/10/2017.
 */
public class UserHandler implements IUserHandler {

    private String key;
    private Gson gson = new Gson();
    private SimpleLogger logger = new SimpleLogger();
    private OkHttpClient client;

    public UserHandler(String key) {
        if (key == null)
            this.key = "";
        else
            this.key = key;
    }

    @Override
    public ITUser getUserByID(String id) {
        if (client == null)
            client = new OkHttpClient();
        try {
            return gson.fromJson(Requests.makeGetRequest(client, Endpoints.userProfileEndpoint(id), new Header("Authorization", key)), TUser.class);
        } catch (IOException ex) {
            logger.error("[[IF THIS IS A BUG. CONTACT THE DEV.]]Could not grab user by ID! Message: " + ex.getMessage(), LogLevel.HIGH);
            ex.printStackTrace();
            return null;
        }
    }
}
