package model.factories.units;

import model.units.Alpaca;
import org.junit.jupiter.api.Test;

public class AlpacaFactoryTest extends UnitFactoryTest {
    AlpacaFactory alpacaFactory;

    @Override
    public void setUpFactory(){
        alpacaFactory = new AlpacaFactory();
    }

    @Override
    public IUnitFactory getFactory() {
        return alpacaFactory;
    }

    @Override
    @Test
    public void unitCreationTest() {
        testWellCreatedUnit(70, 3);
    }
}
