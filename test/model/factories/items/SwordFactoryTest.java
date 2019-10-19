package model.factories.items;

import org.junit.jupiter.api.Test;


public class SwordFactoryTest extends ItemFactoryTest {

    SwordFactory swordFactory;

    @Override
    public void setUpFactory(){
        swordFactory = new SwordFactory();
    }

    @Override
    public IItemFactory getFactory() {
        return swordFactory;
    }

    @Override
    @Test
    public void itemCreationTest() {
        testWellCreatedItem("Sword", 40, 1, 1);
    }

}
