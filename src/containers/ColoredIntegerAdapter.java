
package containers;

import java.awt.*;


/**
 * An IGraphicComparable that adds the knowledge of  a "compare color" that can be used when two CraphicComparables are being compared.
 *
 */
public class ColoredIntegerAdapter extends AInteger
 implements IColoredObject
{
 private IColoredObject iColoredObject;
 private AInteger aNumber;
 /**
  * The constructor for this class.
  * @param iColoredObject The colored object to be associated with the AInteger object.
  * @param aNumber The AInteger object associated with the IColored object.
  */
 public ColoredIntegerAdapter(IColoredObject iColoredObject, AInteger aNumber)
 {
  this.iColoredObject = iColoredObject;
  this.aNumber = aNumber;
 }

 /**
  * Accessor method for the stored value.
  * @return
  */
 public int getValue()
    {
        return aNumber.getValue();
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

