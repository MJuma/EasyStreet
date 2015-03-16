/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 2 - Easy Street
 * October 05, 2012
 */

import java.util.Map;

/**
 * Creates a Car object for the Easy Street program.
 * 
 * @author Mohammad Juma
 * @version 10-09-12
 */
public class Car extends AbstractVehicle
{
  /**
   * The  number of updates between death and revival.
   */
  private static final int VEHICLE_DEATH_TIME = 10;

  /**
   * Constructs a new Car and passes its specific fields to the parent class.
   * 
   * @param the_coord_x The x coordinate.
   * @param the_coord_y The y coordinate.
   * @param the_direction The direction this vehicle travels.
   * @param the_terrain The type of terrain this vehicle moves on.
   */
  public Car(final int the_coord_x, final int the_coord_y, 
                 final Direction the_direction, final Terrain the_terrain)
  {
    super(the_coord_x, the_coord_y, the_direction, the_terrain, VEHICLE_DEATH_TIME);
  }

  /**
   * A car can only pass onto terrain that is either a street or a light. A
   * car cannot pass if the light is red however.
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

    if ((the_terrain == Terrain.LIGHT) && (the_light == Light.RED))
    {
      able_to_pass = false;
    }
    return able_to_pass;
  }

  /**
   * The preferred direction of travel for a car is straight. If the car
   * cannot move straight it prefers to turn left or right in that order and
   * as a last resort to turn around.
   * 
   * @param the_neighbors Map of terrain nearby.
   * @param the_light 
   * @return direction_to_travel
   */
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                   final Light the_light)
  {
    Direction direction_to_travel;
    
    if ((the_neighbors.get(getDirection()) == Terrain.STREET) ||
        (the_neighbors.get(getDirection()) == Terrain.LIGHT))
    {
      direction_to_travel = getDirection();
    }
    else if ((the_neighbors.get(getDirection().left()) == Terrain.STREET) ||
        (the_neighbors.get(getDirection().left()) == Terrain.LIGHT))
    {
      direction_to_travel = getDirection().left();
    }
    else if ((the_neighbors.get(getDirection().right()) == Terrain.STREET) ||
        (the_neighbors.get(getDirection().right()) == Terrain.LIGHT))
    {
      direction_to_travel = getDirection().right();
    }
    else
    {
      direction_to_travel = getDirection().reverse();
    }

    return direction_to_travel;
  }
}