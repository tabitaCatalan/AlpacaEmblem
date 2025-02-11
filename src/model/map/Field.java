package model.map;

import java.util.*;

/**
 * This class represents the map where the units are located and the game is played.
 * <p>
 * The field is an undirected graph composed of <i>Location</i> nodes where the weight of every edge
 * of the graph is 1.
 * Since all cells of the map should be reachable, the graph must be connected.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Field {

    private Map<String, Location> map;
    private Random random;
    private StringBuilder builder;

    /**
     * Creates an empty Field
     *
     * @param random: will be used in methods with random decisions.
     */
    public Field(Random random){
        this.random = random;
        map = new HashMap<>();
        builder = new StringBuilder();
    }

    /**
     * Creates an empty Field
     */
     public Field(){
        this(new Random());
    }

  /**
   * Add cells to the map.
   *
   * @param connectAll
   *     a flag that indicates if all the cells should be connected to it's neighbours
   * @param cells
   *     the locations that are going to be added to the map
   */
  public void addCells(final boolean connectAll, final Location... cells) {
    for (Location cell : cells) {
      addCell(cell);
      Location[] adjacentCells = getAdjacentCells(cell);
      for (Location adjacentCell : adjacentCells) {
        if (connectAll || random.nextDouble() > 1.0 / 3 || cell.getNeighbours().size() < 1) {
          addConnection(cell, adjacentCell);
        }
      }
    }
  }

  /**
   * Adds a cell to the map
   *
   * @param cell
   *     the location to be added
   */
  private void addCell(final Location cell) {
    map.put(cell.toString(), cell);
  }

  /**
   * Gets the possible adjacent cells to a given cell
   *
   * @param cell
   *     the location of the current cell
   * @return an array of the adjacent cells
   */
  private Location[] getAdjacentCells(final Location cell) {
    int row = cell.getRow(),
        col = cell.getColumn();
    return new Location[]{getCell(row - 1, col), getCell(row + 1, col), getCell(row, col - 1),
        getCell(row, col + 1)};
  }

  /**
   * Creates a connection between 2 cells
   */
  private void addConnection(Location cell1, Location cell2) {
    cell1.addNeighbour(cell2);
  }

  /**
   * @param row
   *     the row of the cell
   * @param col
   *     the column of the cell
   * @return the Location that represents the cell at (row, col)
   */
  public Location getCell(final int row, final int col) {
    String id = generateID(row, col);
    return map.getOrDefault(id, new InvalidLocation());
  }

  /**
   * Creates a map key from a row and a column
   *
   * @param row
   *     the row of the cell
   * @param col
   *     the column of the cell
   * @return a string of the form (row, col)
   */
  private String generateID(final int row, final int col) {
    builder.setLength(0);
    builder.append("(").append(row).append(", ").append(col).append(")");
    return builder.toString();
  }

  public Map<String, Location> getMap() {
    return Map.copyOf(map);
  }

  /**
   * Checks if the map is connected using BFS.
   *
   * @return true if the map is connected, false otherwise.
   */
  public boolean isConnected() {
    Set<Location> visitedNodes = new HashSet<>();
    Queue<Location> toVisit = new LinkedList<>();
    toVisit.add(map.entrySet().iterator().next().getValue());
    while (!toVisit.isEmpty()) {
      if (visitedNodes.size() == map.size()) {
        return true;
      }
      Location currentNode = toVisit.poll();
      for (Location neighbour :
          currentNode.getNeighbours()) {
        if (!visitedNodes.contains(neighbour)) {
          visitedNodes.add(neighbour);
          toVisit.add(neighbour);
        }
      }
    }
    return false;
  }

  /**
   * Removes a connection from two locations of the field
   */
  public void removeConnection(final Location cell1, final Location cell2) {
    if (cell1.getNeighbours().size() > 1 && cell2.getNeighbours().size() > 1) {
      cell1.removeNeighbour(cell2);
    }
  }

  /**
   * Checks if two cells of the map are connected
   */
  public boolean checkConnection(final Location cell1, final Location cell2) {
    return cell1.isNeighbour(cell2);
  }

  /**
   * @return the minimum side length of a square that contains all the cells
   * */
    public int getSize() {
        Map<String, Integer> limits = getMapLimits();
        int minCol = limits.get("minCol");
        int maxCol = limits.get("maxCol");
        int minRow = limits.get("minRow");
        int maxRow = limits.get("maxRow");
        return Math.max(maxCol - minCol + 1, maxRow - minRow + 1);
    }

    /**
     * @return a dictionary with the limits of the map.
     *      To access use keys: minCol, maxCol, minRow, maxRow
     * */
    private Map<String, Integer> getMapLimits(){
        ArrayList<Integer> columns = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();

        for (Location location : map.values()) {
            columns.add(location.getColumn());
            rows.add(location.getRow());
        }
        int minCol = getMinOfArray(columns);
        int maxCol = getMaxOfArray(columns);
        int minRow = getMinOfArray(rows);
        int maxRow = getMaxOfArray(rows);

        Map<String, Integer> limits = new HashMap<>();
        limits.put("maxCol", maxCol);
        limits.put("minCol", minCol);
        limits.put("maxRow", maxRow);
        limits.put("minRow", minRow);
        return limits;
    }

    private int getMinOfArray(List<Integer> array){
        int min = Integer.MAX_VALUE;
        for(Integer x: array) {
            min = Math.min(x, min);
        }
        return min;
    }

    private int getMaxOfArray(List<Integer> array){
        int max = Integer.MIN_VALUE;
        for(Integer x: array) {
            max = Math.max(x, max);
        }
        return max;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        Map<String, Integer> limits = getMapLimits();
        for (int i = limits.get("maxRow"); i >= limits.get("minRow"); i--){
            for (int j = limits.get("minCol"); j <= limits.get("maxCol"); j++){
                str.append(getCell(i,j).printIfValid());
            }
            str.append("\n");
        }
        return str.toString();
    }
}
