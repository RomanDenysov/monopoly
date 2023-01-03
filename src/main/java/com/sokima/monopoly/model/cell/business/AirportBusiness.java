package com.sokima.monopoly.model.cell.business;

public class AirportBusiness extends BusinessCell {

    private static final String AIRPORT_TYPE = "Airport";

    /**
     * identifier of a bunch of airport businesses
     */
    private String businessName;

    /**
     * path to an icon
     */
    private String urlToImage;

    @Override
    public String getType() {
        return AIRPORT_TYPE;
    }
}
