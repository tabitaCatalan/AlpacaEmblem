package model.items.magic;

import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;
import org.junit.jupiter.api.Test;

public class SpectralBookTest extends AbstractMagicBookTest {
    private SpectralBook testSpectralBook;
    private SpectralBook wrongSpectralBook ;
    private Sorcerer testSorcerer;

    @Override
    public void setTestItem() {
        testSpectralBook = new SpectralBook(getExpectedName(), getExpectedPower(), getExpectedMinRange(), getExpectedMaxRange());
    }

    protected String getExpectedName(){return  "Spectral Book";}

    protected int getExpectedPower() {return 10;}

    protected int getExpectedMinRange(){return 1;}

    protected int getExpectedMaxRange(){return 2;}

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
        testSorcerer = new Sorcerer(getUnitHP(), getUnitMovement(), getField().getCell(2,2));
    }

    @Override
    public IMagicBook getWrongTestItem() {
        return wrongSpectralBook;
    }

    @Override
    public IMagicBook getTestItem() {
        return testSpectralBook;
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
        equipUnit(testSorcerer, testSpectralBook);
    }

    @Override
    @Test
    public void beingEquippedBySorcerer() {
        checkCorrectEquippedItemTest(getSpectralSorcerer(),getTestItem());
    }

    @Override
    public void attackEquippedTargetUnitsTest(){
        super.attackEquippedTargetUnitsTest();
        weakDamageTest(darknessSorcerer);
        normalDamageTest(spectralSorcerer);
        strongDamageTest(lightSorcerer);
    }

    @Override
    public void attackUnEquippedTargetUnitsTest(){
        super.attackEquippedTargetUnitsTest();
        strongDamageTest(lightSorcerer);
    }
}
