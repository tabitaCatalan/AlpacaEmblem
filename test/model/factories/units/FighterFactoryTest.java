package model.factories.units;

import org.junit.jupiter.api.Test;

public class FighterFactoryTest extends UnitFactoryTest {
    FighterFactory fighterFactory;

    @Override
    public void setUpFactory(){
        fighterFactory = new FighterFactory();
    }

    @Override
    public IUnitFactory getFactory() {
        return fighterFactory;
    }

    @Override
    @Test
    public void unitCreationTest() {
        testWellCreatedUnit(90, 1);
    }
}
