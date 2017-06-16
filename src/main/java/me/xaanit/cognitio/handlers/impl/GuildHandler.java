package me.xaanit.cognitio.handlers.impl;


import com.google.gson.Gson;
import me.xaanit.cognitio.handlers.IGuildHandler;
import me.xaanit.cognitio.handlers.ILeaderboard;
import me.xaanit.cognitio.handlers.IRankedUser;
import me.xaanit.cognitio.internal.Endpoints;
import me.xaanit.cognitio.internal.Requests;
import me.xaanit.cognitio.internal.exceptions.TatsumakiException;
import me.xaanit.cognitio.util.LogLevel;
import me.xaanit.cognitio.util.SimpleLogger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuildHandler implements IGuildHandler {

    private OkHttpClient client;
    private String key;
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private SimpleLogger logger;
    private Gson gson;

    public GuildHandler(String key) {
        this.client = null;
        if (key == null)
            this.key = "";
        else
            this.key = key;
        this.logger = new SimpleLogger();
        gson = new Gson();
    }

    @Override
    public boolean addPointsToUser(String guildID, String userID, int points) {
        try {
            return basicPoints(guildID, userID, points, "add");
        } catch (IOException ex) {
            logger.error("[[IF THIS IS A BUG. CONTACT THE DEV.]]Failed to add points to user " + userID + " on guild " + guildID + " with message: " + ex.getMessage() + "[[IF THIS IS A BUG. CONTACT THE DEV.]]", LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not add points to user " + userID + " on guild " + guildID);
        }
    }

    @Override
    public boolean setPointsOfUser(String guildID, String userID, int points) {
        try {
            return basicPoints(guildID, userID, points, "set");
        } catch (IOException ex) {
            logger.error("[[IF THIS IS A BUG. CONTACT THE DEV.]]Failed to set the points of user " + userID + " on guild " + guildID + " with message: " + ex.getMessage() + "[[IF THIS IS A BUG. CONTACT THE DEV.]]", LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not set the points of user " + userID + " on guild " + guildID);
        }
    }

    @Override
    public boolean removePointsFromUser(String guildID, String userID, int points) {
        try {
            return basicPoints(guildID, userID, points, "remove");
        } catch (IOException ex) {
            logger.error("[[IF THIS IS A BUG. CONTACT THE DEV.]]Failed to remove points from user " + userID + " on guild " + guildID + " with message: " + ex.getMessage() + "[[IF THIS IS A BUG. CONTACT THE DEV.]]", LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not add points to user " + userID + " on guild " + guildID);
        }
    }

    private boolean basicPoints(String guildID, String userID, int points, String action) throws IOException {
        if (client == null)
            client = new OkHttpClient();

        if (points < 0) {
            points = 0;
            logger.debug("Points are negative... Setting to 0...");
        } else if (points > 50000) {
            points = 50000;
            logger.debug("Points are above 50,000 max... Setting to 50,000...");
        }

        String jsonString = "{\"amount\":" + points + ",\"action\":\"" + action + "\"}";

        return Requests.makePutRequest(client, JSON, jsonString, Endpoints.guildMembersPointsEndpoint(guildID, userID), new Header("Authorization", key));
    }

    @Override
    public boolean addScoreToUser(String guildID, String userID, int points) {
        try {
            return basicScore(guildID, userID, points, "add");
        } catch (IOException ex) {
            logger.error("[[IF THIS IS A BUG. CONTACT THE DEV.]]Failed to add score to user " + userID + " on guild " + guildID + " with message: " + ex.getMessage(), LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not add score to user " + userID + " on guild " + guildID);
        }
    }

    @Override
    public boolean setScoreOfUser(String guildID, String userID, int points) {
        try {
            return basicScore(guildID, userID, points, "set");
        } catch (IOException ex) {
            logger.error("[[IF THIS IS A BUG. CONTACT THE DEV.]]Failed to set the score of user " + userID + " on guild " + guildID + " with message: " + ex.getMessage(), LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not add score to user " + userID + " on guild " + guildID);
        }
    }

    @Override
    public boolean removeScoreFromUser(String guildID, String userID, int points) {
        try {
            return basicScore(guildID, userID, points, "remove");
        } catch (IOException ex) {
            logger.error("[[IF THIS IS A BUG. CONTACT THE DEV.]]Failed to remove points from user " + userID + " on guild " + guildID + " with message: " + ex.getMessage() + "", LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not add score to user " + userID + " on guild " + guildID);
        }
    }

    private boolean basicScore(String guildID, String userID, int points, String action) throws IOException {
        if (client == null)
            client = new OkHttpClient();
        if (points < 0) {
            points = 0;
            logger.debug("Score is negative... Setting to 0...");
        } else if (points > 50000) {
            points = 50000;
            logger.debug("Score is above 50,000 max... Setting to 50,000...");
        }
        String jsonString = "{\"amount\":" + points + ",\"action\":\"" + action + "\"}";
        return Requests.makePutRequest(client, JSON, jsonString, Endpoints.guildMembersScoreEndpoint(guildID, userID), new Header("Authorization", key));
    }

    @Override
    public ILeaderboard getLeaderboard(String guildID) {
        return getLeaderboard(guildID, 10);
    }

    @Override
    public ILeaderboard getLeaderboard(String guildID, long limit) {
        if (client == null)
            client = new OkHttpClient();
        ILeaderboard leaderboard = null;
        List<IRankedUser> users = new ArrayList<>();
        try {
            List<RankedUser> uRanked = Arrays.asList(gson.fromJson(Requests.makeGetRequest(client, Endpoints.guildLeaderboardEndpoint(guildID) + "?limit=" + limit, new Header("Authorization", key)).replaceAll("(,null)", ""), RankedUser[].class));
            uRanked.forEach(u -> users.add(u));
        } catch (Exception ex) {
            logger.error("Could not load leaderboard! Error: " + ex.getMessage(), LogLevel.HIGH);
            return null;
        }
        leaderboard = new Leaderboard(users, guildID);
        return leaderboard;
    }
}
