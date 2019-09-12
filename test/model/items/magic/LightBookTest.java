package model.items.magic;

import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;
import org.junit.jupiter.api.Test;

public class LightBookTest extends AbstractMagicBookTest  {
    private LightBook testLightBook;
    private LightBook wrongLightBook;
    private Sorcerer testSorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Light Book";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        testLightBook = new LightBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongLightBook = new LightBook("Wrong axe", 0, -1, -2);
    }

    /**
     * Sets the unit that will be equipped with the test item
     */
    @Override
    public void setTestUnit() {
        testSorcerer = new Sorcerer(unitHP, unitMovement, new Location(0, 0));
    }

    @Override
    public IMagicBook getWrongTestItem() {
        return wrongLightBook;
    }

    @Override
    public IMagicBook getTestItem() {
        return testLightBook;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return testSorcerer;
    }

    @Override
    public void equipTestUnit(){
        equipUnit(testSorcerer, testLightBook);
    }

    @Override
    @Test
    public void beingEquippedBySorcerer() {
        checkCorrectEquippedItemTest(getSpectralSorcerer(),getTestItem());
    }

    @Override
    public void attackEquippedTargetUnitsTest(){
        super.attackEquippedTargetUnitsTest();
        strongDamageTest(darknessSorcerer);
        weakDamageTest(spectralSorcerer);
        normalDamageTest(lightSorcerer);
    }
}
