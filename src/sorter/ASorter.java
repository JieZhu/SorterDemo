
package sorter;

import order.AOrder;

/**
 * A Template Method design pattern abstract sorter.   An abstract ordering strategy is required that must be matched to the type of objects being sorted.
 * 
 */
public abstract class ASorter implements ISorter
{
 protected AOrder aOrder;
 /**
  * The constructor for this class.
  * @param aOrder The abstract ordering strategy to be used by any subclass.
  */
 protected ASorter(AOrder aOrder)
 {
  this.aOrder = aOrder;
 }


 /**
    * Sorts by doing a split-sort-sort-join.  Splits the original array into two subarrays,
    * recursively sorts the split subarrays, then re-joins the sorted subarrays together.
    * This is the template method.  It calls the abstract methods split and join to do
    * the work.  All comparison-based sorting algorithms are concrete subclasses with
    * specific split and join methods.
  * @param dataArray the array A[lo:hi] to be sorted.
  * @param lo the low index of A.
  * @param hi the high index of A.
  */
 public final void sort(Object[] dataArray, int lo, int hi)
 {
      if (lo < hi)
      {
         int s = split (dataArray, lo, hi);
         sort (dataArray, lo, s-1);
         sort (dataArray, s, hi);
         join (dataArray, lo, s, hi);
      }
 }

 /**
    * Splits A[lo:hi] into A[lo:s-1] and A[s:hi] where s is the returned value of this function.
  * @param A the array A[lo:hi] to be sorted.
  * @param lo the low index of A.
  * @param hi the high index of A.
  */
 protected abstract int split(Object[] dataArray, int lo, int hi);

 /**
    * Joins sorted A[lo:s-1] and sorted A[s:hi] into A[lo:hi].
  * @param A A[lo:s-1] and A[s:hi] are sorted.
  * @param lo the low index of A.
  * @param hi the high index of A.
  */
 protected abstract void join(Object[] dataArray, int lo, int s, int hi);

 /**
  * An accessor method for the abstract ordering strategy.
  * @param aOrder 
  */
 public void setOrder(AOrder aOrder)
 {
  this.aOrder = aOrder;
 }
}

