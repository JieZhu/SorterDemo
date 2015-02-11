package sorter;
import order.AOrder;

import containers.IColoredObject;
import containers.SorterColor;

/**
 * @dependency sorter.SorterColor uses
 */
public class GraphicSorter extends ASorter
{
	
	public interface StatusOutput {
		public void setText(String str);
		
		public void resetText();
	}
  
  /**
   * The decoree to which all calls are delegated.
   * @SBGen Variable (,aSorter,,0)
   */
  protected ASorter aSorter;
  /**
   * The number of milliseconds that the thread will sleep so that the user can see the color changes.
   * 
   */
  private int waitTime = 500;
  /**
   * A status label upon which the "split" or "join" is flashed during the wait time to indicate that the respective operation is taking place.
   */
  private StatusOutput statusLabel;
  
  /**
   * Constructor for this class.
   * @param aSorter The decoree.
   * @param statusLabel The JLabel to send status messages to.
   * @param waitTime The number of milliseconds to pause (sleep).
   */
  public GraphicSorter(ASorter aSorter, StatusOutput statusLabel, int waitTime)
  {
    super(null);
    this.aSorter = aSorter;
    this.statusLabel = statusLabel;
    this.waitTime = waitTime;
    
  }
  
  
  
  /**
   * Delegates to the decoree, then recursively recolors the split sections and pauses. 
   * @param dataArray The array whose sub-array is to be sorted
   * @param lo The low index of the sub-array 
   * @param hi The high index of the sub-array.
   * @return the split index.
   */
  protected int split(Object[] dataArray, int lo, int hi)
  {
    statusLabel.setText("Split");
    int s =  aSorter.split(dataArray,lo, hi);       // delegation to decoree
    // s > lo
    
    SorterColor color = (SorterColor) ((IColoredObject)dataArray[s]).getColor();
    
    for(int i=lo; i<s;i++)
    {
      ((IColoredObject) dataArray[i]).setColor(color.getLoSplit());
    }
    
    for(int i=s;i<=hi;i++)
    {
      ((IColoredObject) dataArray[i]).setColor(color.getHiSplit());
    }
    
    statusLabel.setText("Split: Done");
    pause();
    statusLabel.resetText();
    return s;
  }
  
  /**
   * Delegates to the decoree, then recursively recolors the joined sections and pauses. 
   * @param dataArray The array with the adjacent subarrays to be joined.
   * @param lo The low index of the lower sub-array
   * @param s The split index between the sub-arrays
   * @param hi The high index of the upper sub-array.
   */
  protected void join(Object[] dataArray, int lo, int s, int hi)
  {
    // lo < hi
    statusLabel.setText("Join");
    aSorter.join(dataArray,lo,s,hi);        // delegation to decoree
    
    SorterColor loColor =  (SorterColor)(((IColoredObject) dataArray[lo]).getColor());
    SorterColor hiColor =  (SorterColor)(((IColoredObject) dataArray[hi]).getColor());
    
    SorterColor color = loColor.join(hiColor);
    
    for(int i=lo;i<=hi;i++)
    {
      ((IColoredObject) dataArray[i]).setColor(color);
    }
    
    statusLabel.setText("Join: Done");
    pause();
    statusLabel.resetText();
  }
  
  
  
  
  /**
   * Pauses (sleeps) the thread for waitTime milliseconds.
   */
  protected void pause()
    
  {
    
    try
      
    {
      Thread.sleep(waitTime);
    }
    catch(Exception e){}
  }
  
  /**
   * Accessor method for aOrder.
   * @param aOrder 
   */
  public void setOrder(AOrder aOrder)
  {
    aSorter.setOrder(aOrder);
  }
}