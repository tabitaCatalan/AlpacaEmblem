package model.items;

import model.items.AbstractItem;
import model.items.IAbleOfAttack;
import model.items.magic.DarknessBook;
import model.units.IUnit;

public abstract class AbstractDamageItem extends AbstractItem implements IAbleOfAttack {

    /**
     * Constructor for an default item that is able of attack
     *
     * @param name
     *     the name of the item
     * @param power
     *     the power of the item (amount of damage it does)
     * @param minRange
     *     the minimum range of the item
     * @param maxRange
     *     the maximum range of the item
     */
    public AbstractDamageItem(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void actOn(IUnit targetUnit){
        if(isInRange(targetUnit)) {
            attack(targetUnit);
            targetUnit.reactToAttack(getOwner());
        }
    }

    @Override
    public void reactTo(IUnit unit){
        if (isInRange(unit)) {
            attack(unit);
        }
    }

    @Override
    public abstract void attack(IUnit targetUnit);
}
