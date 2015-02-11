
package sorter;

import order.AOrder;

/**
 * A concrete sorter that uses the Merge Sort method.
 */
public class MergeSorter extends ASorter
{
 /**
  * Temporary array for merging.
  */
 private Object[] _tempA = new Object[1];

 /**
  * @param iCompareOp
  */
 public MergeSorter(AOrder iCompareOp)
 {
  super(iCompareOp);
 }

 /**
  * Merges the sorted dataArray[lx:mx-1] and the sorted dataArray[mx:rx] into _tempA[lx:rx].
  * @param dataArray dataArray[lx:mx-1] (left array) and dataArray[mx:rx] (right array) are sorted.
  * @param lx the low index of the left array.
  * @param mx the low index of the right array, lx < mx <= rx.
  * @param rx the high index of the right array.
  */
 private void merge(Object[] dataArray, int lo, int s, int hi)
 {
      int i = lo;
      int j = s;
      for (int k = lo; k <= hi; k++)
      {
         if ((i < s) && (j <= hi))
         {
            if (aOrder.lt(dataArray[i], dataArray [j]))
            {
               _tempA[k] = dataArray[i++];
            }
            else
            {
               _tempA[k] = dataArray[j++];
            }
         }
         else if (i < s)
         {
            _tempA[k] = dataArray[i++];
         }
         else if (j <= hi)
         {
            _tempA[k] = dataArray[j++];
         }
      }
 }

 /**
  * Splits dataArray[lo:hi] into dataArray[lo:s-1] and dataArray[s:hi] where s is the returned value of this function.
  * Splits the sub-array in two.
  * @param dataArray the array dataArray[lo:hi] to be sorted.
  * @param lo the low index of dataArray.
  * @param hi the high index of dataArray.
  * @return (hi-lo)/2 always.
  */
 public int split(Object[] dataArray, int lo, int hi)
 {
  return ((lo + hi + 1)/2);
 }

 /**
  * Joins sorted dataArray[lo:s-1] and sorted dataArray[s:hi] into dataArray[lo:hi].
  * This method uses the temporary array to merge the sub-arrays into and copies the data back to the original space.
  * @param dataArray dataArray[lo:s-1] and dataArray[s:hi] are sorted.
  * @param lo the low index of dataArray.
  * @param s 
  * @param hi the high index of dataArray.
  */
 public void join(Object[] dataArray, int lo, int s, int hi)
 {
      _tempA = new Object [dataArray.length];
      merge (dataArray, lo, s, hi);
      for (int i = lo; i <= hi; i++)
      {
         dataArray[i] = _tempA[i];
      }
 }
}

