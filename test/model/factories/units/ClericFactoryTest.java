package model.factories.units;

import org.junit.jupiter.api.Test;

public class ClericFactoryTest extends UnitFactoryTest {
    ClericFactory clericFactory;

    @Override
    public void setUpFactory(){
        clericFactory = new ClericFactory();
    }

    @Override
    public IUnitFactory getFactory() {
        return clericFactory;
    }

    @Override
    @Test
    public void unitCreationTest() {
        testWellCreatedUnit(70, 2);
    }
}
