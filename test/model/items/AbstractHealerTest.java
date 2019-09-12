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

    public void actOnTest(){
        //getTestItem().heal(getTargetUnit());
    }

    /**
     * Checks item heals the correct amount of HP of targetUnit
     * */
    private void testHealing(IUnit targetUnit){
        assertEquals(targetHP, targetUnit.getCurrentHitPoints());
        assertEquals(expectedPower, getTestItem().getPower());
        targetUnit.receiveDamage(expectedPower - 1);
        getTestItem().heal(targetUnit);
        assertEquals(targetHP, targetUnit.getCurrentHitPoints());
        targetUnit.receiveDamage(expectedPower + 1);
        assertEquals(targetHP - 1, targetUnit.getCurrentHitPoints());
    }

    /**
     * {@inheritDoc}
     * <p>
     * Healers don't attack
     * */
    @Override
    public void attackEquippedTargetUnitsTest(){}

    /**
     * testUnit uses it's item to heal targetUnit
     */
    public void healUnitsTest(){
        testHealing(alpaca);
        testHealing(archer);
        testHealing(cleric);
        testHealing(fighter);
        testHealing(hero);
        testHealing(swordMaster);
        testHealing(lightSorcerer);
        testHealing(darknessSorcerer);
        testHealing(spectralSorcerer);
    }


    @Override
    @Test
    protected void actOnUnEquippedTargetUnitsTest() {
        healUnitsTest();
    }

    @Override
    @Test
    protected void actOnEquippedTargetUnitsTest() {
        equipTargetUnits();
        healUnitsTest();
    }

}
