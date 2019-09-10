package model.combat;

import model.items.nonMagic.Bow;
import model.units.Archer;
import model.units.IUnit;

public class ArcherTest extends CombatTest {
    private Archer testArcher;

    @Override
    void setTestUnit() {
        testArcher = new Archer(50, 2, field.getCell(2, 2));
    }

    @Override
    IUnit getTestUnit() {
        return testArcher;
    }

    @Override
    public void equipTestUnit(){
        Bow testBow = new Bow("Test Bow", 10, 1, 2);
        getTestUnit().addItem(testBow);
        getTestUnit().equipItem(testBow);
    }

    @Override
    public void attackEquippedUnitsTest(){
        normalDamageTest(archer);
        normalDamageTest(cleric);
        normalDamageTest(fighter);
        normalDamageTest(hero);
        normalDamageTest(swordMaster);
    }

}
