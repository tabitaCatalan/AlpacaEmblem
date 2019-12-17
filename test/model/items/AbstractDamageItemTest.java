package model.items;

import model.units.IUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractDamageItemTest extends AbstractTestItem{
    @Override
    public abstract IAbleOfAttack getTestItem();

    @Override
    protected abstract void attackEquippedTargetUnitsTest();
}
