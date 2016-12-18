package io.volcain.android.tourguide.module;

import io.volcain.android.tourguide.R;

/**
 * {@link Location} represents the information about the location of a place.
 *
 * Created by
 * volcain on 12/17/16.
 */
public class Location {
    private static final int CITY_ID = R.string.city;
    private static final int COUNTRY_ID = R.string.country;
    private String mName;
    private String mStreet;
    private String mZipCode;

    public Location(final String name, final String street, final String zipCode) {
        mName = name;
        mStreet = street;
        mZipCode = zipCode;
    }

    public String getName() {
        return mName;
    }

    public void setName(final String name) {
        this.mName = name;
    }

    public String getStreet() {
        return mStreet;
    }

    public void setStreet(final String street) {
        this.mStreet = street;
    }

    public String getZipCode() {
        return mZipCode;
    }

    public void setZipCode(final String zipCode) {
        this.mZipCode = zipCode;
    }

    public int getCityId() {
        return CITY_ID;
    }

    public int getCountryId() {
        return COUNTRY_ID;
    }
}
