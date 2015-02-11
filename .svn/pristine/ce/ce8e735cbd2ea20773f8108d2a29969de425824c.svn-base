
package containers;

import order.AOrder;


/**
 * A concrete GraphicComparable that holds an integer value.   During the compare method, the color
 * of this object and the other GCInteger's color are temporarily set to the compare color, the running thread is
 * paused for 200 milliseconds, and then the color are reverted to their original values.
 * 
 * a.compare(b) is defined as (value of a) < (value of b).
 * 
 */
public class CInteger extends AInteger
{
 /**
  * The stored integer value.
  */
 private int value;

 /**
  * Constructor for the class.
  * @param value The integer value held.
  * @param color The normal display color
  */
 public CInteger(int value)
 {
  this.value = value;
 }

 /**
  * Accessor method for the stored integer value.
  * @return
  */
 public int getValue()
 {
  return(value);
 }

 /**
  * Factory method to make the matching ordering strategy for this object.
  * @return An AOrder strategy that works with this class of objects.
  */
 public static AOrder makeOrder()
 {
   return new AOrder()
   {
              public boolean lt(Object x, Object y)
       {
                return (((AInteger)x).getValue()) < (((AInteger)y).getValue());
       }

              public boolean eq(Object x, Object y)
       {
                return (((AInteger)x).getValue()) == (((AInteger)y).getValue());
       }
          };

 }
}

