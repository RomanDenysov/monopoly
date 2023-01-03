package com.sokima.monopoly.dto.deck.company;

public class ShoeBusiness extends BusinessCell {

    private static final String SHOE_TYPE = "Shoe";

    /**
     * identifier of a bunch of shoe businesses
     */
    private String businessName;

    /**
     * path to an icon
     */
    private String urlToImage;

    @Override
    public String getType() {
        return SHOE_TYPE;
    }
}
