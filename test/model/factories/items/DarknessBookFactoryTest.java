package model.factories.items;

import org.junit.jupiter.api.Test;


public class DarknessBookFactoryTest extends ItemFactoryTest {

    DarknessBookFactory darknessBookFactory;

    @Override
    public void setUpFactory(){
        darknessBookFactory = new DarknessBookFactory();
    }

    @Override
    public IItemFactory getFactory() {
        return darknessBookFactory;
    }

    @Override
    @Test
    public void itemCreationTest() {
        testCreationOfAnItem("Darkness Book", 10, 1, 2);
    }

}