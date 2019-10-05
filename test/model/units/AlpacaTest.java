package model.units;

import model.items.IEquipableItem;
import model.items.NullItem;
import model.items.nonMagic.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test set for the alpaca unit
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {

  private Alpaca testAlpaca;
  private NullItem testNullItem;

  @Override
  public void setTestUnit() {
    testAlpaca = new Alpaca(50, 2, field.getCell(2, 2));
  }

  @Override
  public Alpaca getTestUnit() {
    return testAlpaca;
  }

  @Override
  public void setTestItem(){
    testNullItem = new NullItem();
  }

  @Override
  public IEquipableItem getTestItem(){
    return testNullItem;
  }


  @Override
  @Test
  public void addItemMoreThanMaxTest(){
    assertTrue(getTestUnit().hasSpaceInInventory());
    getTestUnit().addItem(getAxe());
    getTestUnit().addItem(getBow());
    getTestUnit().addItem(getSpear());
    getTestUnit().addItem(getSword());
    assertTrue(getTestUnit().hasSpaceInInventory());
    assertEquals(4, getTestUnit().getNumberOfItems());
  }

  @Override
  public void equipTestUnit(){}

  /**{@inheritDoc}
   *
   * Alpaca can't equip items
   * */
  @Test
  protected void isTestUnitEquippedTest(){
    equipTestUnit();
    assertFalse(getTestUnit().hasEquippedItem());
  }

  /** {@inheritDoc}
   * Alpaca doesn't cause damage on other units, cause can't get equipped.
   */
  public void attackUnEquippedUnitsTest(){
    zeroDamageTest(alpaca);
    zeroDamageTest(archer);
    zeroDamageTest(cleric);
    zeroDamageTest(fighter);
    zeroDamageTest(hero);
    zeroDamageTest(swordMaster);
  }

  @Override
  public void attackEquippedUnitsTest(){
    zeroDamageTest(archer);
    zeroDamageTest(cleric);
    zeroDamageTest(fighter);
    zeroDamageTest(hero);
    zeroDamageTest(swordMaster);
    zeroDamageTest(lightSorcerer);
    zeroDamageTest(darknessSorcerer);
    zeroDamageTest(spectralSorcerer);
  }

  /**
   * {@inheritDoc}
   * <p>
   * Alpaca can't equip any item, so it has range 1 (because of the NullItem).
   */
  @Test
  @Override
  public void isInRangeTest(){
    equipTestUnit();
    assertFalse(getTestUnit().isInRange(alpaca));
    assertFalse(getTestUnit().isInRange(archer));
    assertFalse(getTestUnit().isInRange(cleric));
    assertFalse(getTestUnit().isInRange(fighter));
    assertFalse(getTestUnit().isInRange(hero));
    assertFalse(getTestUnit().isInRange(swordMaster));
    assertFalse(getTestUnit().isInRange(darknessSorcerer));
    assertFalse(getTestUnit().isInRange(spectralSorcerer));
    assertTrue(getTestUnit().isInRange(lightSorcerer));
  }

  @Test
  public void deadUnitDoesNotCounterAttackTest(){
    equipTestUnit();
    equipTargetUnits();
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    assertEquals(targetHP, getDarknessSorcerer().getCurrentHitPoints());
    getDarknessSorcerer().receiveDamage(targetHP-1);
    getTestUnit().useEquippedItemOn(getDarknessSorcerer());
    assertTrue(getDarknessSorcerer().isAlive()); // Alpaca does not attack
    assertEquals(50, getTestUnit().getCurrentHitPoints());
  }
}