package model.items;

import model.units.IUnit;

public interface IAbleOfAttack extends IEquipableItem {
    /**
     * item inflicts damage on targetUnit
     * @param targetUnit
     */
    void attack(IUnit targetUnit);
}
