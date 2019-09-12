package model;

import model.items.IEquipableItem;
import model.items.Staff;
import model.items.magic.DarknessBook;
import model.items.magic.IMagicBook;
import model.items.magic.LightBook;
import model.items.magic.SpectralBook;
import model.items.nonMagic.Axe;
import model.items.nonMagic.Bow;
import model.items.nonMagic.Spear;
import model.items.nonMagic.Sword;
import model.map.Field;
import model.map.Location;
import model.units.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class implements some basic methods that will be used in testing in <i>items</i> and <i>units</i> packages.
 * It defines a field, units and weapons.
 * @author Tabita Catalán Muñoz
 * @since
 */

public abstract class AbstractModelTest {
    // Field
    protected Field field;

    // target units parameters
    protected int targetHP = 50;
    protected int targetMovement = 2;

    // target units
    protected Alpaca alpaca;
    protected Archer archer;
    protected Cleric cleric;
    protected Fighter fighter;
    protected Hero hero;
    protected SwordMaster swordMaster;
    protected Sorcerer darknessSorcerer;
    protected Sorcerer lightSorcerer;
    protected Sorcerer spectralSorcerer;

    // target units parameters
    protected int targetPower = 10;

    // test items
    protected Bow bow;
    protected Axe axe;
    protected Sword sword;
    protected Staff staff;
    protected Spear spear;
    protected IMagicBook spectralBook;
    protected IMagicBook darknessBook;
    protected IMagicBook lightBook;


    /**
     * Set up the game field
     */
    public void setField() {
        this.field = new Field();
        this.field.addCells(true,
                new Location(0, 0), new Location(0, 1), new Location(0, 2), new Location(0, 3), new Location(0, 4),
                new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(1, 3), new Location(1, 4),
                new Location(2, 0), new Location(2, 1), new Location(2, 2) , new Location(2, 3), new Location(2, 4),
                new Location(3, 0), new Location(3, 1), new Location(3, 2), new Location(3, 3), new Location(3, 4),
                new Location(4, 0), new Location(4, 1), new Location(4, 2), new Location(4, 3), new Location(4, 4));
    }

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    public abstract void setTestUnit();

    /**
     * Sets up the main item being tested
     */
    protected abstract void setTestItem();

    /**
     * Set up the target units
     */
    public void setTargetUnits(){
        alpaca = new Alpaca(targetHP, targetMovement, field.getCell(0, 2));
        archer = new Archer(targetHP, targetMovement, field.getCell(3, 3));
        cleric = new Cleric(targetHP, targetMovement, field.getCell(2, 4));
        fighter = new Fighter(targetHP, targetMovement, field.getCell(2, 0));
        hero = new Hero(targetHP, targetMovement, field.getCell(1, 3));
        swordMaster = new SwordMaster(targetHP, targetMovement, field.getCell(3,1));
        spectralSorcerer = new Sorcerer(targetHP, targetMovement, field.getCell(1,1));
        darknessSorcerer = new Sorcerer(targetHP, targetMovement, field.getCell(4,2));
        lightSorcerer = new Sorcerer(targetHP, targetMovement, field.getCell(2,3));
    }

    /**
     * Creates a set of testing weapons
     */
    public void setWeapons() {
        this.axe = new Axe("Axe", targetPower, 1, 2);
        this.sword = new Sword("Sword", targetPower, 1, 2);
        this.spear = new Spear("Spear", targetPower, 1, 2);
        this.staff = new Staff("Staff", targetPower, 1, 2);
        this.bow = new Bow("Bow", targetPower, 2, 3);
        this.spectralBook = new SpectralBook("Book of Souls", targetPower, 1, 2);
        this.darknessBook = new DarknessBook("Necronomicon", targetPower, 1, 2);
        this.lightBook = new LightBook("Light Book", targetPower, 1, 2);
    }


    // GETTERS

    // Getter field
    /**
     * @return the test field
     */
    public Field getField() {
        return field;
    }

    // Getters units

    /**
     * @return the current unit being tested
     */
    public abstract IUnit getTestUnit();


    /**
     * @return the target Alpaca
     */
    protected Alpaca getAlpaca() {
        return alpaca;
    }

    /**
     * @return the target Archer
     */
    protected Archer getArcher() {
        return archer;
    }

    /**
     * @return the target Cleric
     */
    protected Cleric getCleric() {
        return cleric;
    }

    /**
     * @return the target Fighter
     */
    protected Fighter getFighter() {
        return fighter;
    }

    /**
     * @return the target Hero
     */
    protected Hero getHero() {
        return hero;
    }

    /**
     * @return the target Dark Sorcerer
     */
    protected Sorcerer getDarknessSorcerer() {
        return darknessSorcerer;
    }

    /**
     * @return the target LightSorcerer
     */
    protected Sorcerer getLightSorcerer() {
        return lightSorcerer;
    }

    /**
     * @return the target SpectralSorcerer
     */
    protected Sorcerer getSpectralSorcerer() {
        return spectralSorcerer;
    }

    /**
     * @return the target Alpaca
     */
    protected SwordMaster getSwordMaster() {
        return swordMaster;
    }


    // Getters items

    /**
     * @return the current item being tested
     */
    protected abstract IEquipableItem getTestItem();

    /**
     * @return the test bow
     */
    protected Bow getBow() {
        return bow;
    }

    /**
     * @return the test axe
     */
    protected Axe getAxe() {
        return axe;
    }

    /**
     * @return the test sword
     */
    protected Sword getSword() {
        return sword;
    }

    /**
     * @return the test spear
     */
    protected Spear getSpear() {
        return spear;
    }

    /**
     * @return the test staff
     */
    protected Staff getStaff() {
        return staff;
    }

    /**
     * @return the test magic book of type Spectral
     */
    protected IMagicBook getSpectralBook() {
        return spectralBook;
    }

    /**
     * @return the test magic book of type Darkness
     */
    protected IMagicBook getDarknessBook() {
        return darknessBook;
    }

    /**
     * @return the test magic book of type Light
     */
    protected IMagicBook getLightBook() {
        return lightBook;
    }


    /**
     * check currentHP of testUnit, after using the equipped item on targetUnit
     * @param expectedLife: targetUnit's HP expected after the use of the item
     * @param targetUnit: unit that receives the action
     */
    protected void checkHPAfterUseItemOnUnitTest(int expectedLife, IUnit targetUnit){
        getTestUnit().useEquippedItemOn(targetUnit);
        assertEquals(expectedLife, targetUnit.getCurrentHitPoints());
    }


    /**
     * check that targetUnit received strong damage after the use of an object
     * @param targetUnit: unit who'll receive the item's effect
     */
    protected void strongDamageTest(IUnit targetUnit){
        int damage = (int) Math.round(targetPower* 1.5);
        checkHPAfterUseItemOnUnitTest(Math.max(0,targetHP - damage), targetUnit);
    }

    /**
     * check that targetUnit received normal damage after the use of an object
     * @param targetUnit: unit who'll receive the item's effect
     */
    protected void normalDamageTest(IUnit targetUnit){
        checkHPAfterUseItemOnUnitTest(Math.max(0, targetHP - targetPower), targetUnit);
    }

    /**
     * check that targetUnit received weak damage after the use of an object
     * @param targetUnit: unit who'll receive the item's effect
     */
    protected void weakDamageTest(IUnit targetUnit){
        checkHPAfterUseItemOnUnitTest(Math.max(0,targetHP - Math.max(0, targetPower - 20)), targetUnit);
    }

    /**
     * check that targetUnit didn't receive damage after the use of an object
     * @param targetUnit: unit who'll receive the item's effect
     */
    protected void zeroDamageTest(IUnit targetUnit){
        checkHPAfterUseItemOnUnitTest(targetHP, targetUnit);
    }


    // EQUIP METHODS
    /**
     * add item to unit's inventory and tries to equip the item
     * @param unit: unit who'll receive the item
     * @param item: item to be equipped
     */
    public void equipUnit(IUnit unit, IEquipableItem item){
        unit.addItem(item);
        unit.equipItem(item);
    }

    /**
     * Equip item to TestUnit
     * */
    protected abstract void equipTestUnit();

    /**
     * equip all target units
     */
    public void equipTargetUnits(){
        equipUnit(archer, bow);
        equipUnit(cleric, staff);
        equipUnit(fighter, axe);
        equipUnit(hero, spear);
        equipUnit(swordMaster, sword);
        equipUnit(darknessSorcerer, darknessBook);
        equipUnit(lightSorcerer, lightBook);
        equipUnit(spectralSorcerer, spectralBook);
    }

    /**
     * Tries to equip an correct weapon to a Unit and verifies that it was equipped. Item has to be added to inventory first.
     * @param unit that will receive the item
     * @param item to be equipped
     */
    public void checkCorrectEquippedItem(IUnit unit, IEquipableItem item) {
        assertTrue(unit.getEquippedItem().isNullItem());
        item.equipTo(unit);
        assertTrue(unit.getEquippedItem().isNullItem());
        unit.addItem(item);
        assertEquals(unit,item.getOwner());
        unit.equipItem(item);
        assertEquals(item, unit.getEquippedItem());
    }

    /**
     * Tries to equip an incorrect weapon to a Unit and verifies that it was not equipped
     *
     * @param unit that will receive the item
     * @param item to be equipped
     */
    public void checkIncorrectEquippedItem(IUnit unit, IEquipableItem item) {
        assertTrue(unit.getEquippedItem().isNullItem());
        unit.addItem(item);
        unit.equipItem(item);
        assertTrue(unit.getEquippedItem().isNullItem());
    }

    /**
     * Inflicts damage to all target units
     * @param damage amount of damage
     * */
    protected void hurtAllTargetUnits(int damage){
        alpaca.receiveDamage(damage);
        archer.receiveDamage(damage);
        cleric.receiveDamage(damage);
        fighter.receiveDamage(damage);
        hero.receiveDamage(damage);
        swordMaster.receiveDamage(damage);
        lightSorcerer.receiveDamage(damage);
        darknessSorcerer.receiveDamage(damage);
        spectralSorcerer.receiveDamage(damage);
    }
}
