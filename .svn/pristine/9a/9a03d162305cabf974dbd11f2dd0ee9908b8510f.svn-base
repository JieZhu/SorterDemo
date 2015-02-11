
package containers;

import counter.Counter;

/**
 * A decorated AInteger used to count accesses to the stored value.
 */
public class CountInteger extends AInteger
{
 /**
  * The conter object used to accumulate the total count.
  */
 private Counter counter;
 /**
  * The decorated AInteger -- the "decoree".
  */
 private AInteger aNumber;
 /**
  * The constrcutor for this class.
  * @param counter The counter object used to store the count.
  * @param aNumber The decoree.
  */
 public CountInteger(Counter counter, AInteger aNumber)
 {
  this.counter = counter;
  this.aNumber = aNumber;
 }


 /**
  * Accessor method for the stored value.    Increments the total count and delegates to the decoree.
  * @return 
  */
 public int getValue()
 {

  counter.update();
  return (aNumber.getValue());  
 }

 /**
  * Accessor method for the counter object.
  * @param counter 
  */
 public void setCounter(Counter counter)
 {
  this.counter = counter;
 }

 /**
  * Clears thetotal count.
  */
 public void clearCount()
    {
        counter.clear();
    }

 /**
  * Accessor method for the total count.
  * @return 
  */
 public int getCount()
    {
        return counter.getCount();
    }
}

