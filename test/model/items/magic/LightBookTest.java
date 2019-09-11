package model.items.magic;

import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;

public class LightBookTest extends AbstractMagicBookTest  {
    private LightBook lightBook;
    private LightBook wrongLightBook;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Light Book";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        lightBook = new LightBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
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
        sorcerer = new Sorcerer(unitHP, unitMovement, new Location(0, 0));
    }

    @Override
    public IMagicBook getWrongTestItem() {
        return wrongLightBook;
    }

    @Override
    public IMagicBook getTestItem() {
        return lightBook;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}
