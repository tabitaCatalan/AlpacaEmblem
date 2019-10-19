package model.factories.units;

import org.junit.jupiter.api.Test;

public class SwordMasterFactoryTest extends UnitFactoryTest {
    SwordMasterFactory swordMasterFactory;

    @Override
    public void setUpFactory(){
        swordMasterFactory = new SwordMasterFactory();
    }

    @Override
    public IUnitFactory getFactory() {
        return swordMasterFactory;
    }

    @Override
    @Test
    public void unitCreationTest() {
        testWellCreatedUnit(70, 2);
    }
}
