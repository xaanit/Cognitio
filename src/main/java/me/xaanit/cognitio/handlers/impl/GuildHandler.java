package me.xaanit.cognitio.handlers.impl;


import me.xaanit.cognitio.handlers.IGuildHandler;
import me.xaanit.cognitio.handlers.ILeaderboard;
import me.xaanit.cognitio.internal.Endpoints;
import me.xaanit.cognitio.internal.Requests;
import me.xaanit.cognitio.internal.exceptions.TatsumakiException;
import me.xaanit.cognitio.util.LogLevel;
import me.xaanit.cognitio.util.SimpleLogger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.io.IOException;

public class GuildHandler implements IGuildHandler {

    private OkHttpClient client;
    private String key;
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private SimpleLogger logger;

    public GuildHandler(String key) {
        this.client = null;
        if (key == null)
            this.key = "";
        else
            this.key = key;
        this.logger = new SimpleLogger();
    }

    @Override
    public boolean addPointsToUser(String guildID, String userID, int points) {
        try {
            return basicPoints(guildID, userID, points, "add");
        } catch (IOException ex) {
            logger.error("Failed to add points to user " + userID + " on guild " + guildID + " with message: " + ex.getMessage() + "[[IF THIS IS A BUG. CONTACT THE DEV.]]", LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not add points to user " + userID + " on guild " + guildID);
        }
    }

    @Override
    public boolean setPointsOfUser(String guildID, String userID, int points) {
        try {
            return basicPoints(guildID, userID, points, "set");
        } catch (IOException ex) {
            logger.error("Failed to set the points of user " + userID + " on guild " + guildID + " with message: " + ex.getMessage() + "[[IF THIS IS A BUG. CONTACT THE DEV.]]", LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not set the points of user " + userID + " on guild " + guildID);
        }
    }

    @Override
    public boolean removePointsFromUser(String guildID, String userID, int points) {
        try {
            return basicPoints(guildID, userID, points, "remove");
        } catch (IOException ex) {
            logger.error("Failed to remove points from user " + userID + " on guild " + guildID + " with message: " + ex.getMessage() + "[[IF THIS IS A BUG. CONTACT THE DEV.]]", LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not add points to user " + userID + " on guild " + guildID);
        }
    }

    private boolean basicPoints(String guildID, String userID, int points, String action) throws IOException {
        if (client == null)
            client = new OkHttpClient();
        if (points < 0)
            throw new TatsumakiException("Points must be above 0!");
        if (points > 50000)
            throw new TatsumakiException("Points must be below 50,000!!");
        return Requests.makePostRequest(client, JSON, "{\"amount\"" + points + ",\"action\":\"" + action + "\"}", Endpoints.guildMembersPointsEndpoint(guildID, userID), new Header("Authorization", key));
    }

    @Override
    public boolean addScoreToUser(String guildID, String userID, int points) {
        try {
            return basicScore(guildID, userID, points, "add");
        } catch (IOException ex) {
            logger.error("Failed to add score to user " + userID + " on guild " + guildID + " with message: " + ex.getMessage() + "[[IF THIS IS A BUG. CONTACT THE DEV.]]", LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not add score to user " + userID + " on guild " + guildID);
        }
    }

    @Override
    public boolean setScoreOfUser(String guildID, String userID, int points) {
        try {
            return basicScore(guildID, userID, points, "set");
        } catch (IOException ex) {
            logger.error("Failed to set the score of user " + userID + " on guild " + guildID + " with message: " + ex.getMessage() + "[[IF THIS IS A BUG. CONTACT THE DEV.]]", LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not add score to user " + userID + " on guild " + guildID);
        }
    }

    @Override
    public boolean removeScoreFromUser(String guildID, String userID, int points) {
        try {
            return basicScore(guildID, userID, points, "remove");
        } catch (IOException ex) {
            logger.error("Failed to remove points from user " + userID + " on guild " + guildID + " with message: " + ex.getMessage() + "[[IF THIS IS A BUG. CONTACT THE DEV.]]", LogLevel.UNKNOWN);
            throw new TatsumakiException("Could not add score to user " + userID + " on guild " + guildID);
        }
    }

    private boolean basicScore(String guildID, String userID, int points, String action) throws IOException {
        if (client == null)
            client = new OkHttpClient();
        if (points < 0)
            throw new TatsumakiException("Points must be above 0!");
        if (points > 50000)
            throw new TatsumakiException("Points must be below 50,000!!");
        return Requests.makePostRequest(client, JSON, "{\"amount\"" + points + ",\"action\":\"" + action + "\"}", Endpoints.guildMembersScoreEndpoint(guildID, userID), new Header("Authorization", key));
    }

    @Override
    public ILeaderboard getLeaderboard(String guildID) {
        if (client == null)
            client = new OkHttpClient();
        try {
            logger.debug(Requests.unirest(Endpoints.guildLeaderboardEndpoint(guildID), new Header("Authorization", key)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
