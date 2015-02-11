
package sorter;

import order.AOrder;

/**
 * A concrete sorter that uses the Selection Sort technique.
 */
public class SelectionSorter extends ASorter
{

 /**
  * The constructor for this class.
  * @param iCompareOp The comparison strategy to use in the sorting.
  */
 public SelectionSorter(AOrder iCompareOp)
 {
  super(iCompareOp);
 }
 /**
  * Splits dataArray[lo:hi] into dataArray[lo:s-1] and dataArray[s:hi] where s is the returned value of this function.
  * This method places the "smallest" value in the lo position and splits it off.
  * @param dataArray the array dataArray[lo:hi] to be sorted.
  * @param lo the low index of dataArray.
  * @param hi the high index of dataArray.
  * @return lo+1 always
  */
 protected int split(Object[] dataArray, int lo, int hi)
 {
     int s = lo;
      int i = lo + 1;
      // Invariant: dataArray[s] <= dataArray[lo:i-1].
      // Scan dataArray to find minimum:
      while (i <= hi)
      {
         if (aOrder.lt(dataArray[i], dataArray[s]))
            s = i;
         i++; // Invariant is maintained.
      } // On loop exit: i = hi + 1; also invariant still holds; this makes dataArray[s] the minimum of dataArray[lo:hi].
      // Swapping dataArray[lo] with dataArray[s]:
      Object temp = dataArray[lo];
      dataArray[lo] = dataArray[s];
      dataArray[s] = temp;
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

