package containers;

import java.awt.*;

/**
 * A subclass of java.awt.Color that can be recursively split.    SorterColor has a notion of a single integer,  RBG value 
 * with the addition that the color value is contained in a "spectrum".   That is, the color value is specified within a lower 
 * and upper value bounds.
 */
public class SorterColor extends Color
{

  /**
	 * 
	 */
	private static final long serialVersionUID = -4382062144189711806L;
/**
  * The 24 bit RGB  color value of thsi color.
  */
 int value;
 /**
  * The high end of the spectrum
  */
 int hi;
 /**
  * The low end of the spectrum
  * 
  */
 int lo;
  /**
  * This mask represents the java.awt.Color value where the 24 color bits are all zero 
  * but the top 8 bits are all 1's.   java.awt.Color expects to see RGB color values where 
  * the upper  8 bits are all 1's.   This mask is equal to the value  returned java.awt.Color.black.getRGB()
  */
 static int mask = Color.black.getRGB();

  /**
  * The constructor for the class
  * @param value The 24-bit RGB color value to be set to.
  * @param lo the low end of the spectrum for this object.   A 24-bit RGB value.
  * @param hi the high end of the spectrum for this object.   A 24-bit RGB value.
  */
 public SorterColor(int value, int lo, int hi)
  {
      // lo <= value <= hi

      super( mask+value);
      this.value = value;
      this.lo = lo;
      this.hi = hi;
  }

  /**
  * Accessor method for the color value.
  * @return 
  */
 public int getValue()
  {
    return value;
  }

  /**
  * Accessor method for the low end of the spectrum.
  */
 public int getLo()
  {
    return lo;
  }

  /**
  * Accessor method for the high end of the spectrum.
  */
 public int getHi()
  {
    return hi;
  }

  /**
  * Returns a new SorterColor with a value halfway between the current value and the lo end of the spectrum.
  * The new SorterColor has a spectrum from the low end of the current spectrum to the current value.
  */
 public SorterColor getLoSplit()
  {
//    System.out.println("lo split: "+ (lo+value)/2);
    return new SorterColor((lo+value+1)/2, lo, value);   // err on rounding up
  }

  /**
  * Returns a new SorterColor with a value halfway between the current value and the high end of the spectrum.
  * The new SorterColor has a spectrum from the high end of the current spectrum to the current value.
  */
 public SorterColor getHiSplit()
  {
//    System.out.println("hi split: "+ (hi+value)/2);
    return new SorterColor((hi+value)/2, value, hi);  // err on rounding down
  }


  /**
  * "Joins" two SorterColors together to form a new SorterColor with a spectrum from 
  * the lowest spectrum end to the highest spectrum end.    The new value is halfway between 
  * its new spectrum. 
  * 
  * Note:  sc.splitLo().join(sc.splitHi())  will return an instance equivalent to sc.
  * 
  * 
  * @param sc The SorterColor to join to.
  * @return A new SorterColor with a jined spectrum and value.
  */
 public SorterColor join(SorterColor sc)
  {

    if (lo< sc.getLo())
  return new SorterColor( (lo+sc.getHi())/2, lo, sc.getHi());
 else
  return new SorterColor( (sc.getLo()+hi)/2, sc.getLo(), hi); 
  }
}