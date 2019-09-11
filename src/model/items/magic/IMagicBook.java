package model.items.magic;

import model.items.IAbleOfAttack;
import model.items.IEquipableItem;
import model.items.nonMagic.INonMagical;

public interface IMagicBook extends IAbleOfAttack {

    void receiveNonMagicalAttack(INonMagical nonMagicWeapon);
}
