package me.xaanit.cognitio.handlers.impl;

import com.google.gson.annotations.SerializedName;
import me.xaanit.cognitio.handlers.ITUser;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "TUser{" +
                "background='" + background + '\'' +
                ", avatarURL='" + avatarURL + '\'' +
                ", name='" + name + '\'' +
                ", discriminator='" + discriminator + '\'' +
                ", title='" + title + '\'' +
                ", reputation=" + reputation +
                ", badges=" + Arrays.toString(badges) +
                ", exp=" + Arrays.toString(exp) +
                ", level=" + level +
                ", totalEXP=" + totalEXP +
                ", rank=" + rank +
                ", credits=" + credits +
                ", infoBox='" + infoBox + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TUser)) return false;

        TUser tUser = (TUser) o;

        if (reputation != tUser.reputation) return false;
        if (level != tUser.level) return false;
        if (totalEXP != tUser.totalEXP) return false;
        if (rank != tUser.rank) return false;
        if (credits != tUser.credits) return false;
        if (!background.equals(tUser.background)) return false;
        if (!avatarURL.equals(tUser.avatarURL)) return false;
        if (!name.equals(tUser.name)) return false;
        if (!discriminator.equals(tUser.discriminator)) return false;
        if (!title.equals(tUser.title)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(badges, tUser.badges)) return false;
        if (!Arrays.equals(exp, tUser.exp)) return false;
        return infoBox.equals(tUser.infoBox);
    }

    @Override
    public int hashCode() {
        int result = background.hashCode();
        result = 31 * result + avatarURL.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + discriminator.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + reputation;
        result = 31 * result + Arrays.hashCode(badges);
        result = 31 * result + Arrays.hashCode(exp);
        result = 31 * result + level;
        result = 31 * result + (int) (totalEXP ^ (totalEXP >>> 32));
        result = 31 * result + (int) (rank ^ (rank >>> 32));
        result = 31 * result + (int) (credits ^ (credits >>> 32));
        result = 31 * result + infoBox.hashCode();
        return result;
    }
}
