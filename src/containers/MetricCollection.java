
package containers;

import counter.Counter;

public class MetricCollection extends ACollection
{
 private ACollection aCollection;
 private Counter readCounter;
 private Counter writeCounter;

 /**
  * @param aCollection
  * @param readCounter
  * @param writeCounter
  */
 public MetricCollection(ACollection aCollection, Counter readCounter, Counter writeCounter)
 {
  this.aCollection = aCollection;
  this.readCounter = readCounter;
  this.writeCounter = writeCounter;
 }

 /**
  * @param idx
  * @return
  */
 public Object getAt(int idx)
 {
   readCounter.update();
  return (aCollection.getAt(idx));
 }

 /**
  * @param idx
  * @param data
  */
 public void setAt(Object data, int idx)
 {
  writeCounter.update();
  aCollection.setAt(data, idx);
 }

 /**
  * @return
  */
 public Counter getReadCounter()
 {
  return(readCounter);
 }

 /**
  * @return
  */
 public Counter getWriteCounter()
 {
  return(writeCounter);
 }
}

