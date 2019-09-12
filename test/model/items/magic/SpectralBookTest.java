package model.items.magic;

import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;
import org.junit.jupiter.api.Test;

public class SpectralBookTest extends AbstractMagicBookTest {
    private SpectralBook spectralBook;
    private SpectralBook wrongSpectralBook ;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Spectral Book";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        spectralBook = new SpectralBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongSpectralBook = new SpectralBook("Wrong axe", 0, -1, -2);
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
        return wrongSpectralBook;
    }

    @Override
    public IMagicBook getTestItem() {
        return spectralBook;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    @Override
    @Test
    public void beingEquippedBySorcerer() {
        checkCorrectEquippedItem(getSpectralSorcerer(),getTestItem());
    }
}
