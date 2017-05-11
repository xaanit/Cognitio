package me.xaanit.cognitio.handlers;

/**
 * Created by Jacob on 5/10/2017.
 */
public interface IUserHandler {

    /**
     * Gets a user by their ID.
     *
     * @param id The ID of the user
     * @return The ITUser instance
     */
    ITUser getUserByID(String id);
}
