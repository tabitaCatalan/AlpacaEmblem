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
        expectedName = "NullItem";
        expectedPower = 0;
        expectedMinRange = 0;
        expectedMaxRange = 0;
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

}
