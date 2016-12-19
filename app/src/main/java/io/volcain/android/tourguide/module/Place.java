package io.volcain.android.tourguide.module;

/**
 * {@link Place} represents a place that the user wants to visit. It contains an image, a short
 * description, entry price and the location info (e.g. name, address, city).
 *
 * Created by volcain on 12/17/16.
 */
public class Place {
    private static final int NO_IMAGE_PROVIDED = -1;
    private static final Location NO_LOCATION_PROVIDED = null;
    private static final String NO_WEBSITE_PROVIDED = "";

    // entry price in EUR
    private String mEntryPrice;
    // image resource ID for that place
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    // address of that place
    private Location mLocation = NO_LOCATION_PROVIDED;
    // website of that place
    private String mWebsite = NO_WEBSITE_PROVIDED;

    /**
     * Create a new {@link Place} object.
     *
     * @param entryPrice      is the entry price in EUR
     * @param imageResourceId is the image resource ID for the image asset
     * @param location        is a {@link Location} object of the place
     */
    public Place(final String entryPrice, final int imageResourceId, final Location location) {
        this.mEntryPrice = entryPrice;
        this.mImageResourceId = imageResourceId;
        this.mLocation = location;
    }

    /**
     * Create a new {@link Place} object.
     *
     * @param entryPrice      is the entry price in EUR
     * @param imageResourceId is the image resource ID for the image asset
     * @param location        is a {@link Location} object of the place
     * @param website         is the website URL
     */
    public Place(final String entryPrice, final int imageResourceId, final Location location, final String website) {
        this.mEntryPrice = entryPrice;
        this.mImageResourceId = imageResourceId;
        this.mLocation = location;
        this.mWebsite = website;
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
     * Get the image resource ID for the place
     *
     * @return an integer representing the resource id
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Get the location info for the place
     *
     * @return an {@link Location} object
     */
    public Location getLocation() {
        return mLocation;
    }

    /**
     * Get the website of the place
     *
     * @return a string representing the website URL
     */
    public String getWebsite() {
        return mWebsite;
    }

    /**
     * Returns whether or not there is an image for this place.
     *
     * @return true if there is an image else false
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Returns whether or not there is a location provided for this place.
     *
     * @return true if there is a location else false
     */
    public boolean hasLocation() {
        return mLocation != NO_LOCATION_PROVIDED;
    }

    /**
     * Returns whether or not there is a website provided for this place.
     *
     * @return true if there is a website else false
     */
    public boolean hasWebsite() {
        return !mWebsite.equals(NO_WEBSITE_PROVIDED);
    }

}
