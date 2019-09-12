package model.items;

import model.items.magic.DarknessBook;
import model.items.magic.LightBook;
import model.items.magic.SpectralBook;
import model.units.IUnit;

public abstract class AbstractHealer extends AbstractItem implements IHealer{

    /**
     * Constructor for a default healer item
     *
     * @param name     the name of the healer item
     * @param power    the power of the healer item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the healer item
     * @param maxRange
     */
    public AbstractHealer(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void actOn(IUnit targetUnit){
        heal(targetUnit);
    }

    public void heal(IUnit targetUnit){
        targetUnit.beingHealed(getPower());
    }

    public void receiveSpectralAttack(SpectralBook spectralBook){
        receiveStrongAttack(spectralBook);
    }

    public void receiveLightAttack(LightBook lightBook){
        receiveStrongAttack(lightBook);
    }

    public void receiveDarknessAttack(DarknessBook darknessBook){
        receiveStrongAttack(darknessBook);
    }
}
