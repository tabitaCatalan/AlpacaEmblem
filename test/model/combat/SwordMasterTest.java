package model.combat;

import model.items.nonMagic.Sword;
import model.units.IUnit;
import model.units.SwordMaster;

public class SwordMasterTest extends CombatTest {
    private SwordMaster testSwordMaster;

    @Override
    void setTestUnit() {
        testSwordMaster = new SwordMaster(50, 2, field.getCell(2, 2));
    }

    @Override
    IUnit getTestUnit() {
        return testSwordMaster;
    }

    @Override
    public void equipTestUnit(){
        Sword testSword = new Sword("Test Sword", 10, 1, 2);
        getTestUnit().addItem(testSword);
        getTestUnit().equipItem(testSword);
    }

    @Override
    public void attackEquippedUnitsTest(){
        normalDamageTest(archer);
        normalDamageTest(cleric);
        strongDamageTest(fighter);
        weakDamageTest(hero);
        normalDamageTest(swordMaster);
    }

}
