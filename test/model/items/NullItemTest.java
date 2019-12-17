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

    @Override
    public void setTestItem() {
        nullItem = new NullItem();
    }

    protected String getExpectedName(){return  "Null Item";}

    protected int getExpectedPower() {return 0;}

    protected int getExpectedMinRange(){return 1;}

    protected int getExpectedMaxRange(){return 1;}
    @Override
    public void setWrongRangeItem() {
        wrongNullItem = new NullItem();
    }

    @Override
    public void setTestUnit() {
        alpaca = new Alpaca(getUnitHP(), getUnitMovement(), getField().getCell(2,2));
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
