package model.units;

import model.items.nonMagic.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Ignacio Slater Muñoz
 */
public class SwordMasterTest extends AbstractTestUnit {

  private SwordMaster testSwordMaster;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    testSwordMaster = new SwordMaster(50, 2, field.getCell(2, 2));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return testSwordMaster;
  }

  @Test
  @Override
  public void equipSwordTest() {
    checkCorrectEquippedItem(testSwordMaster, sword);
  }


  @Override
  public void equipTestUnit(){
    Sword testSword = new Sword("Test Sword", 10, 1, 2);
    getTestUnit().addItem(testSword);
    getTestUnit().equipItem(testSword);
  }

  @Override
  public void attackEquippedUnitsTest(){
    normalDamageTest(archer);
    normalDamageTest(cleric);
    strongDamageTest(fighter);
    weakDamageTest(hero);
    normalDamageTest(swordMaster);
  }


}