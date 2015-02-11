
package order;


/**
 * A decorated ordering strategy that swaps the inputs to enable reverse sorting.    Note that this is not the same as negating the normal operations.
 */
public class ReverseOrder extends AOrder
{
 private AOrder aOrder;

 /**
  * Constructor for the class.
  * @param aOrder The decoree.
  */
 public ReverseOrder(AOrder aOrder)
 {
  this.aOrder = aOrder;
 }

 /**
  * Defined as eq(y,.x).
  * @param x 
  * @param y 
  * @return 
  */
 public boolean eq(Object x, Object y)
 {
  return (aOrder.eq(y,x));
 }

 /**
  * Defined as ne(y,x);
  * @param x 
  * @param y 
  * @return 
  */
 public boolean ne(Object x, Object y)
 {
  return (aOrder.ne(y,x));
 }

 /**
  * Defined as lt(y,x);
  * @param x 
  * @param y 
  * @return 
  */
 public boolean lt(Object x, Object y)
 {
  return (aOrder.lt(y,x));
 }

 /**
  * Defined as le(y,x);
  * @param x 
  * @param y 
  * @return 
  */
 public boolean le(Object x, Object y)
 {
  return (aOrder.le(y,x));
 }

 /**
  * Defined as gt(y,x);
  * @param x 
  * @param y 
  * @return 
  */
 public boolean gt(Object x, Object y)
 {
  return (aOrder.gt(y,x));
 }

 /**
  * Defined as ge(y,x);
  * @param x 
  * @param y 
  * @return 
  */
 public boolean ge(Object x, Object y)
 {
  return (aOrder.ge(y,x));
 }

 /**
  * Accessor method for the decoree.
  * @param aOrder The decorated AOrder object.
  */
 public void setOrder(AOrder aOrder)
 {
  this.aOrder = aOrder;
 }
}

