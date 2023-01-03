package com.sokima.monopoly.model.deck.company;

public class HostelBusiness extends BusinessCell {

    private static final String HOSTEL_TYPE = "Hostel";

    /**
     * identifier of a bunch of hostel businesses
     */
    private String businessName;

    /**
     * path to an icon
     */
    private String urlToImage;

    @Override
    public String getType() {
        return HOSTEL_TYPE;
    }
}
