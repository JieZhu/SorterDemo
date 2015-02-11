
package sorter;

import order.AOrder;

/**
 * A concrete sorter that uses the Bubble Sort technique.
 */
public class BubbleSorter extends ASorter
{

 /**
  * The constructor for this class.
  * @param iCompareOp The comparison strategy to use in the sorting.
  */
 public BubbleSorter(AOrder iCompareOp)
 {
  super(iCompareOp);
 }

 /**
  * Splits dataArray[lo:hi] into dataArray[lo:s-1] and dataArray[s:hi] where s is the returned value of this function.
  * This method bubbles the "smallest" value to the lo end and splits it off.
  * @param dataArray the array dataArray[lo:hi] to be sorted.
  * @param lo the low index of dataArray.
  * @param hi the high index of dataArray.
  * @return lo+1 always.
  */
 protected int split(Object[] dataArray, int lo, int hi)
 {
      int j = hi;
      while (lo < j)
      {
         if (aOrder.lt(dataArray[j],dataArray[j-1]))
         {
            Object temp = dataArray[j];
            dataArray[j] = dataArray[j-1];
            dataArray[j-1] = temp;
         }
         j--;
      }
  return lo + 1;

 }

 /**
  * Joins sorted dataArray[lo:s-1] and sorted dataArray[s:hi] into dataArray[lo:hi].
  * This method does nothing.  The sub-arrays are already in proper order.
  * @param dataArray dataArray[lo:s-1] and dataArray[s:hi] are sorted.
  * @param lo the low index of dataArray.
  * @param s 
  * @param hi the high index of dataArray.
  */
 protected void join(Object[] dataArray, int lo, int s, int hi)
 {
 }
}

