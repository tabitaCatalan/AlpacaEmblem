package model.units;

import org.junit.jupiter.api.Test;

public class SorcererTest extends AbstractTestUnit {
    private Sorcerer sorcerer;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(50, 2, field.getCell(0, 0));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    @Test
    @Override
    public void equipSpectralBookTest(){
        checkCorrectEquippedItem(sorcerer, spectralBook);
    }

    @Test
    @Override
    public void equipDarknessBookTest(){
        checkCorrectEquippedItem(sorcerer, darknessBook);
    }

    @Test
    @Override
    public void equipLightBookTest(){
        checkCorrectEquippedItem(sorcerer, lightBook);
    }
}
