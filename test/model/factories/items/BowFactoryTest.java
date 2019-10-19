package model.factories.items;

import org.junit.jupiter.api.Test;


public class BowFactoryTest extends ItemFactoryTest {

    BowFactory bowFactory;

    @Override
    public void setUpFactory(){
        bowFactory = new BowFactory();
    }

    @Override
    public IItemFactory getFactory() {
        return bowFactory;
    }

    @Override
    @Test
    public void itemCreationTest() {
        testCreationOfAnItem("Long Bow", 10, 2, 3);
    }

}
