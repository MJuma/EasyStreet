/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 2 - Easy Street
 * October 05, 2012
 */

import java.util.Map;

/**
 * Creates a Bicycle object for the Easy Street program.
 * 
 * @author Mohammad Juma
 * @version 10-09-12
 */
public class Bicycle extends AbstractVehicle
{
  /**
   * The  number of updates between death and revival.
   */
  private static final int VEHICLE_DEATH_TIME = 20;

  /**
   * Constructs a new Bicycle and passes its specific fields to the parent class.
   * 
   * @param the_coord_x The x coordinate.
   * @param the_coord_y The y coordinate.
   * @param the_direction The direction this vehicle travels.
   * @param the_terrain The type of terrain this vehicle moves on.
   */
  public Bicycle(final int the_coord_x, final int the_coord_y, 
                 final Direction the_direction, final Terrain the_terrain)
  {
    super(the_coord_x, the_coord_y, the_direction, the_terrain, VEHICLE_DEATH_TIME);
  }

  /**
   * A Bicycle can only pass onto terrain that is either a trail, a street or 
   * a light. It also cannot pass if the light is yellow or red.
   * 
   * @param the_terrain The terrain.
   * @param the_light The light color.
   * @return able_to_pass
   */
  public boolean canPass(final Terrain the_terrain, final Light the_light)
  {    
    boolean able_to_pass = false;

    if ((the_terrain == Terrain.STREET) || (the_terrain == Terrain.TRAIL) || 
        (the_terrain == Terrain.LIGHT))
    {
      able_to_pass = true;
    }

    if ((the_terrain == Terrain.LIGHT) && (the_light != Light.GREEN))
    {
      able_to_pass = false;
    }
    return able_to_pass;
  }

  /**
   * The preferred direction of travel for a Bicycle is straight when on a trail and
   * always tries to turn onto a trail when possible. If not on a trail the Bicycle 
   * then prefers straight when on a street, if it cannot move straight it prefers to 
   * turn left or right in that order and as a last resort to turn around.
   * 
   * @param the_neighbors Map of terrain nearby.
   * @param the_light 
   * @return direction_to_travel
   */
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                   final Light the_light)
  {
    Direction direction_to_travel;
    final Direction to_trail = findTrail(the_neighbors);
    final Direction to_street = findStreet(the_neighbors);
    
    if (to_trail == Direction.CENTER && to_street == Direction.CENTER)
    {
      direction_to_travel = Direction.CENTER; 
    }
    else if (to_trail == Direction.CENTER)
    {
      direction_to_travel = to_street;
    }
    else
    {
      direction_to_travel = to_trail;
    }

    return direction_to_travel;
  }
    
  /**
   * Returns the direction of a trail if one is nearby.
   * 
   * @param the_neighbors Map of terrain nearby.
   * @return trail_direction;
   */
  private Direction findTrail(final Map<Direction, Terrain> the_neighbors)
  {
    Direction trail_direction;
    
    if (the_neighbors.get(getDirection()) == Terrain.TRAIL)
    {
      trail_direction = getDirection();
    }
    else if (the_neighbors.get(getDirection().left()) == Terrain.TRAIL)
    {
      trail_direction = getDirection().left();
    }
    else if (the_neighbors.get(getDirection().right()) == Terrain.TRAIL)
    {
      trail_direction = getDirection().right();
    }
    else
    {
      trail_direction = Direction.CENTER;
    }
    
    return trail_direction;
  }
  
  /**
   * Returns the direction of a street or light that the bike can turn onto.
   * 
   * @param the_neighbors Map of terrain nearby.
   * @return street_direction
   */
  private Direction findStreet(final Map<Direction, Terrain> the_neighbors)
  {
    Direction street_direction;
        
    if ((the_neighbors.get(getDirection()) == Terrain.STREET) || 
        (the_neighbors.get(getDirection()) == Terrain.LIGHT))
    {
      street_direction = getDirection();
    }
    else if ((the_neighbors.get(getDirection().left()) == Terrain.STREET) || 
        (the_neighbors.get(getDirection().left()) == Terrain.LIGHT))
    {
      street_direction = getDirection().left();
    }
    else if ((the_neighbors.get(getDirection().right()) == Terrain.STREET) || 
        (the_neighbors.get(getDirection().right()) == Terrain.LIGHT))
    {
      street_direction = getDirection().right();
    }
    else if ((the_neighbors.get(getDirection().reverse()) == Terrain.STREET) || 
        (the_neighbors.get(getDirection().reverse()) == Terrain.LIGHT))
    {
      street_direction = getDirection().reverse();
    }
    else
    {
      street_direction = Direction.CENTER;
    }
    
    return street_direction;
  }
}
