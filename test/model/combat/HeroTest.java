package model.combat;

import model.items.Spear;
import model.units.Hero;
import model.units.IUnit;

public class HeroTest extends CombatTest {
    private Hero testHero;

    @Override
    void setTestUnit() {
        testHero = new Hero(50, 2, field.getCell(2, 2));
    }

    @Override
    IUnit getTestUnit() {
        return testHero;
    }

    @Override
    public void equipTestUnit(){
        Spear testSpear = new Spear("Test Spear", 10, 1, 2);
        getTestUnit().addItem(testSpear);
        getTestUnit().equipItem(testSpear);
    }

    @Override
    public void attackEquippedUnitsTest(){
        normalDamageTest(archer);
        normalDamageTest(cleric);
        weakDamageTest(fighter);
        normalDamageTest(hero);
        strongDamageTest(swordMaster);
    }

}
