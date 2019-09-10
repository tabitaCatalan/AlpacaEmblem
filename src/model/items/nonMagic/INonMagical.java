package model.items.nonMagic;

import model.items.IEquipableItem;
import model.items.magic.IMagicBook;

public interface INonMagical extends IEquipableItem {

    void receiveMagicalAttack(IMagicBook magicWeapon);
}
