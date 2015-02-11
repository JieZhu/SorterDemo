 package sorter;

import order.AOrder;

/**
* Maintains the heap structure of a given array.
<pre>
An array dataArray[lo:hi] is said to satisfy the "heap property" if for i = 0, 1, .., hi - lo:
dataArray[lo + i] <= dataArray[lo + 2 * i + 1]  and
dataArray[lo + i] < = dataArray[lo + 2 * i + 2], whenever these indices are in the range [lo..hi].
</pre>

*/
public class Heapifier
{
   private static final Heapifier instance  = new Heapifier ();

   private Heapifier()
   {
   }

   public static Heapifier Singleton()
   {
      return instance;
   }
   /**
   * "Sifts" dataArray[cur] up the array dataArray to maintain the heap property.
   * @param dataArray dataArray[lo:cur-1] is a heap.
   * @param lo the low index of dataArray.
   * @param cur lo <= cur <= the high index of dataArray.
   */
 public void siftUp(AOrder iCompareOp, Object[] dataArray, int lo, int cur)
 {
      int parent = (cur - lo - 1) / 2 + lo;  // index of parent.
      if (0 < (cur - lo) && iCompareOp.lt(dataArray[parent], dataArray[cur]))
      {
        Object dat = dataArray[cur];
         dataArray[cur] = dataArray[parent];
        dataArray[parent] = dat;
        siftUp(iCompareOp, dataArray, lo, parent);
      }
 }


 /**
    * "Sifts" the value at dataArray[cur] down the array dataArray to maintain the heap property.
  * @param dataArray  dataArray[cur + 1:hi] satisfies the heap property.
    * @param lo the low index of dataArray.
  * @param cur lo <= cur <= hi.
  * @param hi  the high index of a.
  */
 public void siftDown(AOrder iCompareOp, Object[] dataArray, int lo, int cur, int hi)
 {
      int child = 2 * (cur -lo) + 1 + lo; // index of left child of dataArray[cur].
      if(hi>=child)
      {
         if ((child < hi) && iCompareOp.lt(dataArray[child], dataArray[child + 1]))
         {
            child++; // select the right child
         } // child is the index of the smaller of the two children.
         if (iCompareOp.lt(dataArray[cur], dataArray[child]))
         {
            Object dat = dataArray[cur]; // swap the data.
            dataArray[cur] = dataArray[child];
            dataArray[child] = dat;
            siftDown(iCompareOp, dataArray, lo, child, hi);
         }  // dataArray[cur] is less than its children.
      } // location found for temp.
 }


  public void heapify(AOrder iCompareOp, Object[] dataArray, int lo, int hi)
  {
      if((hi-lo)>0)
      {
        for(int i = (hi-lo-1)/2;i>=0; i--)
        {
          siftDown(iCompareOp, dataArray, lo, i, hi);
        }
      }

  }
}
