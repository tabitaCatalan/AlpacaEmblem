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
        testWellCreatedItem("Darkness Book", 50, 1, 3);
    }

}