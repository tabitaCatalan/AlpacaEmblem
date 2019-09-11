package model.items;

import model.units.IUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractDamageItemTest extends AbstractTestItem{

    @Override
    public void setTestItem() {
        expectedPower = 5;
        expectedMinRange = 1;
        expectedMaxRange = 2;
    }

    @Override
    public abstract IAbleOfAttack getTestItem();

    protected void attacking(IUnit targetUnit){
        assertEquals(unitHP, targetUnit.getCurrentHitPoints());
        assertEquals(expectedPower, getTestItem().getPower());
        targetUnit.beingHealed(getTestItem().getPower());
        assertEquals(unitHP - expectedPower, targetUnit.getCurrentHitPoints());
    }

}
