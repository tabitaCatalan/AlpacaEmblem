package model.factories.units;

import org.junit.jupiter.api.Test;

public class ArcherFactoryTest extends UnitFactoryTest {
    ArcherFactory archerFactory;

    @Override
    public void setUpFactory(){
        archerFactory = new ArcherFactory();
    }

    @Override
    public IUnitFactory getFactory() {
        return archerFactory;
    }

    @Override
    @Test
    public void unitCreationTest() {
        testWellCreatedUnit(50, 2);
    }
}
