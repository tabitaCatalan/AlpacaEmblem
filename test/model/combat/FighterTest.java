package model.combat;

import model.items.Axe;
import model.units.Fighter;
import model.units.IUnit;


public class FighterTest extends CombatTest {
    private Fighter testFighter;

    @Override
    void setTestUnit() {
        testFighter = new Fighter(50, 2, field.getCell(2, 2));
    }

    @Override
    IUnit getTestUnit() {
        return testFighter;
    }

    @Override
    public void equipTestUnit(){
        Axe testAxe = new Axe("Test Axe", 10, 1, 2);
        getTestUnit().addItem(testAxe);
        getTestUnit().equipItem(testAxe);
    }

    @Override
    public void attackEquippedUnitsTest(){
        normalDamageTest(archer);
        normalDamageTest(cleric);
        normalDamageTest(fighter);
        strongDamageTest(hero);
        weakDamageTest(swordMaster);
    }


}
