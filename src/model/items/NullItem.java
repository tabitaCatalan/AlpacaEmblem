package model.items;

import model.items.magic.DarknessBook;
import model.items.magic.LightBook;
import model.items.magic.SpectralBook;
import model.items.nonMagic.Axe;
import model.items.nonMagic.Bow;
import model.items.nonMagic.Spear;
import model.items.nonMagic.Sword;
import model.units.IUnit;

/**
 * @author Tabita Catalán Muñoz
 */
public class NullItem extends AbstractItem{

    /**
     * Creates a new NullItem
     * <p>
     * An unit that does not have an equipped Item has a reference to a NullItem. It has range 1,
     * and power 0.
     */
    public NullItem() {
        super("Null Item", 0, 1, 1);
    }

    @Override
    public void equipTo(IUnit unit) {
        unit.disarm();
    }

    @Override
    public void receiveBowAttack(Bow bow){
        receiveStrongAttack(bow);
    }

    @Override
    public void receiveAxeAttack(Axe axe){
        receiveStrongAttack(axe);
    }

    @Override
    public void receiveSpearAttack(Spear spear){
        receiveStrongAttack(spear);
    }

    @Override
    public void receiveSwordAttack(Sword sword){
        receiveStrongAttack(sword);
    }

    @Override
    public void receiveSpectralAttack(SpectralBook spectralBook){ receiveStrongAttack(spectralBook); }

    public void receiveLightAttack(LightBook lightBook){
        receiveStrongAttack(lightBook);
    }

    public void receiveDarknessAttack(DarknessBook darknessBook){
        receiveStrongAttack(darknessBook);
    }

    @Override
    public boolean isNullItem(){
        return true;
    }
}
