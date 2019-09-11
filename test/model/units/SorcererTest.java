package model.units;

import model.items.magic.IMagicBook;
import model.items.magic.SpectralBook;
import org.junit.jupiter.api.Test;

public class SorcererTest extends AbstractTestUnit {
    private Sorcerer testSorcerer;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        testSorcerer = new Sorcerer(50, 2, field.getCell(2, 2));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return testSorcerer;
    }

    @Test
    @Override
    public void equipSpectralBookTest(){
        checkCorrectEquippedItem(testSorcerer, spectralBook);
    }

    @Test
    @Override
    public void equipDarknessBookTest(){
        checkCorrectEquippedItem(testSorcerer, darknessBook);
    }

    @Test
    @Override
    public void equipLightBookTest(){
        checkCorrectEquippedItem(testSorcerer, lightBook);
    }

    @Override
    public void equipTestUnit(){
        IMagicBook magicBook = new SpectralBook("Test Magic Book", 10, 1, 2);
        getTestUnit().addItem(magicBook);
        getTestUnit().equipItem(magicBook);
    }

    @Override
    public void attackEquippedUnitsTest() {
        strongDamageTest(archer);
        strongDamageTest(cleric);
        strongDamageTest(fighter);
        strongDamageTest(hero);
        strongDamageTest(swordMaster);
    }
}
