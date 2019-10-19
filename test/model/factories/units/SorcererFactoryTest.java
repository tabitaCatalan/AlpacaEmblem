package model.factories.units;

import org.junit.jupiter.api.Test;

public class SorcererFactoryTest extends UnitFactoryTest {
    SorcererFactory sorcererFactory;

    @Override
    public void setUpFactory(){
        sorcererFactory = new SorcererFactory();
    }

    @Override
    public IUnitFactory getFactory() {
        return sorcererFactory;
    }

    @Override
    @Test
    public void unitCreationTest() {
        testWellCreatedUnit(50, 1);
    }
}
