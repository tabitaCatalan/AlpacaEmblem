package model.combat;

import model.items.Staff;
import model.units.Cleric;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

public class ClericTest extends CombatTest {
    private Cleric testCleric;

    @Override
    void setTestUnit() {
        testCleric = new Cleric(50, 2, field.getCell(2, 2));
    }

    @Override
    IUnit getTestUnit() {
        return testCleric;
    }

    @Override
    public void equipTestUnit(){
        Staff testStaff = new Staff("Test Staff", 10, 1, 2);
        getTestUnit().addItem(testStaff);
        getTestUnit().equipItem(testStaff);
    }

    @Override
    public void attackEquippedUnitsTest(){}

    /**
     * testUnit uses it's item to heal targetUnit
     */
    public void healUnitsTest(){
        useItemOnUnitTest(50, alpaca);
        useItemOnUnitTest(50, archer);
        useItemOnUnitTest(50, cleric);
        useItemOnUnitTest(50, fighter);
        useItemOnUnitTest(50, hero);
        useItemOnUnitTest(50, swordMaster);
    }

    @Override
    @Test
    void useItemOnUnEquippedTargetUnitsTest() {
        healUnitsTest();
    }
    @Override
    @Test
    void equipTargetsAndUseItemOnEquippedTargetUnitsTest() {
        equipTargetUnits();
        healUnitsTest();
    }

}
