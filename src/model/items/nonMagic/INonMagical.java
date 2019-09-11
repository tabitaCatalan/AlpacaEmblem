package model.items.nonMagic;

import model.items.IAbleOfAttack;
import model.items.IEquipableItem;
import model.items.magic.IMagicBook;

public interface INonMagical extends IAbleOfAttack {

    void receiveMagicalAttack(IMagicBook magicWeapon);
}
