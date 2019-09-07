package model.combat;

import model.units.Archer;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

public class ArcherTest extends CombatTest {
    private Archer testArcher;

    @Override
    void setTestUnit() {
        testArcher = new Archer(50, 2, field.getCell(2, 2));
    }

    @Override
    IUnit getTestUnit() {
        return testArcher;
    }

    @Override
    public void equipTestUnit(){
        getTestUnit().addItem(bow);
        getTestUnit().equipItem(bow);
    }

    /*@Override
    @Test
    void useItemOnAllTargetUnitsTest() {
        //attackUnitsTest();
    }*/


}
