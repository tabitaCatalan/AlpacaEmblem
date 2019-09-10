package model.items.nonMagic;

import model.items.IEquipableItem;
import model.items.magic.IMagical;

public interface INonMagical extends IEquipableItem {

    void receiveMagicalAttack(IMagical magicWeapon);
}
