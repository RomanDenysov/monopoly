package com.sokima.monopoly.dto.deck.company;

public class SocialMediaBusiness extends BusinessCell {

    private static final String SOCIAL_MEDIA_TYPE = "Social Media";

    /**
     * identifier of a bunch of social media businesses
     */
    private String businessName;

    /**
     * path to an icon
     */
    private String urlToImage;

    @Override
    public String getType() {
        return SOCIAL_MEDIA_TYPE;
    }
}
