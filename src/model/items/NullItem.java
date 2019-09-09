package model.items;

import model.units.IUnit;

/**
 * @author Tabita Catalán Muñoz
 */
public class NullItem extends AbstractItem{

    /**
     * Creates a new NullItem
     * <p>
     * An unit that does not have an equipped Item has a reference to a NullItem. It has range 0,
     * and power 0.
     */
    public NullItem() {
        super("Null Item", 0, 0, 0);
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
    public boolean isNullItem(){
        return true;
    }
}
