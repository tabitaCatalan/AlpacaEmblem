package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.nonMagic.Spear;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class HeroTest extends AbstractTestUnit {

  private Hero testHero;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    testHero = new Hero(50, 2, field.getCell(2, 2));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return testHero;
  }

  @Test
  @Override
  public void equipSpearTest() {
    checkCorrectEquippedItem(testHero, spear);
  }


  @Override
  public void equipTestUnit(){
    Spear testSpear = new Spear("Test Spear", 10, 1, 2);
    getTestUnit().addItem(testSpear);
    getTestUnit().equipItem(testSpear);
  }

  @Override
  public void attackEquippedUnitsTest(){
    normalDamageTest(archer);
    normalDamageTest(cleric);
    weakDamageTest(fighter);
    normalDamageTest(hero);
    strongDamageTest(swordMaster);
  }
}