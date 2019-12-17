package model.items.nonMagic;

import model.items.AbstractDamageItem;
import model.items.AbstractDamageItemTest;
import model.items.IAbleOfAttack;

public abstract class AbstractWeaponTest extends AbstractDamageItemTest {

    @Override
    public abstract INonMagical getTestItem();

    @Override
    public void attackEquippedTargetUnitsTest(){
        strongDamageTest(alpaca);
        normalDamageTest(archer);
        normalDamageTest(cleric);
        strongDamageTest(darknessSorcerer);
        strongDamageTest(spectralSorcerer);
    }

}
