package model.factories.items;

import org.junit.jupiter.api.Test;


public class StaffFactoryTest extends ItemFactoryTest {

    StaffFactory staffFactory;

    @Override
    public void setUpFactory(){
        staffFactory = new StaffFactory();
    }

    @Override
    public IItemFactory getFactory() {
        return staffFactory;
    }

    @Override
    @Test
    public void itemCreationTest() {
        testWellCreatedItem("Staff", 40, 1, 1);
    }

}