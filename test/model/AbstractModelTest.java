package model;

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

/**
 * This class implements some basic methods that will be used in testing in <i>items</i> and <i>units</i> packages.
 * It defines a field, units and weapons.
 * @author Tabita Catalán Muñoz
 * @since
 */

public abstract class AbstractModelTest {

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

    // test items
    protected Bow bow;
    protected Field field;
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
     * Set up the target units
     */
    public void setTargetUnits(){
        alpaca = new Alpaca(targetHP, targetMovement, field.getCell(0, 2));
        archer = new Archer(targetHP, targetMovement, field.getCell(3, 3));
        cleric = new Cleric(targetHP, targetMovement, field.getCell(2, 4));
        fighter = new Fighter(targetHP, targetMovement, field.getCell(2, 0));
        hero = new Hero(targetHP, targetMovement, field.getCell(1, 3));
        swordMaster = new SwordMaster(targetHP, targetMovement, field.getCell(3,1));
    }

    /**
     * Creates a set of testing weapons
     */
    public void setWeapons() {
        this.axe = new Axe("Axe", 10, 1, 2);
        this.sword = new Sword("Sword", 10, 1, 2);
        this.spear = new Spear("Spear", 10, 1, 2);
        this.staff = new Staff("Staff", 10, 1, 2);
        this.bow = new Bow("Bow", 10, 2, 3);
        this.spectralBook = new SpectralBook("Book of Souls", 10, 1, 2);
        this.darknessBook = new DarknessBook("Necronomicon", 10, 1, 2);
        this.lightBook = new LightBook("Light Book", 10, 1, 2);
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
    public Alpaca getAlpaca() {
        return alpaca;
    }


    // Getters items
    /**
     * @return the test bow
     */
    public Bow getBow() {
        return bow;
    }

    /**
     * @return the test axe
     */
    public Axe getAxe() {
        return axe;
    }

    /**
     * @return the test sword
     */
    public Sword getSword() {
        return sword;
    }

    /**
     * @return the test spear
     */
    public Spear getSpear() {
        return spear;
    }

    /**
     * @return the test staff
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     * @return the test magic book of type Spectral
     */
    public IMagicBook getSpectralBookBook() {
        return spectralBook;
    }

    /**
     * @return the test magic book of type Darkness
     */
    public IMagicBook getDarknessBook() {
        return darknessBook;
    }

    /**
     * @return the test magic book of type Light
     */
    public IMagicBook getLightBook() {
        return lightBook;
    }


}
