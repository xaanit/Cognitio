package me.xaanit.cognitio.handlers.impl;

import me.xaanit.cognitio.handlers.ILeaderboard;
import me.xaanit.cognitio.handlers.IRankedUser;

import java.util.List;

/**
 * Created by Jacob on 5/10/2017.
 */
public class Leaderboard implements ILeaderboard {

    private List<IRankedUser> users;
    private String guildID;

    public Leaderboard(List<IRankedUser> users, String guildID) {
        this.users = users;
        this.guildID = guildID;
    }

    @Override
    public List<IRankedUser> getUsers() {
        return this.users;
    }

    @Override
    public String getGuildID() {
        return this.guildID;
    }
}
