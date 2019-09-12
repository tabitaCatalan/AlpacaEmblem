package model.units;

import model.items.IEquipableItem;
import model.items.magic.IMagicBook;
import model.items.magic.SpectralBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SorcererTest extends AbstractTestUnit {
    private Sorcerer testSorcerer;
    private IMagicBook testMagicBook;

    @Override
    public void setTestUnit() {
        testSorcerer = new Sorcerer(50, 2, field.getCell(2, 2));
    }

    @Override
    public IUnit getTestUnit() {
        return testSorcerer;
    }


    @Override
    public void setTestItem(){
        testMagicBook = new SpectralBook("Test Magic Book", 10, 1, 2);
    }

    @Override
    public IEquipableItem getTestItem() {
        return testMagicBook;
    }

    @Test
    @Override
    public void equipSpectralBookTest(){
        checkCorrectEquippedItemTest(testSorcerer, spectralBook);
    }

    @Test
    @Override
    public void equipDarknessBookTest(){
        checkCorrectEquippedItemTest(testSorcerer, darknessBook);
    }

    @Test
    @Override
    public void equipLightBookTest(){
        checkCorrectEquippedItemTest(testSorcerer, lightBook);
    }

    @Override
    public void equipTestUnit(){
        getTestUnit().addItem(testMagicBook);
        getTestUnit().equipItem(testMagicBook);
    }

    @Override
    public void attackEquippedUnitsTest() {
        strongDamageTest(alpaca);
        strongDamageTest(archer);
        strongDamageTest(cleric);
        strongDamageTest(fighter);
        strongDamageTest(hero);
        strongDamageTest(swordMaster);
        strongDamageTest(lightSorcerer);
        weakDamageTest(darknessSorcerer);
        normalDamageTest(spectralSorcerer);
    }

    @Test
    @Override
    public void isInRangeTest(){
        super.isInRangeTest();
        assertTrue(getTestUnit().isInRange(lightSorcerer));
    }

}
