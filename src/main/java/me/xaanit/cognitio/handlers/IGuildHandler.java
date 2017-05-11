package me.xaanit.cognitio.handlers;

import me.xaanit.cognitio.internal.exceptions.TatsumakiException;

public interface IGuildHandler {

    /**
     * Adds points to the specified user in the specified guild
     * NOTE: THIS WILL JUST RETURN A 404 CURRENTLY. TRYING TO FIX.
     *
     * @param guildID The ID of the guild
     * @param userID  The ID of the user
     * @param points  The points to add
     * @return If the request was successful or not
     * @throws TatsumakiException If there was an error in the PUT
     */
    boolean addPointsToUser(String guildID, String userID, int points);

    /**
     * Sets the points of the specified user in the specified guild
     * NOTE: THIS WILL JUST RETURN A 404 CURRENTLY. TRYING TO FIX.
     *
     * @param guildID The ID of the guild
     * @param userID  The ID of the user
     * @param points  The points to set to
     * @return If the request was successful or not
     * @throws TatsumakiException If there was an error in the PUT
     */
    boolean setPointsOfUser(String guildID, String userID, int points);

    /**
     * Removes points from the specified user in the specified guild
     * NOTE: THIS WILL JUST RETURN A 404 CURRENTLY. TRYING TO FIX.
     *
     * @param guildID The ID of the guild
     * @param userID  The ID of the user
     * @param points  The points to remove
     * @return If the request was successful or not
     * @throws TatsumakiException If there was an error in the PUT
     */
    boolean removePointsFromUser(String guildID, String userID, int points);


    /**
     * Adds Score to the specified user in the specified guild
     * NOTE: THIS WILL JUST RETURN A 404 CURRENTLY. TRYING TO FIX.
     *
     * @param guildID The ID of the guild
     * @param userID  The ID of the user
     * @param points  The points to add
     * @return If the request was successful or not
     * @throws TatsumakiException If there was an error in the PUT
     */
    boolean addScoreToUser(String guildID, String userID, int points);

    /**
     * Sets the Score of the specified user in the specified guild
     * NOTE: THIS WILL JUST RETURN A 404 CURRENTLY. TRYING TO FIX.
     *
     * @param guildID The ID of the guild
     * @param userID  The ID of the user
     * @param points  The points to set to
     * @return If the request was successful or not
     * @throws TatsumakiException If there was an error in the PUT
     */
    boolean setScoreOfUser(String guildID, String userID, int points);

    /**
     * Removes Score from the specified user in the specified guild
     * NOTE: THIS WILL JUST RETURN A 404 CURRENTLY. TRYING TO FIX.
     *
     * @param guildID The ID of the guild
     * @param userID  The ID of the user
     * @param points  The points to remove
     * @return If the request was successful or not
     * @throws TatsumakiException If there was an error in the PUT
     */
    boolean removeScoreFromUser(String guildID, String userID, int points);

    /**
     * Gets the leaderboard for the guild. Defaults to 10 users
     *
     * @param guildID The ID of the  guild
     * @return The instance of the ILeaderboard
     */
    ILeaderboard getLeaderboard(String guildID);

    /**
     * Gets the leaderboard for the guild. -1 for all
     *
     * @param guildID Tge ID of the guild
     * @param limit   The max amount of users
     * @return The instance of ILeaderboard
     */
    ILeaderboard getLeaderboard(String guildID, long limit);
}
