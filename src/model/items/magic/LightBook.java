package model.items.magic;

import model.units.IUnit;

/**
 * This class represents a Magic Book of type Light.
 * <p>
 * Light Books are strong against Darkness Books, and weak against Spectral Books
 *
 * @author Tabita Catalan Muñoz
 * @since
 */
public class LightBook extends AbstractMagicBook {

    /**
     * Creates a new Magic Book of type Light
     * <p>
     *
     *
     * @param name
     *     the name of the magic light book
     * @param power
     *     the damage power of the magic light book
     * @param minRange
     *     the minimum range of the magic light book
     * @param maxRange
     *     the maximum range of the magic light book
     */
    public LightBook(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipTo(IUnit unit) {
        unit.equipMagicBook(this);
    }

    @Override
    public void attack(IUnit targetUnit){
        targetUnit.receiveLightAttack(this);
    }


    @Override
    public void receiveSpectralAttack(SpectralBook spectralBook){
        receiveStrongAttack(spectralBook);
    }

    @Override
    public void receiveDarknessAttack(DarknessBook darknessBook){
        receiveWeakAttack(darknessBook);
    }
}
