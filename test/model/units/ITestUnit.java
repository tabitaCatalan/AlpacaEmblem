package model.units;


import model.items.*;
import model.items.nonMagic.Axe;
import model.items.nonMagic.Bow;
import model.items.nonMagic.Spear;
import model.items.nonMagic.Sword;
import model.map.Field;
import org.junit.jupiter.api.Test;

/**
 * Interface that defines the common behaviour of all the test for the units classes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface ITestUnit {

  // Settings
  /**
   * Set up the game field
   */
  void setField();

  /**
   * @return the test field
   */
  Field getField();

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  void setTestUnit();

  /**
   * @return the current unit being tested
   */
  IUnit getTestUnit();

  /**
   * Set up a target Alpaca
   */
  void setTargetAlpaca();

  /**
   * @return the target Alpaca
   */
  Alpaca getTargetAlpaca();

  /**
   * Creates a set of testing weapons
   */
  void setWeapons();

  /**
   * Checks that the constructor works properly.
   */
  @Test
  void constructorTest();

  // Exchanges
  /**
   * Checks if an item was correctly given away to another unit
   */
  @Test
  void successfulExchange();

  /**
   * Checks its not possible to give away an item that's not in unit's inventory
   */
  @Test
  void notGiveAwayItemNotOwned();

  // Inventory and Equip items
  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  void equipAxeTest();

  /**
   * @return the test axe
   */
  Axe getAxe();

  /**
   * Checks if the bow is equipped correctly to the unit
   */
  @Test
  void equipBowTest();

  /**
   * @return the test bow
   */
  Bow getBow();

  /**
   * Checks if the spear is equipped correctly to the unit
   */
  @Test
  void equipSpearTest();

  /**
   * @return the test spear
   */
  Spear getSpear();

  /**
   * Checks if the staff is equipped correctly to the unit
   */
  @Test
  void equipStaffTest();

  /**
   * @return the test staff
   */
  Staff getStaff();

  /**
   * Checks if the sword is equipped correctly to the unit
   */
  @Test
  void equipSwordTest();

  /**
   * @return the test sword
   */
  Sword getSword();

  /**
   * Checks an item is correctly added to inventory
   */
  @Test
  void addItemTest();

  /**
   * Checks that no more items than maximum are added to inventory
   */
  @Test
  void addItemMoreThanMaxTest();

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  void checkIncorrectEquippedItem(IEquipableItem item);

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was equipped
   *
   * @param item
   *     to be equipped
   */
  void checkCorrectEquippedItem(IUnit unit, IEquipableItem item);

  // Movement
  /**
   * Checks if the unit moves correctly
   */
  @Test
  void testMovement();


}
