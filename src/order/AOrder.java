
package order;

/**
 * An abstract ordering strategy.    The subclass must provide the fundamental less than and equals methods.   
 * The other methods are provided as conveniences and are derived from the two fundamental methods.
 */
public abstract class AOrder
{
  
  /**
   * Abstractly defines a strict "less than" ordering between the two input objects.
   * @param x 
   * @param y 
   * @return true if x < y
   */
  public abstract boolean eq(Object x, Object y);
  
  /**
   * Abstractly defines an equality between the two input objects.
   * @param x 
   * @param y 
   * @return true if equal.
   */
  public abstract boolean lt(Object x, Object y);
  
  /**
   * Not equal to, defined as the negation of eq(x,y).
   * @param x 
   * @param y 
   * @return true if x does not equal y.
   */
  public boolean ne(Object x, Object y)
  {
    return !eq(x,y);
  }
  
  /**
   * Less than or equal, defined as lt(x, y) || eq(x, y)
   * @param x 
   * @param y 
   * @return 
   */
  public boolean le(Object x, Object y)
  {
    return lt(x, y) || eq(x, y);
  }
  
  /**
   * Greater than, defined as the negation of le(x,y).
   * @param x 
   * @param y 
   * @return 
   */
  public boolean gt(Object x, Object y)
  {
    return !le(x,y);
  }
  
  /**
   * Greater than or equal to, defined as the negation of lt(x,y);
   * @param x 
   * @param y 
   * @return 
   */
  public boolean ge(Object x, Object y)
  {
    return !lt(x,y);
  }
}

