package model.factories.items;

import org.junit.jupiter.api.Test;

public class SpectralBookFactoryTest extends ItemFactoryTest {
    SpectralBookFactory spectralBookFactory;

    @Override
    public void setUpFactory(){
        spectralBookFactory = new SpectralBookFactory();
    }

    @Override
    public IItemFactory getFactory() {
        return spectralBookFactory;
    }

    @Override
    @Test
    public void itemCreationTest() {
        testWellCreatedItem("Spectral Book", 50, 1, 3);
    }

}
