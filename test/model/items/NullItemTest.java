package model.items;

import model.units.Alpaca;
import model.units.IUnit;
import model.map.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NullItemTest extends AbstractTestItem {
    private NullItem nullItem;
    private NullItem wrongNullItem;
    private Alpaca alpaca;

    /**
     * Sets which item is going to be tested
     */
    @Override
    public void setTestItem() {
        expectedName = "Null Item";
        expectedPower = 0;
        expectedMinRange = 1;
        expectedMaxRange = 1;
        nullItem = new NullItem();
    }

    @Override
    public void setWrongRangeItem() {
        wrongNullItem = new NullItem();
    }

    @Override
    public void setTestUnit() {
        alpaca = new Alpaca(unitHP, unitMovement, new Location(0, 0));
    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongNullItem;
    }

    @Override
    public IEquipableItem getTestItem() {
        return nullItem;
    }

    @Override
    public IUnit getTestUnit() {
        return alpaca;
    }

    @Override
    public void equipTestUnit(){}

    @Override
    @Test
    public void equippedToTest() {
        assertNull(getTestItem().getOwner());
        // CORREGIR
        //IUnit unit = getTestUnit();
        //getTestUnit().se
        //assertEquals(unit, getTestItem().getOwner());
    }

    @Override
    @Test
    public void addItemSetsOwnerItem(){
        assertFalse(getTestItem().hasOwner());
        getTestUnit().addItem(getTestItem()); // nothing happens, its null item
        assertFalse(getTestItem().hasOwner());
    }

    @Override
    public void attackUnEquippedTargetUnitsTest(){
        zeroDamageTest(alpaca);
        zeroDamageTest(archer);
        zeroDamageTest(cleric);
        zeroDamageTest(fighter);
        zeroDamageTest(hero);
        zeroDamageTest(swordMaster);
        zeroDamageTest(darknessSorcerer);
        zeroDamageTest(spectralSorcerer);
        zeroDamageTest(lightSorcerer);
    }

    @Override
    public void attackEquippedTargetUnitsTest(){
        zeroDamageTest(alpaca);
        zeroDamageTest(archer);
        zeroDamageTest(cleric);
        zeroDamageTest(fighter);
        zeroDamageTest(hero);
        zeroDamageTest(swordMaster);
        zeroDamageTest(darknessSorcerer);
        zeroDamageTest(spectralSorcerer);
        zeroDamageTest(lightSorcerer);
    }

}
