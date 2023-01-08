package com.sokima.monopoly.util;

import com.sokima.monopoly.cell.Cell;
import com.sokima.monopoly.cell.business.AirportBusiness;
import com.sokima.monopoly.cell.business.BusinessCell;

public final class CellGeneratorUtil {

    private CellGeneratorUtil() {
    }

    public static Cell generateEmptyCell() {
        return new Cell() {
        };
    }

    public static BusinessCell generateBusinessCellBank() {
        BusinessCell businessCell = new AirportBusiness();
        businessCell.setOwner(PlayerGeneratorUtil.generateEmptyBank());
        return businessCell;
    }

    public static BusinessCell generateBusinessCellPlayer() {
        BusinessCell businessCell = new AirportBusiness();
        businessCell.setOwner(PlayerGeneratorUtil.generateBusinessmanOwner());
        return businessCell;
    }

    public static BusinessCell generateBusinessCellPlayer(Long rent) {
        BusinessCell businessCell = generateBusinessCellPlayer();
        businessCell.setRent(rent);
        return businessCell;
    }
}
