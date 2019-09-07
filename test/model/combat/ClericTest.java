package model.combat;

import model.units.Cleric;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

public class ClericTest extends CombatTest {
    private Cleric testCleric;

    @Override
    void setTestUnit() {
        testCleric = new Cleric(50, 2, field.getCell(2, 2));
    }

    @Override
    IUnit getTestUnit() {
        return testCleric;
    }

    @Override
    public void equipTestUnit(){
        getTestUnit().addItem(staff);
        getTestUnit().equipItem(staff);
    }

    @Override
    @Test
    void useItemOnAllTargetUnitsTest() {
        healUnitsTest();
    }
}
