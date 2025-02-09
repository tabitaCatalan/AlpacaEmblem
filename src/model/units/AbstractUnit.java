package model.units;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.items.*;
import model.items.magic.*;
import model.items.nonMagic.Axe;
import model.items.nonMagic.Bow;
import model.items.nonMagic.Spear;
import model.items.nonMagic.Sword;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  protected final List<IEquipableItem> inventory = new ArrayList<>();
  private int currentHitPoints;
  private int maxHitPoints;
  private final int movement;
  protected IEquipableItem equippedItem;
  private Location location;
  private int maxNumberOfItems;
  private IEquipableItem nullItem;

  /**
   * Creates a new Unit.
   *
   * @param maxHitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   */
  protected AbstractUnit(final int maxHitPoints, final int movement,
     final Location location, final int maxItems, final IEquipableItem... items) {
    this.maxHitPoints = maxHitPoints;
    this.currentHitPoints = maxHitPoints;
    this.movement = movement;
    this.location = location;
    this.location.setUnit(this);
    this.inventory.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
    this.maxNumberOfItems = maxItems;
    nullItem = new NullItem();
    nullItem.setOwner(this);
    disarm();
  }

  @Override
  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public List<IEquipableItem> getInventory() {
    return List.copyOf(inventory);
  }

  @Override
  public void addItem(IEquipableItem item){
      if(!item.isNullItem() && hasSpaceInInventory()) {
          inventory.add(item);
          item.setOwner(this);
      }
  }

  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  @Override
  public void setEquippedItem(final IEquipableItem itemInInventory) {
    if (isInInventory(itemInInventory)){
        this.equippedItem = itemInInventory;
    }
  }

  @Override
  public void useEquippedItemOn(IUnit targetUnit){
    equippedItem.actOn(targetUnit);
  }

  @Override
  public void equipItem(IEquipableItem item) {
  if (item!= null)
    item.equipTo(this);
  }

  @Override
  public void equipBow(Bow bow) {}

  @Override
  public void equipStaff(Staff staff) {}

  @Override
  public void equipAxe(Axe axe) {}

  @Override
  public void equipSpear(Spear spear) {}

  @Override
  public void equipSword(Sword sword) {}

  @Override
  public void equipMagicBook(IMagicBook magicBook) {}

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  @Override
  public int getMovement() {
    return movement;
  }

  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      location.removeUnit();
      setLocation(targetLocation);
      targetLocation.setUnit(this);
    }
  }

  @Override
  public boolean hasSpaceInInventory(){
      return getNumberOfItems() < maxNumberOfItems;
  }

  @Override
  public int getNumberOfItems(){
      return inventory.size();
  }

  @Override
  public void giveItemAwayTo(IUnit targetUnit, IEquipableItem item){
    if (isInInventory(item) && targetUnit.hasSpaceInInventory() && distanceTo(targetUnit) == 1){
      removeFromInventory(item);
      targetUnit.addItem(item);
    }
  }

  @Override
  public void removeFromInventory(IEquipableItem item) {
    item.setOwner(null);
    if (equippedItem.equals(item)){
      disarm();
    }
    inventory.remove(item);
  }

  @Override
  public void disarm(){
    equippedItem = nullItem;
  }

  @Override
  public boolean isInInventory(IEquipableItem item){
    return inventory.contains(item);
  }

  @Override
  public void receiveDamage(int damageAmount){
    currentHitPoints = max(currentHitPoints - damageAmount, 0);
  }

  @Override
  public void receiveBowAttack(Bow bow){
    equippedItem.receiveBowAttack(bow);
  }

  @Override
  public void receiveAxeAttack(Axe axe){
    equippedItem.receiveAxeAttack(axe);
  }

  @Override
  public void receiveSpearAttack(Spear spear){
    equippedItem.receiveSpearAttack(spear);
  }

  @Override
  public void receiveSwordAttack(Sword sword){
    equippedItem.receiveSwordAttack(sword);
  }

  @Override
  public void receiveSpectralAttack(SpectralBook spectralBook){equippedItem.receiveSpectralAttack(spectralBook);}

  @Override
  public void receiveLightAttack(LightBook lightBook){equippedItem.receiveLightAttack(lightBook);}

  @Override
  public void receiveDarknessAttack(DarknessBook darknessBook){equippedItem.receiveDarknessAttack(darknessBook);}

  @Override
  public void reactToAttack(IUnit unit){
    if (isAlive()){
    equippedItem.reactTo(unit);
    }
  }

  @Override
  public boolean hasEquippedItem(){
    return (equippedItem != null) && !equippedItem.isNullItem();
  }

  @Override
  public boolean isInRange(IUnit targetUnit){
    return equippedItem.isInRange(targetUnit);
  }

  @Override
  public double distanceTo(IUnit targetUnit){
    return location.distanceTo(targetUnit.getLocation());
  }

  @Override
  public void beingHealed(int amountHP){
    currentHitPoints = Math.min(currentHitPoints + amountHP, maxHitPoints);
  }

  @Override
  public boolean isAlive() {
    return getCurrentHitPoints() > 0;
  }
}
