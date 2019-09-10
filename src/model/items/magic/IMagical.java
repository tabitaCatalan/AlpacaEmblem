package model.items.magic;

import model.items.IEquipableItem;
import model.items.nonMagic.INonMagical;

public interface IMagical extends IEquipableItem {

    void receiveNonMagicalAttack(INonMagical nonMagicWeapon);
}
