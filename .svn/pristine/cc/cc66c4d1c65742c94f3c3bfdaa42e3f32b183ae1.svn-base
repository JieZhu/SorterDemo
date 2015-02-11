
package containers;

import java.awt.Color;



public class ColoredInteger extends CInteger
 implements IColoredObject
{
 private IColoredObject iColoredObject;

 /**
  * @param color 
  */
 public ColoredInteger(Color color, int x)
 {
        super(x);
  iColoredObject = new ColoredObject(color);
 }

 /**
  * Accessor method for the color property.
  * @param color The color to be set to.
  */
 public void setColor(Color color)
 {
  iColoredObject.setColor(color);
 }

 /**
  * Accessor method for the color property.
  * @return 
  */
 public Color getColor()
 {
  return (iColoredObject.getColor());  
 }
}

