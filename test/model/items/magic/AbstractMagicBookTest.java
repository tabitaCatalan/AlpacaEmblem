package model.items.magic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.items.AbstractDamageItem;
import model.items.AbstractDamageItemTest;
import model.units.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractMagicBookTest extends AbstractDamageItemTest {

    @Override
    public abstract IMagicBook getTestItem();

    @Override
    public void attackEquippedTargetUnitsTest(){
        strongDamageTest(alpaca);
        strongDamageTest(archer);
        strongDamageTest(cleric);
        strongDamageTest(fighter);
        strongDamageTest(hero);
        strongDamageTest(swordMaster);
    }
}
