package model.items;

import model.units.IUnit;

public interface IHealer extends IEquipableItem{
    void heal(IUnit targetUnit);
}
