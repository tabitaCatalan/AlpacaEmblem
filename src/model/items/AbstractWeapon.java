package model.items;

import model.units.IUnit;

public abstract class AbstractWeapon extends AbstractItem implements IAbleOfAttack{

    /**
     * Constructor for an default weapon: an item that is able of attack
     *
     * @param name
     *     the name of the weapon
     * @param power
     *     the power of the weapon (amount of damage it does)
     * @param minRange
     *     the minimum range of the weapon
     * @param maxRange
     *     the maximum range of the weapon
     */
    public AbstractWeapon(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void actOn(IUnit targetUnit){
        attack(targetUnit);
        targetUnit.reactToAttack(getOwner());
    }

    @Override
    public void reactTo(IUnit unit){
        attack(unit);
    }

    @Override
    public abstract void attack(IUnit targetUnit);
}
