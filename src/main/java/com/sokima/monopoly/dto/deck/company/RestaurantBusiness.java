package com.sokima.monopoly.dto.deck.company;

public class RestaurantBusiness extends BusinessCell {

    private static final String RESTAURANT_TYPE = "Restaurant";

    /**
     * identifier of a bunch of restaurant businesses
     */
    private String businessName;

    /**
     * path to an icon
     */
    private String urlToImage;

    @Override
    public String getType() {
        return RESTAURANT_TYPE;
    }
}
