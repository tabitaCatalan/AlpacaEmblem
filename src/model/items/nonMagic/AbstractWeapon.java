package model.items.nonMagic;

import model.items.AbstractDamageItem;
import model.items.magic.DarknessBook;
import model.items.magic.IMagicBook;
import model.items.magic.LightBook;
import model.items.magic.SpectralBook;
import model.units.IUnit;

public abstract class AbstractWeapon extends AbstractDamageItem implements INonMagical {

    /**
     * Constructor for an default weapon: a non magic item that is able of attack
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
    public abstract void attack(IUnit targetUnit);

    @Override
    public void receiveMagicalAttack(IMagicBook magicWeapon) {
        receiveStrongAttack(magicWeapon);
    }

    @Override
    public void receiveSpectralAttack(SpectralBook spectralBook){
        receiveMagicalAttack(spectralBook);
    }

    @Override
    public void receiveLightAttack(LightBook lightBook){
        receiveMagicalAttack(lightBook);
    }

    @Override
    public void receiveDarknessAttack(DarknessBook darknessBook){
        receiveMagicalAttack(darknessBook);
    }

}
