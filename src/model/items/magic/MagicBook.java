package model.items.magic;

import model.items.AbstractDamageItem;
import model.items.nonMagic.*;
import model.units.IUnit;
/**
 * This class represents a Magic Book.
 * <p>
 * Magic books are strong against NonMagic weapons as Bows and Swords, but they are strong against Magic Books too.
 * Can be of three types: Spectral, Light and Darkness. They can only be equipped by Sorcerers.
 *
 * @author Tabita Catalan Muñoz
 * @since
 */
public abstract class MagicBook extends AbstractDamageItem implements IMagicBook {

    /**
     * Creates a new Magic Book.
     * <p>
     *
     *
     * @param name
     *     the name of the magic book
     * @param power
     *     the damage power of the magic book
     * @param minRange
     *     the minimum range of the magic book
     * @param maxRange
     *     the maximum range of the magic book
     */
    public MagicBook(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipTo(IUnit unit) {
        unit.equipMagicBook(this);
    }

    public void receiveNonMagicalAttack(INonMagical nonMagicWeapon){
        receiveStrongAttack(nonMagicWeapon);
    }

    @Override
    public void receiveAxeAttack(Axe axe){
        receiveNonMagicalAttack(axe);
    }

    @Override
    public void receiveBowAttack(Bow bow){
        receiveNonMagicalAttack(bow);
    }

    @Override
    public void receiveSwordAttack(Sword sword){
        receiveNonMagicalAttack(sword);
    }

    @Override
    public void receiveSpearAttack(Spear spear){
        receiveNonMagicalAttack(spear);
    }

}
