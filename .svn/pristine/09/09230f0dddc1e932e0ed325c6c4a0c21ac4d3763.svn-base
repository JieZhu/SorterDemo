package sorter;

import order.AOrder;

/**
 * Sorts an array from lo to hi by building successive heap structures.
 * <pre>
 * An array dataArray[lo:hi] is said to satisfy the "heap property" if for i = 0, 1, .., hi - lo:
 * dataArray[lo + i] <= dataArray[lo + 2 * i + 1]  and
 * dataArray[lo + i] < = dataArray[lo + 2 * i + 2], whenever these indices are in the range lo..hi.
 * </pre>
 * Heapsort is part of the hard-split/easy-join family since all the work is done in
 * the split phase.

 * @dependency sorter.Heapifier uses
 */
public class HeapSorter extends ASorter
{

   /**
  * Constructor for this class.   Assumes that array is already heapified!
  * @param dataArray the array to be sorted.
  * @param lo the lo index of the sub-array
  * @param hi the high index of the sub-array
  */
 public HeapSorter(AOrder iCompareOp)   //, Object[] dataArray, int lo, int hi)
   {
      super(iCompareOp);
      //Heapifier.Singleton().heapify(iCompareOp, dataArray, lo, hi);
   }

 /**
  * Swaps dataArray[lo] with dataArray[hi] and sift dataArray[lo] down to hi - 1.
  * Assumes dataArray satisfies the heap property.
  * Splits dataArray[hi] off.
  * @param dataArray the array dataArray[lo:hi] to be sorted.
  * @param lo the low index of dataArray.
  * @param hi the high index of dataArray.
  * @return hi always
  */
 protected int split(Object[] dataArray, int lo, int hi)
 {
      Object temp = dataArray[hi];
      dataArray[hi] = dataArray[lo];
      dataArray[lo] = temp;
      Heapifier.Singleton().siftDown (aOrder, dataArray, lo, lo, hi - 1);
  return hi;
 }

 /**
    * Does nothing, assuming s == hi. The sub-arrays are already in proper order.
  */
 protected void join(Object[] dataArray, int lo, int s, int hi)
 {
 }

}
