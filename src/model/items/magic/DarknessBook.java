package model.items.magic;

import model.units.IUnit;

/**
 * This class represents a Magic Book of type Darkness.
 * <p>
 * Darkness Books are strong against Spectral Books, and weak against Light Books
 *
 * @author Tabita Catalan Muñoz
 * @since
 */
public class DarknessBook extends AbstractMagicBook {

    /**
     * Creates a new Magic Book, of type darkness
     * <p>
     *
     *
     * @param name
     *     the name of the magic darkness book
     * @param power
     *     the damage power of the magic darkness book
     * @param minRange
     *     the minimum range of the magic darkness book
     * @param maxRange
     *     the maximum range of the magic darkness book
     */
    public DarknessBook(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipTo(IUnit unit) {
        unit.equipMagicBook(this);
    }

    @Override
    public void attack(IUnit targetUnit){
        targetUnit.receiveDarknessAttack(this);
    }

    @Override
    public void receiveSpectralAttack(SpectralBook spectralBook){
        receiveWeakAttack(spectralBook);
    }

    @Override
    public void receiveLightAttack(LightBook lightBook){
        receiveStrongAttack(lightBook);
    }
}
