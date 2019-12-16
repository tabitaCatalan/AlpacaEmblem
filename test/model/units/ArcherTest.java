package model.units;

import model.items.IEquipableItem;
import model.items.nonMagic.Bow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

  private Archer testArcher;
  private Bow testBow;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    testArcher = new Archer(50, 2, field.getCell(2, 2));
  }

  @Override
  public IUnit getTestUnit() {
    return testArcher;
  }

  @Override
  public void setTestItem(){testBow = new Bow("Test Bow", 10, 2, 3);}

  @Override
  public IEquipableItem getTestItem() {
    return testBow;
  }

  /**
   * Checks if the bow is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipBowTest() {
    checkCorrectEquippedItemTest(testArcher, getBow());
  }

  @Override
  public void equipTestUnit(){
    getTestUnit().addItem(testBow);
    getTestUnit().equipItem(testBow);
  }

  /**
   * function that checks that all units receives strong damage after being attacked while unequipped.
   */
  @Override
  public void attackUnEquippedUnitsTest(){
    strongDamageTest(alpaca);
    strongDamageTest(archer);
    strongDamageTest(cleric);
    strongDamageTest(fighter);
    strongDamageTest(hero);
    strongDamageTest(swordMaster);
    strongDamageTest(darknessSorcerer);
    zeroDamageTest(lightSorcerer);
    strongDamageTest(spectralSorcerer);
  }

  @Override
  public void attackEquippedUnitsTest(){
    normalDamageTest(archer);
    normalDamageTest(cleric);
    normalDamageTest(fighter);
    normalDamageTest(hero);
    normalDamageTest(swordMaster);
    zeroDamageTest(lightSorcerer);
    strongDamageTest(darknessSorcerer);
    strongDamageTest(spectralSorcerer);
  }

  /**
   * {@inheritDoc}
   *
   * Archer can't have adjacent units in range
   * */
  @Test
  @Override
  public void isInRangeTest(){
    super.isInRangeTest();
    assertFalse(getTestUnit().isInRange(lightSorcerer));
  }

  /**
   * {@inheritDoc}
   *
   * Archer has different weapon, it is tested i
   * with another target.
   */
  @Test
  @Override
  public void counterAttackOutOfRange(){
    equipTestUnit();
    equipTargetUnits();
    assertEquals("(2, 2)", getTestUnit().getLocation().toString());
    getTestUnit().moveTo(getField().getCell(2,1));
    assertEquals("(2, 1)", getTestUnit().getLocation().toString());
    assertTrue(getTestUnit().isInRange(getHero()));
    assertFalse(getHero().isInRange(getTestUnit()));
    getTestUnit().useEquippedItemOn(getHero());
    assertEquals(50, getTestUnit().getCurrentHitPoints());
  }

  /**
   * {@inheritDoc}
   *
   * Archer has different range
   * */
  @Test
  public void attackUnitsOutOfRange(){
    equipTargetUnits();
    equipTestUnit();
    assertFalse(getTestUnit().isInRange(getLightSorcerer()));
    assertTrue(getLightSorcerer().isInRange(getTestUnit()));
    getTestUnit().useEquippedItemOn(getLightSorcerer());
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    assertEquals(50, getArcher().getCurrentHitPoints());
  }

}