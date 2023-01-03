package com.sokima.monopoly.model.deck.company;

public class PhoneBusiness extends BusinessCell {

    private static final String PHONE_TYPE = "Phone";

    /**
     * identifier of a bunch of phone businesses
     */
    private String businessName;

    /**
     * path to an icon
     */
    private String urlToImage;

    @Override
    public String getType() {
        return PHONE_TYPE;
    }
}
