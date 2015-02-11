
package sorter;

import order.AOrder;

/**
 * A concrete sorter that uses the Insertion Sort technique.
 */
public class InsertionSorter extends ASorter
{

 /**
  * The constructor for this class.
  * @param iCompareOp The comparison strategy to use in the sorting.
  */
 public InsertionSorter(AOrder iCompareOp)
 {
  super(iCompareOp);
 }
 /**
  * Splits dataArray[lo:hi] into dataArray[lo:s-1] and dataArray[s:hi] where s is the returned value of this function.
  * This simply splits off the element at index hi.
  * @param dataArray the array dataArray[lo:hi] to be sorted.
  * @param lo the low index of dataArray.
  * @param hi the high index of dataArray.
  * @return hi always.
  */
 protected int split(Object[] dataArray, int lo, int hi)
 {
  return (hi);
 }

 /**
  * Joins sorted dataArray[lo:s-1] and sorted dataArray[s:hi] into dataArray[lo:hi].   (s = hi)
  * The method performs an in-order insertion of dataArray[hi] into the dataArray[lo, hi-1]
  * @param dataArray dataArray[lo:s-1] and dataArray[s:hi] are sorted.
  * @param lo the low index of dataArray.
  * @param s 
  * @param hi the high index of dataArray.
  */
 protected void join(Object[] dataArray, int lo, int s, int hi)
 {
      int j = hi; // remember s == hi.
      Object key = dataArray[hi];
      // Invariant: dataArray[lo:j-1] and dataArray[j+1:hi] are sorted and key < all elements of dataArray[j+1:hi].
      // Shifts elements of dataArray[lo:j-1] that are greater than key to the "right" to make room for key.
      while (lo < j && aOrder.lt(key, dataArray[j-1]))
      {
         dataArray[j] = dataArray[j-1];
         dataArray[j-1] = key;
         j = j - 1;     // invariant is maintained.
      }   // On loop exit: j = lo or dataArray[j-1] <= key. Also invariant is still true.
 //     dataArray[j] = key;
 }
}

