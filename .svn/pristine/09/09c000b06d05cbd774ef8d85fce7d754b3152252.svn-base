
package order;
import java.awt.*;


import containers.IColoredObject;

/**
 * A decorated ordering strategy that temporarily changes the color of the compared objects.   
 * The objects are assumed to be of type IColoredObject
 */
public class GraphicOrder extends AOrder
{
 /**
  * The color to temporarily switch the compared objects to.
  */
 private Color compareColor = Color.red;
    /**
  * The number of milliseconds to pause while the objects are set to the compare color.
  */
 private int waitTime = 200;
 /**
  * The decorated ordering strategy--the "decoree".
  */
 private AOrder aOrder;
 /**
  * The constructor for this class.
  * @param compareColor The color to change the objects to.
  * @param waitTime The amount of time to pause (sleep) after changing the color.
  * @param aOrder The decoree.
  */
 public GraphicOrder(Color compareColor, int waitTime, AOrder aOrder)
 {
  this.compareColor = compareColor;
  this.waitTime = waitTime;
  this.aOrder = aOrder;
 }

 /**
  * Calls blink(x,y) and then delegates to the decoree.
  * @param x 
  * @param y 
  * @return 
  */
 public boolean eq(Object x, Object y)
 {
  blink((IColoredObject) x, (IColoredObject) y);
  return (aOrder.eq(x,y));
 }

 /**
  * Calls blink(x,y) and then delegates to the decoree.
  * @return 
  */
 public boolean ne(Object x, Object y)
 {
  blink((IColoredObject) x, (IColoredObject) y);
  return (aOrder.ne(x,y));
 }

 /**
  * Calls blink(x,y) and then delegates to the decoree.
  * @return 
  */
 public boolean lt(Object x, Object y)
 {
  blink((IColoredObject) x, (IColoredObject) y);
  return (aOrder.lt(x,y));
 }

 /**
  * Calls blink(x,y) and then delegates to the decoree.
  * @return 
  */
 public boolean le(Object x, Object y)
 {
  blink((IColoredObject) x, (IColoredObject) y);
  return (aOrder.le(x,y));
 }

 /**
  * Calls blink(x,y) and then delegates to the decoree.
  * @return 
  */
 public boolean gt(Object x, Object y)
 {
  blink((IColoredObject) x, (IColoredObject) y);
  return (aOrder.gt(x,y));
 }

 /**
  * Calls blink(x,y) and then delegates to the decoree.
  * @return 
  */
 public boolean ge(Object x, Object y)
 {
  blink((IColoredObject) x, (IColoredObject) y);
  return (aOrder.ge(x,y));

 }

 /**
  * Changes the color of xIGC and yIGC to the compareColor, sleeps for waitTime milliseconds and then changes the colors back to their original state.
  * 
  * @param xIGC 
  * @param yIGC 
  */
 protected void blink(IColoredObject xIGC, IColoredObject yIGC)
 {
          Color thisColor = xIGC.getColor();
          Color thatColor = yIGC.getColor();

          yIGC.setColor(compareColor);
          xIGC.setColor(compareColor);

          try
          {
           Thread.sleep(waitTime);
          }
          catch(Exception e) {}

          yIGC.setColor(thatColor);
          xIGC.setColor(thisColor);
 }

 /**
  * An accessor method for compareColor.
  * @param compareColor 
  */
 public void setCompareColor(Color compareColor)
 {
  this.compareColor = compareColor;
 }

 /**
  * An accessor method for the waitTime
  * @param waitTime 
  */
 public void setWaitTime(int waitTime)
 {
  this.waitTime = waitTime;
 }

 /**
  * An accessor method for the decoree.
  * @param aOrder 
  * @SBGen Method set aOrder
  */
 public void setOrder(AOrder aOrder)
 {
  // SBgen: Assign variable
  this.aOrder = aOrder;
 }
}

