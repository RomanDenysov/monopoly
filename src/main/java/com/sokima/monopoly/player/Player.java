package com.sokima.monopoly.player;

import com.sokima.monopoly.cell.business.BusinessCell;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = {"name"})
public abstract class Player {

    /**
     * unique name
     */
    private String name;

    /**
     * current user balance
     */
    protected Long balance = 0L;

    /**
     * business cell in own
     */
    private List<BusinessCell> businessInOwn;

}
