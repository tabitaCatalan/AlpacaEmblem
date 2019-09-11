package model.items;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.units.IUnit;
import org.junit.jupiter.api.Test;

public abstract class AbstractHealerTest extends AbstractTestItem {

    @Override
    public void setTestItem() {
        expectedPower = 5;
        expectedMinRange = 1;
        expectedMaxRange = 2;
    }

    @Override
    public abstract IHealer getTestItem();

    /*@Override
    public void actOnTest(IUnit targetUnit){
        getTestItem().heal(targetUnit);
    }*/

    @Test
    public void testHealing(IUnit targetUnit){
        assertEquals(unitHP, targetUnit.getCurrentHitPoints());
        assertEquals(expectedPower, getTestItem().getPower());
        targetUnit.beingHealed(getTestItem().getPower());
        assertEquals(unitHP - expectedPower, targetUnit.getCurrentHitPoints());
    }

}
