
package sorter;

import order.AOrder;

/**
 * A concrete sorter that uses the QuickSort method.
 */
public class QuickSorter extends ASorter
{

 /**
  * The constructor for this class.
  * @param iCompareOp The comparison strategy to use in the sorting.
  */
 public QuickSorter(AOrder iCompareOp)
 {
  super(iCompareOp);
 }
 /**
  * Splits dataArray[lo:hi] into dataArray[lo:s-1] and dataArray[s:hi] where s is the returned value of this function.
  * This method places all values greater than the key at dataArray[0] at indices above the split index 
  * and all values below the key at indices less than the split index.
  * @param dataArray the array dataArray[lo:hi] to be sorted.
  * @param lo the low index of dataArray.
  * @param hi the high index of dataArray.
  * @return The split index.
  */
 protected int split(Object[] dataArray, int lo, int hi)
 {
      Object key = dataArray[lo];
      int lx = lo; // left index.
      int rx = hi; // right index.
      // Invariant 1: key <= dataArray[rx+1:hi].
      // Invariant 2: dataArray[lo:lx-1] <= key.
      // Invariant 3: there exists ix in [lo:rx] such that dataArray[ix] <= key.
      // Invariant 4: there exists jx in [lx:hi] such that key <= dataArray[jx].
      while (lx <= rx)
      {
         while (aOrder.lt(key, dataArray[rx])) // will terminate due to invariant 3.
         {
            rx--;  // Invariant 1 is maintained.
         } // dataArray[rx] <= key <= dataArray[rx+1:hi]; also  invariant 0, lx <= rx.

         while (aOrder.lt(dataArray[lx], key)) // will terminate due to invariant 4.
         {
            lx++;  // Invariant 2 is maintained.
         } // dataArray[lo:lx-1] <= key <= dataArray[lx]

         if (lx <= rx)
         {
            // swap dataArray[lx] with dataArray[rx]:
            Object temp = dataArray[lx];
            dataArray[lx] = dataArray[rx]; // invariant 3 is maintained.
            dataArray[rx] = temp;  // invariant 4 is maintained.
            rx--;  // invariant 1 is maintained.
            lx++;  // invariant 2 is maintained.
         }
      } // rx < lx, dataArray[lo:lx-1] <= key <= dataArray[rx+1:hi], and key = dataArray[lx].
  return lx;

 }

 /**
  * Joins sorted dataArray[lo:s-1] and sorted dataArray[s:hi] into dataArray[lo:hi].
  * This method does nothing, as the sub-arrays are already in proper order.
  * @param dataArray dataArray[lo:s-1] and dataArray[s:hi] are sorted.
  * @param lo the low index of dataArray.
  * @param s 
  * @param hi the high index of dataArray.
  */
 protected void join(Object[] dataArray, int lo, int s, int hi)
 {
 }
}

