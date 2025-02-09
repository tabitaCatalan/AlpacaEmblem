package model.factories.items;

import org.junit.jupiter.api.Test;

public class LightBookFactoryTest extends ItemFactoryTest {
    LightBookFactory lightBookFactory;

    @Override
    public void setUpFactory(){
        lightBookFactory = new LightBookFactory();
    }

    @Override
    public IItemFactory getFactory() {
        return lightBookFactory;
    }

    @Override
    @Test
    public void itemCreationTest() {
        testWellCreatedItem("Light Book", 50, 1, 3);
    }

}
