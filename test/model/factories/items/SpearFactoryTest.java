package model.factories.items;

import org.junit.jupiter.api.Test;


public class SpearFactoryTest extends ItemFactoryTest {

    SpearFactory spearFactory;

    @Override
    public void setUpFactory(){
        spearFactory = new SpearFactory();
    }

    @Override
    public IItemFactory getFactory() {
        return spearFactory;
    }

    @Override
    @Test
    public void itemCreationTest() {
        testCreationOfAnItem("Spear", 10, 1, 2);
    }

}
