package me.xaanit.cognitio.internal;

public class Endpoints {

    // The base URL for all API calls
    public static String BASE_URL = "https://api.tatsumaki.xyz/";

    private static String GUILDS = BASE_URL + "guilds/";

    private static String GUILD_MEMBERS = "members/";

    private static String POINTS = "points";

    private static String USERS = BASE_URL + "users/";

    public static String guildMembersPointsEndpoint(String guildID, String userID) {
        return GUILDS + guildID + "/" + GUILD_MEMBERS + userID + "/points/";
    }

    public static String guildMembersScoreEndpoint(String guildID, String userID) {
        return guildMembersPointsEndpoint(guildID, userID).replace("points", "score");
    }

    public static String guildLeaderboardEndpoint(String guildID) {
        return GUILDS + guildID + "/leaderboard";
    }

    public static String userProfileEndpoint(String userID) {
        return USERS + userID;
    }


}
