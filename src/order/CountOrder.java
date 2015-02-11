
package order;

import counter.Counter;

/**
 * A decorated ordering strategy that counts all the comparison operations performed.    All operations are summed into a single count.
 */
public class CountOrder extends AOrder
{
 /**
  * The counter object that sums the comparison operations.
  * @SBGen Variable (,counter,,64)
  */
 private Counter counter;
 /**
  * The decorated ordering strategy -- the "decoree".
  * @SBGen Variable (,aOrder,,64)
  */
 private AOrder aOrder;

 /**
  * Teh constructor for this class.
  * @param counter The counter object to use.
  * @param aOrder The decoree.
  */
 public CountOrder(Counter counter, AOrder aOrder)
 {
  this.counter = counter;
  this.aOrder = aOrder;
 }

    /**
  * Accessor method for the total count.
  * @return 
  */
 public int getCount()
    {
        return counter.getCount();
    }

    /**
  * Clears the total count.
  */
 public void clearCount()
    {
        counter.clear();
    }

 /**
  * Increments the count and delegates to the decoree.
  * @param x 
  * @param y 
  * @return 
  */
 public boolean eq(Object x, Object y)
 {
        counter.update();
  return (aOrder.eq(x,y));
 }

 /**
  * Increments the count and delegates to the decoree.
  * @param x 
  * @param y 
  * @return 
  */
 public boolean ne(Object x, Object y)
 {
        counter.update();
  return (aOrder.ne(x,y));
 }

 /**
  * Increments the count and delegates to the decoree.
  * @param x 
  * @param y 
  * @return 
  */
 public boolean lt(Object x, Object y)
 {
        counter.update();
  return (aOrder.lt(x,y));
 }

 /**
  * Increments the count and delegates to the decoree.
  * @param x 
  * @param y 
  * @return 
  */
 public boolean le(Object x, Object y)
 {
        counter.update();
  return (aOrder.le(x,y));
 }

 /**
  * Increments the count and delegates to the decoree.
  * @param x 
  * @param y 
  * @return 
  */
 public boolean gt(Object x, Object y)
 {
        counter.update();
  return (aOrder.gt(x,y));
 }

 /**
  * Increments the count and delegates to the decoree.
  * @return 
  */
 public boolean ge(Object x, Object y)
 {
        counter.update();
  return (aOrder.ge(x,y));
 }

 /**
  * Accessor method for the counter object used.
  * @param counter 
  */
 public void setCounter(Counter counter)
 {
  this.counter = counter;
 }

 /**
  * Accessor method for the decoree.
  * @param aOrder 
  * @SBGen Method set aOrder
  */
 public void setOrder(AOrder aOrder)
 {
  // SBgen: Assign variable
  this.aOrder = aOrder;
 }
}

