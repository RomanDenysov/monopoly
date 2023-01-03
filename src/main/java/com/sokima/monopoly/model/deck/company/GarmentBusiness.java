package com.sokima.monopoly.model.deck.company;

public class GarmentBusiness extends BusinessCell {

    private static final String GARMENT_TYPE = "Garment";

    /**
     * identifier of a bunch of garment businesses
     */
    private String businessName;

    /**
     * path to an icon
     */
    private String urlToImage;

    @Override
    public String getType() {
        return GARMENT_TYPE;
    }
}
