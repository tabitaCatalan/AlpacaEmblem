package model.items;

import model.units.IUnit;

public interface IAbleOfAttack {
    /**
     * item inflicts damage on targetUnit
     * @param targetUnit
     */
    void attack(IUnit targetUnit);

    /*
     * item attacks targetUnit, after being attacked by her.
     * @param targetUnit
     */
    //void counterAttack(IUnit targetUnit);*/
}
