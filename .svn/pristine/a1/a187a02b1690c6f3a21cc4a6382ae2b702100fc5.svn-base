/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 2 - Easy Street
 * October 05, 2012
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Creates a Truck object for the Easy Street program.
 * 
 * @author Mohammad Juma
 * @version 10-09-12
 */
public class Truck extends AbstractVehicle
{
  /**
   * The  number of updates between death and revival.
   */
  private static final int VEHICLE_DEATH_TIME = 0;

  /**
   * Constructs a new Truck and passes its specific fields to the parent class.
   * 
   * @param the_coord_x The x coordinate.
   * @param the_coord_y The y coordinate.
   * @param the_direction The direction this vehicle travels.
   * @param the_terrain The type of terrain this vehicle moves on.
   */
  public Truck(final int the_coord_x, final int the_coord_y, 
                 final Direction the_direction, final Terrain the_terrain)
  {
    super(the_coord_x, the_coord_y, the_direction, the_terrain, VEHICLE_DEATH_TIME);
  }

  /**
   * A truck can only pass onto terrain that is either a street or a light. They
   * ignore lights.
   * 
   * @param the_terrain The terrain.
   * @param the_light The light color.
   * @return able_to_pass
   */
  public boolean canPass(final Terrain the_terrain, final Light the_light)
  {    
    boolean able_to_pass = false;

    if ((the_terrain == Terrain.STREET) || (the_terrain == Terrain.LIGHT))
    {
      able_to_pass = true;
    }

    return able_to_pass;
  }

  /**
   * The preferred direction of travel for a truck is straight when not at an intersection.
   * Upon reaching an intersection trucks randomly choose a direction other than reverse.
   * 
   * @param the_neighbors Map of terrain nearby.
   * @param the_light 
   * @return direction_to_travel
   */
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                   final Light the_light)
  {
    Direction direction_to_travel;
    final List<Direction> possible_directions = new ArrayList<>();
    int num_directions;
    
    if (the_neighbors.get(getDirection().left()) == Terrain.STREET ||
        the_neighbors.get(getDirection().left()) == Terrain.LIGHT)
    {
      possible_directions.add(getDirection().left());
    }
    
    if (the_neighbors.get(getDirection().right()) == Terrain.STREET ||
        the_neighbors.get(getDirection().right()) == Terrain.LIGHT)
    {
      possible_directions.add(getDirection().right());
    }
    
    if (the_neighbors.get(getDirection()) == Terrain.STREET ||
        the_neighbors.get(getDirection()) == Terrain.LIGHT)
    {
      possible_directions.add(getDirection());
    }
    
    if (possible_directions.size() == 0)
    {
      direction_to_travel = getDirection().reverse();
    }
    else
    {
      num_directions = (int) (Math.random() * possible_directions.size());
      direction_to_travel = possible_directions.get(num_directions);
    }
    return direction_to_travel;
  }
}