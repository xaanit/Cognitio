package me.xaanit.cognitio.handlers;

/**
 * Created by Jacob on 5/10/2017.
 */
public interface IRankedUser {

    /**
     * Gets the long ID of the user
     *
     * @return The long ID
     */
    long getID();

    /**
     * Gets the String ID of the user
     *
     * @return The String ID
     */
    String getStringID();

    /**
     * Gets the rank of the user
     *
     * @return The rank
     */
    long getRank();

    /**
     * Gets the score of the user
     *
     * @return The score
     */
    String getScore();
}
