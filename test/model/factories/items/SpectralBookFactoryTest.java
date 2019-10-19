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
        testCreationOfAnItem("Spectral Book", 10, 1, 2);
    }

}
