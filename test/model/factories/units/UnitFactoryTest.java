package model.factories.units;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Tests the correct creation of units using factories
 *
 * @author Tabita Catalán Muñoz
 * @version v2.0
 * @since v2.0
 * */
public abstract class UnitFactoryTest {

    @BeforeEach
    public void setUp() {
        setUpFactory();
    }

    public abstract void setUpFactory();

    public abstract IUnitFactory getFactory();

    @Test
    public abstract void unitCreationTest();

    protected void testWellCreatedUnit(int hitPoints, int movement){
        IUnit createdUnit = getFactory().createUnit(new Location(0,0));
        assertEquals(hitPoints, createdUnit.getCurrentHitPoints());
        assertEquals(0, createdUnit.getNumberOfItems());
        assertEquals(movement, createdUnit.getMovement());
    }
}
