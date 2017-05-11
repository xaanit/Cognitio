package me.xaanit.cognitio.handlers;

import java.util.List;

/**
 * Created by Jacob on 5/9/2017.
 */
public interface ILeaderboard {

    /**
     * Gets the list of {@link IRankedUser} users on the leaderboard
     *
     * @return The list of users
     */
    List<IRankedUser> getUsers();

    /**
     * The Guild ID, for identification
     *
     * @return The ID
     */
    String getGuildID();

}
