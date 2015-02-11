package sorter;

import order.AOrder;

/**
 * Problem 1.a:   Write your analysis and outline your proposed solution here:
 * ---------------------------------------------------------------------------
 * Design Pattern(s) used:
 * 
 * The State design pattern will be used to represent the two states of the sorter.
 * There will be one state for bubbling to lo and one for bubbling to hi.  The states 
 * cause the state change to the other state.
 * 
 * 
 * (Possible) utility of BubbleSorter code:
 * 
 * The BubbleSorter's split method will be used essentially unchanged for the 
 * bubble to lo state.   Everything in the code will be reversed to use it in the 
 * bubble to hi state.
 *
 * 
 */


public class ShakerSorter extends ASorter
{
	//STUDENT TO ADD ANY NECESSARY FIELDS AND NESTED OR INNER CLASSES.

	private interface ISortState{
		public int split(Object[] dataArray, int lo, int hi);
	}

	private ISortState bubbleLo = new ISortState() {
		public int split(Object[] dataArray, int lo, int hi) {
			for(int j = hi; lo < j; j--) {
				if (aOrder.lt(dataArray[j],dataArray[j-1])) {  // Check if dataArray[j] < dataArray[j-1]
					Object temp = dataArray[j];        // Swap the the neighboring values
					dataArray[j] = dataArray[j-1];
					dataArray[j-1] = temp;
				}
			}
			state = bubbleHi;
			return lo + 1;    
		}
	};


	private ISortState bubbleHi = new ISortState() {
		public int split(Object[] dataArray, int lo, int hi) {
			for(int j = lo; j < hi; j++) {
				if (aOrder.lt(dataArray[j+1],dataArray[j])) {  // Check if dataArray[j+1] < dataArray[j]
					Object temp = dataArray[j];        // Swap the the neighboring values
					dataArray[j] = dataArray[j+1];
					dataArray[j+1] = temp;
				}
			}
			state = bubbleLo;
			return hi;    
		}
	};

	private ISortState state = bubbleLo;

	/**
	 * @param iCompareOp
	 */
	public ShakerSorter(AOrder iCompareOp)
	{
		super(iCompareOp);
	}

	/**
	 * Splits dataArray[lo:hi] into dataArray[lo:s-1] and dataArray[s:hi] where s is the returned value of this function.
	 * @param dataArray the array dataArray[lo:hi] to be sorted.
	 * @param lo the low index of dataArray.
	 * @param hi the high index of dataArray.
	 * @return
	 */
	protected int split(Object[] dataArray, int lo, int hi)
	{
		//STUDENT TO COMPLETE
		//    return hi;  // STUB CODE!  REPLACE WITH STUDENT CODE.
		return state.split(dataArray, lo, hi);
	}

	/**
	 * Joins sorted dataArray[lo:s-1] and sorted dataArray[s:hi] into dataArray[lo:hi].
	 * @param dataArray dataArray[lo:s-1] and dataArray[s:hi] are sorted.
	 * @param lo the low index of dataArray.
	 * @param s
	 * @param hi the high index of dataArray.
	 */
	protected void join(Object[] dataArray, int lo, int s, int hi)
	{
		//STUDENT TO COMPLETE
	}
}

