/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 2 - Easy Street
 * October 05, 2012
 */

/**
 * Vehicle object is the parent object for all the vehicles. .
 * 
 * @author Mohammad Juma
 * @version 10-09-12
 */
public abstract class AbstractVehicle implements Movable
{
  /**
   * Initial x coordinate of vehicle.
   */
  private final int my_initial_x;
  
  /**
   * Initial y coordinate of vehicle.
   */
  private final int my_initial_y;
  
  /**
   * The initial direction.
   */
  private final Direction my_initial_direction;
  
  /**
   * The type of terrain this vehicle travels on.
   */
  private final Terrain my_terrain;
  
  /**
   * The  number of updates between death and revival.
   */
  private final int my_vehicle_death_time;
  
  /**
   * The file name for the vehicle when alive.
   */
  private final String my_alive_file_name;
  
  /**
   * The file name for the vehicle when dead.
   */
  private final String my_dead_file_name;
  
  /**
   * The x coordinate of the vehicle.
   */
  private int my_coord_x;
  
  /**
   * The y coordinate of the vehicle.
   */
  private int my_coord_y;
  
  /**
   * The direction this vehicle travels in.
   */
  private Direction my_direction;
  
  /**
   * Determines whether or not the vehicle is alive. 
   */
  private boolean my_is_alive;
  
  /**
   * Number of pokes.
   */
  private int my_pokes;
  
  /**
   * Vehicle class constructor for initiating and adding a new vehicle to the map.
   * 
   * @param the_coord_x The x coordinate.
   * @param the_coord_y The y coordinate.
   * @param the_direction The direction this vehicle travels.
   * @param the_terrain The type of terrain this vehicle moves on.
   * @param the_vehicle_death_time Amount of updates vehicle must wait until revival.
   */
  public AbstractVehicle(final int the_coord_x, final int the_coord_y,
                         final Direction the_direction, final Terrain the_terrain,
                         final int the_vehicle_death_time)
  {
    my_initial_x = the_coord_x;
    my_initial_y = the_coord_y;
    my_initial_direction = the_direction;
    setValues(the_coord_x, the_coord_y, the_direction);
    my_terrain = the_terrain;
    my_alive_file_name = getClass().getName().toLowerCase() + ".gif";
    my_dead_file_name = getClass().getName().toLowerCase() + "_dead.gif";
    my_vehicle_death_time = the_vehicle_death_time;
    my_is_alive = true;
  }

  /**
   * Updates the status of the vehicle when a collision occurs.
   * 
   * @param the_other The movable object that just collided with this object.
   */
  public void collide(final Movable the_other)
  {
    if (isAlive() && the_other.isAlive() && (the_other.getDeathTime() < getDeathTime()))
    {
      my_is_alive = false;
    }
  }

  /**
   * Gives you the number of updates needed till revival.
   * 
   * @return Returns the number of updates between this vehicle's death and
   *  when it should be revived.
   */
  public int getDeathTime()
  {
    return my_vehicle_death_time;
  }

  /**
   * Gives you the file name for the vehicles image.
   * 
   * @return image_file_name
   */
  public String getImageFileName()
  {
    String image_file_name = my_alive_file_name;
    
    if (!isAlive())
    {
      image_file_name = my_dead_file_name;
    }
    
    return image_file_name;
  }

  /**
   * Gives you the direction the vehicle is facing.
   * 
   * @return my_direction
   */
  public Direction getDirection()
  {
    return my_direction;
  }

  /**
   * Gives you the x coordinate of the vehicle.
   * 
   * @return my_coord_x
   */
  public int x()
  {
    return my_coord_x;
  }

  /**
   * Gives you the y coordinate of the vehicle.
   * 
   * @return my_coord_y
   */
  public int y()
  {
    return my_coord_y;
  }

  /**
   * Gives you the state of the vehicle, either dead or alive.
   * 
   * @return my_is_alive
   */
  public boolean isAlive()
  {
    return my_is_alive;
  }

  /**
   * Pokes the vehicle.
   */
  public void poke()
  {
    if (my_pokes < getDeathTime())
    {
      my_pokes++;
    }
    else if (my_pokes >= getDeathTime())
    {
      my_is_alive = true;
      setDirection(Direction.random());
      my_pokes = 0;
    }
  }

  /**
   * Resets the vehicles state.
   */
  public void reset()
  {
    setX(my_initial_x);
    setY(my_initial_y);
    setDirection(my_initial_direction);
    my_pokes = 0;
    my_is_alive = true;
  }

  /**
   * Sets the vehicles direction.
   * 
   * @param the_dir direction to face.
   */
  public void setDirection(final Direction the_dir)
  {
    my_direction = the_dir;
  }

  /**
   * Sets the vehicles x position.
   * 
   * @param the_x x position to change to.
   */
  public void setX(final int the_x)
  {
    my_coord_x = the_x;
  }

  /**
   * Sets the vehicles y position.
   * 
   * @param the_y y position to change to.
   */
  public void setY(final int the_y)
  {
    my_coord_y = the_y;
  }
  
  /**
   * toString method overridden for debugging purposes.
   * 
   * @return getClass().getName()
   */
  public String toString()
  {   
    return getClass().getName();
  }
  
  /**
   * Returns the starting terrain.
   * 
   * @return my_terrain
   */
  protected Terrain myTerrain()
  {
    return my_terrain;
  }

  /**
   * Sets the x and y values, as well as the direction.
   * 
   * @param the_coord_x The x coordinate.
   * @param the_coord_y The y coordinate.
   * @param the_direction The direction this vehicle travels.
   */
  private void setValues(final int the_coord_x, final int the_coord_y,
                         final Direction the_direction)
  {
    my_coord_x = the_coord_x;
    my_coord_y = the_coord_y;
    my_direction = the_direction;
  }
}
