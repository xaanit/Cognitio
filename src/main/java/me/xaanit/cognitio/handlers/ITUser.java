package me.xaanit.cognitio.handlers;

/**
 * Created by Jacob on 5/10/2017.
 */
public interface ITUser {

    /**
     * Gets the background the user is using
     *
     * @return The background
     */
    String getBackground();

    /**
     * Gets the Avatar URL of the user
     *
     * @return The user's avatar URL (Null if they have none)
     */
    String getAvatarURL();

    /**
     * Gets the name of the user
     *
     * @return The name
     */
    String getName();

    /**
     * Gets the discriminator of the user
     *
     * @return The discriminator
     */
    String getDiscriminator();

    /**
     * Gets the title of the user's profile card
     *
     * @return The title
     */
    String getTitle();

    /**
     * Gets how much reputation the user has
     *
     * @return The reputation
     */
    int getReputation();

    /**
     * Gets the equipped badges the user has
     *
     * @return The badges
     */
    String[] getEquippedBadges();

    /**
     * Gets the current EXP the user has to the next level
     *
     * @return The EXP
     */
    long getCurrentEXP();

    /**
     * Gets the EXP needed to level up
     *
     * @return The exp
     */
    long getEXPNeededForLevelUp();

    /**
     * Gets the user's level
     *
     * @return The level
     */
    int getLevel();

    /**
     * Gets the total exp the user has
     *
     * @return The total EXP
     */
    long getTotalEXP();

    /**
     * Gets the global ranking of the user
     *
     * @return The global rank
     */
    long getGlobalRank();

    /**
     * Gets the credits the user has
     *
     * @return The credits
     */
    long getCredits();

    /**
     * Gets what's in the user's infobox
     *
     * @return The infobox text
     */
    String getInfoBox();
}
