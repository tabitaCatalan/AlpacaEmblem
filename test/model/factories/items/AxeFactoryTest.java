package model.factories.items;

import org.junit.jupiter.api.Test;


public class AxeFactoryTest extends ItemFactoryTest {

    AxeFactory axeFactory;

    @Override
    public void setUpFactory(){
        axeFactory = new AxeFactory();
    }

    @Override
    public IItemFactory getFactory() {
        return axeFactory;
    }

    @Override
    @Test
    public void itemCreationTest() {
        testWellCreatedItem("Battle Axe", 40, 1, 1);
    }

}
