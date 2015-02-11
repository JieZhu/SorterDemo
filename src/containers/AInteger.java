
package containers;

/**
 * An abstract object that stores an integer value that can be used for sorting.
 * @dependency sorter.AOrder instantiates
 */
public abstract class AInteger
{
 /**
  * Accessor method for the stored value.
  * @return
  */
 public abstract int getValue();


 /**
  * Creates a string representation of the stored value.
  */
 public String toString()
    {
        return ""+getValue();
    }
}

