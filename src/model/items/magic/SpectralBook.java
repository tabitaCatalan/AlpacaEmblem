package model.items.magic;

import model.units.IUnit;

/**
 * This class represents a Magic Book of type Spectral.
 * <p>
 * Spectral Books are strong against Light Books, and weak against Darkness Books
 *
 * @author Tabita Catalan Muñoz
 * @since
 */
public class SpectralBook extends AbstractMagicBook {

    /**
     * Creates a new Magic Book, of type Spectral
     * <p>
     *
     *
     * @param name
     *     the name of the magic spectral book
     * @param power
     *     the damage power of the magic spectral book
     * @param minRange
     *     the minimum range of the magic spectral book
     * @param maxRange
     *     the maximum range of the magic spectral book
     */
    public SpectralBook(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }


    @Override
    public void attack(IUnit targetUnit){
        targetUnit.receiveSpectralAttack(this);
    }

    @Override
    public void receiveLightAttack(LightBook lightBook){
        receiveWeakAttack(lightBook);
    }

    @Override
    public void receiveDarknessAttack(DarknessBook darknessBook){
        receiveStrongAttack(darknessBook);
    }
}
