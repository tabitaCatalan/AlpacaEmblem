package model.factories.units;

import org.junit.jupiter.api.Test;

public class HeroFactoryTest extends UnitFactoryTest {
    HeroFactory heroFactory;

    @Override
    public void setUpFactory(){
        heroFactory = new HeroFactory();
    }

    @Override
    public IUnitFactory getFactory() {
        return heroFactory;
    }

    @Override
    @Test
    public void unitCreationTest() {
        testWellCreatedUnit(70, 3);
    }
}
