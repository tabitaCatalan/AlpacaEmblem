package model.factories.items;

import model.items.IEquipableItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Tests the correct creation of items using factories
 *
 * @author Tabita Catalán Muñoz
 * @version v2.0
 * @since v2.0
 * */
public abstract class ItemFactoryTest {

    @BeforeEach
    public void setUp() {
        setUpFactory();
    }

    public abstract void setUpFactory();

    public abstract IItemFactory getFactory();

    @Test
    public abstract void itemCreationTest();

    protected void testWellCreatedItem(String name, int power, int minRange, int maxRange){
        IEquipableItem createdItem = getFactory().createItem();
        assertEquals(name, createdItem.getName());
        assertEquals(power, createdItem.getPower());
        assertEquals(minRange, createdItem.getMinRange());
        assertEquals(maxRange, createdItem.getMaxRange());
    }
}
