package me.xaanit.cognitio.handlers.impl;

import com.google.gson.annotations.SerializedName;
import me.xaanit.cognitio.handlers.ITUser;

/**
 * Created by Jacob on 5/10/2017.
 */
public class TUser implements ITUser{

    @SerializedName("background")
    private String background;
    @SerializedName("avatar_url")
    private String avatarURL;
    @SerializedName("name")
    private String name;
    @SerializedName("discriminator")
    private String discriminator;
    @SerializedName("title")
    private String title;
    @SerializedName("reputation")
    private int reputation;
    @SerializedName("badgeSlots")
    private String[] badges;
    @SerializedName("xp")
    private int[] exp;
    @SerializedName("level")
    private int level;
    @SerializedName("total_xp")
    private long totalEXP;
    @SerializedName("rank")
    private long rank;
    @SerializedName("credits")
    private long credits;
    @SerializedName("info_box")
    private String infoBox;

    public TUser() {}

    public String getBackground() {
        return this.background;
    }

    public String getAvatarURL() {
        return this.avatarURL;
    }

    public String getName() {
        return this.name;
    }

    public String getDiscriminator() {
        return this.discriminator;
    }

    public String getTitle() {
        return this.title;
    }

    public int getReputation() {
        return this.reputation;
    }

    public String[] getEquippedBadges() {
        return this.badges;
    }

    public long getCurrentEXP() {
        return exp[0];
    }

    public long getEXPNeededForLevelUp() {
        return exp[1];
    }

    public int getLevel() {
        return this.level;
    }

    public long getTotalEXP() {
        return this.totalEXP;
    }

    public long getGlobalRank() {
        return this.rank;
    }

    public long getCredits() {
        return this.credits;
    }

    public String getInfoBox() {
        return this.infoBox;
    }
}
