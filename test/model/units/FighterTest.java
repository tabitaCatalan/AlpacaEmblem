package model.units;

import model.items.IEquipableItem;
import model.items.nonMagic.Axe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 */
public class FighterTest extends AbstractTestUnit {

  private Fighter testFighter;
  private Axe testAxe;

  @Override
  public void setTestUnit() {
    testFighter = new Fighter(50, 2, field.getCell(2, 2));
  }

  @Override
  public IUnit getTestUnit() {
    return testFighter;
  }

  @Override
  public void setTestItem(){
    testAxe = new Axe("Test Axe", 10, 1, 2);
  }

  @Override
  public IEquipableItem getTestItem(){
    return testAxe;
  }

  /**{@inheritDoc}
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipAxeTest() {
    checkCorrectEquippedItemTest(testFighter, axe);
  }


  @Override
  public void equipTestUnit(){
    getTestUnit().addItem(testAxe);
    getTestUnit().equipItem(testAxe);
  }

  @Override
  public void attackEquippedUnitsTest(){
    normalDamageTest(archer);
    normalDamageTest(cleric);
    normalDamageTest(fighter);
    strongDamageTest(hero);
    weakDamageTest(swordMaster);
    strongDamageTest(lightSorcerer);
    strongDamageTest(darknessSorcerer);
    strongDamageTest(spectralSorcerer);
  }

  @Test
  @Override
  public void isInRangeTest(){
    super.isInRangeTest();
    assertTrue(getTestUnit().isInRange(lightSorcerer));
  }


}