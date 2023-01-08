package com.sokima.monopoly.board;

import com.sokima.monopoly.cell.business.*;
import com.sokima.monopoly.cell.event.EventCell;
import com.sokima.monopoly.configuration.cell.*;
import com.sokima.monopoly.configuration.table.GameTableConfiguration;
import com.sokima.monopoly.event.Event;
import com.sokima.monopoly.player.Bank;
import com.sokima.monopoly.player.Businessman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class GameBoard {

    @Autowired
    private Map<String, Event> eventMap;

    @Autowired
    private GameTableConfiguration gameConfiguration;
    @Autowired
    private AirportCellConfiguration airportCellConfiguration;
    @Autowired
    private GarmentCellConfiguration garmentCellConfiguration;
    @Autowired
    private HostelCellConfiguration hostelCellConfiguration;
    @Autowired
    private PhoneCellConfiguration phoneCellConfiguration;
    @Autowired
    private RestaurantCellConfiguration restaurantCellConfiguration;
    @Autowired
    private ShoeCellConfiguration shoeCellConfiguration;
    @Autowired
    private SocialMediaCellConfiguration socialMediaCellConfiguration;

    private List<Businessman> players;
    private Bank bank;
    private List<BusinessCell> businessCells;
    private List<EventCell> eventCells;

    @PostConstruct
    void onStartUp() {
        generateBusinessman();
        generateBank();
        generateBusinessCell();
    }

    private void generateBusinessman() {
        players = Stream.iterate(new Businessman(), t -> t)
                .limit(gameConfiguration.getUserCount())
                .peek(businessman -> businessman.setName(nextName()))
                .peek(businessman -> businessman.setBalance(gameConfiguration.getStartUpMoney()))
                .peek(businessman -> businessman.setBusinessInOwn(Collections.emptyList()))
                .collect(Collectors.toList());
    }

    private void generateBank() {
        bank = new Bank();
        bank.setName("Bank");
        bank.setBalance(Long.MAX_VALUE);
    }

    private void generateBusinessCell() {
        List<AirportBusiness> airportBusinesses = generateAirportBusiness();
        List<GarmentBusiness> garmentBusinesses = generateGarmentBusiness();
        List<HostelBusiness> hostelBusinesses = generateHostelBusiness();
        List<PhoneBusiness> phoneBusinesses = generatePhoneBusiness();
        List<RestaurantBusiness> restaurantBusinesses = generateRestaurantBusiness();
        List<ShoeBusiness> shoeBusinesses = generateShoeBusiness();
        List<SocialMediaBusiness> socialMediaBusinesses = generateSocialMediaBusiness();

        businessCells.addAll(airportBusinesses);
        businessCells.addAll(garmentBusinesses);
        businessCells.addAll(hostelBusinesses);
        businessCells.addAll(phoneBusinesses);
        businessCells.addAll(restaurantBusinesses);
        businessCells.addAll(shoeBusinesses);
        businessCells.addAll(socialMediaBusinesses);
    }

    /**
     * TODO create annotation that fills configuration
     * e.g.
     *
     * @FillConfiguration(conf = AirportConfiguration.class)
     * List<AirportBusiness> businessCell = Stream.iterate(...).limit();
     */

    private List<SocialMediaBusiness> generateSocialMediaBusiness() {
        List<SocialMediaBusiness> socialMediaBusinesses = Stream.iterate(new SocialMediaBusiness(), t -> t)
                .limit(SocialMediaCellConfiguration.COUNT)
                .peek(socialMedia -> socialMedia.setRentEvent(eventMap.get("rentEvent")))
                .peek(socialMedia -> socialMedia.setOwner(bank))
                .collect(Collectors.toList());

        setConfigurationToCell(socialMediaBusinesses.iterator().next(),
                airportCellConfiguration.getFirstCompany().getBusinessName(),
                airportCellConfiguration.getFirstCompany().getRent(),
                airportCellConfiguration.getFirstCompany().getPrice());

        setConfigurationToCell(socialMediaBusinesses.iterator().next(),
                airportCellConfiguration.getSecondCompany().getBusinessName(),
                airportCellConfiguration.getSecondCompany().getRent(),
                airportCellConfiguration.getSecondCompany().getPrice());

        setConfigurationToCell(socialMediaBusinesses.iterator().next(),
                airportCellConfiguration.getThirdCompany().getBusinessName(),
                airportCellConfiguration.getThirdCompany().getRent(),
                airportCellConfiguration.getThirdCompany().getPrice());

        return socialMediaBusinesses;
    }

    private List<ShoeBusiness> generateShoeBusiness() {
        List<ShoeBusiness> shoeBusinesses = Stream.iterate(new ShoeBusiness(), t -> t)
                .limit(ShoeCellConfiguration.COUNT)
                .peek(shoe -> shoe.setRentEvent(eventMap.get("rentEvent")))
                .peek(shoe -> shoe.setOwner(bank))
                .collect(Collectors.toList());

        setConfigurationToCell(shoeBusinesses.iterator().next(),
                airportCellConfiguration.getFirstCompany().getBusinessName(),
                airportCellConfiguration.getFirstCompany().getRent(),
                airportCellConfiguration.getFirstCompany().getPrice());

        setConfigurationToCell(shoeBusinesses.iterator().next(),
                airportCellConfiguration.getSecondCompany().getBusinessName(),
                airportCellConfiguration.getSecondCompany().getRent(),
                airportCellConfiguration.getSecondCompany().getPrice());

        setConfigurationToCell(shoeBusinesses.iterator().next(),
                airportCellConfiguration.getThirdCompany().getBusinessName(),
                airportCellConfiguration.getThirdCompany().getRent(),
                airportCellConfiguration.getThirdCompany().getPrice());

        return shoeBusinesses;
    }

    private List<RestaurantBusiness> generateRestaurantBusiness() {
        List<RestaurantBusiness> restaurantBusinesses = Stream.iterate(new RestaurantBusiness(), t -> t)
                .limit(RestaurantCellConfiguration.COUNT)
                .peek(restaurant -> restaurant.setRentEvent(eventMap.get("rentEvent")))
                .peek(restaurant -> restaurant.setOwner(bank))
                .collect(Collectors.toList());

        setConfigurationToCell(restaurantBusinesses.iterator().next(),
                airportCellConfiguration.getFirstCompany().getBusinessName(),
                airportCellConfiguration.getFirstCompany().getRent(),
                airportCellConfiguration.getFirstCompany().getPrice());

        setConfigurationToCell(restaurantBusinesses.iterator().next(),
                airportCellConfiguration.getSecondCompany().getBusinessName(),
                airportCellConfiguration.getSecondCompany().getRent(),
                airportCellConfiguration.getSecondCompany().getPrice());

        setConfigurationToCell(restaurantBusinesses.iterator().next(),
                airportCellConfiguration.getThirdCompany().getBusinessName(),
                airportCellConfiguration.getThirdCompany().getRent(),
                airportCellConfiguration.getThirdCompany().getPrice());

        return restaurantBusinesses;
    }

    private List<PhoneBusiness> generatePhoneBusiness() {
        List<PhoneBusiness> phoneBusinesses = Stream.iterate(new PhoneBusiness(), t -> t)
                .limit(PhoneCellConfiguration.COUNT)
                .peek(phone -> phone.setRentEvent(eventMap.get("rentEvent")))
                .peek(phone -> phone.setOwner(bank))
                .collect(Collectors.toList());

        setConfigurationToCell(phoneBusinesses.iterator().next(),
                airportCellConfiguration.getFirstCompany().getBusinessName(),
                airportCellConfiguration.getFirstCompany().getRent(),
                airportCellConfiguration.getFirstCompany().getPrice());

        setConfigurationToCell(phoneBusinesses.iterator().next(),
                airportCellConfiguration.getSecondCompany().getBusinessName(),
                airportCellConfiguration.getSecondCompany().getRent(),
                airportCellConfiguration.getSecondCompany().getPrice());

        return phoneBusinesses;
    }

    private List<HostelBusiness> generateHostelBusiness() {
        List<HostelBusiness> hostelBusinesses = Stream.iterate(new HostelBusiness(), t -> t)
                .limit(HostelCellConfiguration.COUNT)
                .peek(hostel -> hostel.setRentEvent(eventMap.get("rentEvent")))
                .peek(hostel -> hostel.setOwner(bank))
                .collect(Collectors.toList());

        setConfigurationToCell(hostelBusinesses.iterator().next(),
                airportCellConfiguration.getFirstCompany().getBusinessName(),
                airportCellConfiguration.getFirstCompany().getRent(),
                airportCellConfiguration.getFirstCompany().getPrice());

        setConfigurationToCell(hostelBusinesses.iterator().next(),
                airportCellConfiguration.getSecondCompany().getBusinessName(),
                airportCellConfiguration.getSecondCompany().getRent(),
                airportCellConfiguration.getSecondCompany().getPrice());

        setConfigurationToCell(hostelBusinesses.iterator().next(),
                airportCellConfiguration.getThirdCompany().getBusinessName(),
                airportCellConfiguration.getThirdCompany().getRent(),
                airportCellConfiguration.getThirdCompany().getPrice());

        return hostelBusinesses;
    }

    private List<GarmentBusiness> generateGarmentBusiness() {
        List<GarmentBusiness> garmentBusinesses = Stream.iterate(new GarmentBusiness(), t -> t)
                .limit(GarmentCellConfiguration.COUNT)
                .peek(garment -> garment.setRentEvent(eventMap.get("rentEvent")))
                .peek(garment -> garment.setOwner(bank))
                .collect(Collectors.toList());

        setConfigurationToCell(garmentBusinesses.iterator().next(),
                garmentCellConfiguration.getFirstCompany().getBusinessName(),
                garmentCellConfiguration.getFirstCompany().getRent(),
                garmentCellConfiguration.getFirstCompany().getPrice());

        setConfigurationToCell(garmentBusinesses.iterator().next(),
                garmentCellConfiguration.getSecondCompany().getBusinessName(),
                garmentCellConfiguration.getSecondCompany().getRent(),
                garmentCellConfiguration.getSecondCompany().getPrice());

        return garmentBusinesses;
    }

    private List<AirportBusiness> generateAirportBusiness() {
        List<AirportBusiness> airportBusinesses = Stream.iterate(new AirportBusiness(), t -> t)
                .limit(AirportCellConfiguration.COUNT)
                .peek(airport -> airport.setRentEvent(eventMap.get("rentEvent")))
                .peek(airport -> airport.setOwner(bank))
                .collect(Collectors.toList());

        setConfigurationToCell(airportBusinesses.iterator().next(),
                airportCellConfiguration.getFirstCompany().getBusinessName(),
                airportCellConfiguration.getFirstCompany().getRent(),
                airportCellConfiguration.getFirstCompany().getPrice());

        setConfigurationToCell(airportBusinesses.iterator().next(),
                airportCellConfiguration.getSecondCompany().getBusinessName(),
                airportCellConfiguration.getSecondCompany().getRent(),
                airportCellConfiguration.getSecondCompany().getPrice());

        setConfigurationToCell(airportBusinesses.iterator().next(),
                airportCellConfiguration.getThirdCompany().getBusinessName(),
                airportCellConfiguration.getThirdCompany().getRent(),
                airportCellConfiguration.getThirdCompany().getPrice());

        return airportBusinesses;
    }

    private <T extends BusinessCell> void setConfigurationToCell(T businessCell, String name, Long rent, Long price) {
        businessCell.setBusinessName(name);
        businessCell.setRent(rent);
        businessCell.setPrice(price);
    }

    private String nextName() {
        return UUID.randomUUID().toString();
    }
}
