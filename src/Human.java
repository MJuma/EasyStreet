/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 2 - Easy Street
 * October 05, 2012
 */

import java.util.Map;

/**
 * Creates a Human object for the Easy Street program.
 * 
 * @author Mohammad Juma
 * @version 10-09-12
 */
public class Human extends AbstractVehicle
{
  /**
   * The  number of updates between death and revival.
   */
  private static final int VEHICLE_DEATH_TIME = 50;

  /**
   * Constructs a new Human and passes its specific fields to the parent class.
   * 
   * @param the_coord_x The x coordinate.
   * @param the_coord_y The y coordinate.
   * @param the_direction The direction this vehicle travels.
   * @param the_terrain The type of terrain this vehicle moves on.
   */
  public Human(final int the_coord_x, final int the_coord_y, 
                 final Direction the_direction, final Terrain the_terrain)
  {
    super(the_coord_x, the_coord_y, the_direction, the_terrain, VEHICLE_DEATH_TIME);
  }

  /**
   * A human can only pass onto terrain that is equal to the terrain they originated
   * from. Streets and lights are treated as the same and humans ignore light colors.
   * 
   * @param the_terrain The terrain.
   * @param the_light The light color.
   * @return able_to_pass
   */
  public boolean canPass(final Terrain the_terrain, final Light the_light)
  {    
    boolean able_to_pass = false;
    
    if ((myTerrain() == Terrain.STREET || myTerrain() == Terrain.LIGHT) && 
        (the_terrain == Terrain.STREET || the_terrain == Terrain.LIGHT))
    {
      able_to_pass = true;
    }
    else if (the_terrain == myTerrain())
    {
      able_to_pass = true;
    }

    return able_to_pass;
  }

  /**
   * The preferred direction of travel for a human is any random direction
   * that is not Direction.CENTER.
   * 
   * @param the_neighbors Map of terrain nearby.
   * @param the_light 
   * @return direction_to_travel
   */
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                   final Light the_light)
  {
    Direction direction_to_travel = Direction.random();
    
    if (!canPass(the_neighbors.get(direction_to_travel), the_light))
    {
      direction_to_travel = chooseDirection(the_neighbors, the_light);
    }
    
    return direction_to_travel;
  }
}