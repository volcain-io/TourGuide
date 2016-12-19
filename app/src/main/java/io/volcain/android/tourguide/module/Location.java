package io.volcain.android.tourguide.module;

import io.volcain.android.tourguide.R;

/**
 * {@link Location} represents the information about the location of a place.
 * This is also used to start an intent which launches the map on the phone.
 *
 * Created by volcain on 12/17/16.
 */
public class Location {
    // we got only one city (this will never change)
    private static final int CITY_ID = R.string.city;
    // in one country (this will never change either)
    private static final int COUNTRY_ID = R.string.country;
    // the name of the location
    private String mName;
    // the street of the location
    private String mStreet;
    // the zip code of the location
    private String mZipCode;

    /**
     * Create a new {@link Location} object.
     *
     * @param name    is the name of that location
     * @param street  is the street of that location
     * @param zipCode is the zip code of that location
     */
    public Location(final String name, final String street, final String zipCode) {
        mName = name;
        mStreet = street;
        mZipCode = zipCode;
    }

    /**
     * Get the name for the location
     *
     * @return a string representing the name of that location
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the street for the location
     *
     * @return a string representing the street of that location
     */
    public String getStreet() {
        return mStreet;
    }

    /**
     * Get the zip code for the location
     *
     * @return a string representing the zip code of that location
     */
    public String getZipCode() {
        return mZipCode;
    }

    /**
     * Get the string resource ID containing the city name for the location
     *
     * @return an integer representing the string resource ID containing the city name for that
     * location
     */
    public int getCityId() {
        return CITY_ID;
    }

    /**
     * Get the string resource ID containing the country name for the location
     *
     * @return an integer representing the string resource ID containing the country name for that
     * location
     */
    public int getCountryId() {
        return COUNTRY_ID;
    }
}
