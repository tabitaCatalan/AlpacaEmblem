package model;

/**
 * This class represent a Player
 *
 * @author Tabita Catalán Muñoz
 * @since 2.0
 */

public class Tactician {
    private String name;

    /** Creates a new Tactician
     * @param nameTactician: came of the new Tactician
     * */
    public Tactician(String nameTactician){
        name = nameTactician;
    }

    /**
     * @return name of the Tactician
     * */
    public String getName() {
        return name;
    }
}
