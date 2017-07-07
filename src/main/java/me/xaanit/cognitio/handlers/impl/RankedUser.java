package me.xaanit.cognitio.handlers.impl;

import com.google.gson.annotations.SerializedName;
import me.xaanit.cognitio.handlers.IRankedUser;

/**
 * Created by Jacob on 5/10/2017.
 */
public class RankedUser implements IRankedUser {

    @SerializedName("user_id")
    private String user_id;
    @SerializedName("rank")
    private long rank;
    @SerializedName("score")
    private String score;

    public RankedUser() {
    }

    @Override
    public long getID() {
        return Long.parseUnsignedLong(getStringID());
    }

    @Override
    public String getStringID() {
        return this.user_id;
    }

    @Override
    public long getRank() {
        return this.rank;
    }

    @Override
    public String getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return "RankedUser{" +
                "user_id='" + user_id + '\'' +
                ", rank=" + rank +
                ", score='" + score + '\'' +
                '}';
    }
}
