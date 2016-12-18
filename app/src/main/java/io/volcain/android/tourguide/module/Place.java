package io.volcain.android.tourguide.module;

/**
 * {@link Place} represents a place that the user wants to visit. It contains an image, a
 * short description, entry price and the location info (e.g. name, address, city).
 *
 * Created by volcain on 12/17/16.
 */
public class Place {
    private static final int NO_IMAGE_PROVIDED = -1;
    // short description of that place
    private String mShortDescription;
    // entry price in EUR
    private String mEntryPrice;
    // image resource ID for that place
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    // address of that place
    private Location mLocation;

    /**
     * Create a new {@link Place} object.
     *
     * @param shortDescription is the short description
     * @param entryPrice       is the entry price in EUR
     * @param imageResourceId  is the image resource ID for the image asset
     * @param location         is a {@link Location} object of the place
     */
    public Place(final String shortDescription, final String entryPrice, final int imageResourceId, final Location location) {
        this.mShortDescription = shortDescription;
        this.mEntryPrice = entryPrice;
        this.mImageResourceId = imageResourceId;
        this.mLocation = location;
    }

    /**
     * Get the short description for the place.
     *
     * @return a string representing the short description for the place.
     */
    public String getShortDescription() {
        return mShortDescription;
    }

    /**
     * Get the entry price for the place in EUR.
     *
     * @return a string representing the entry price for the place.
     */
    public String getEntryPrice() {
        return mEntryPrice;
    }

    /**
     * Get the image resource ID for the word
     *
     * @return an integer representing the resource id
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public Location getLocation() {
        return mLocation;
    }

    /**
     * Returns whether or not there is an image for this place.
     *
     * @return true if there is an image else false
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
