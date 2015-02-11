package view;

import containers.ACommand;

public interface IModelAdapter<SorterActionType> {

	public void doSort(boolean isGraphic, boolean isMetric, boolean isReverse, int sortDelay, int compareDelay );

	public int getNumValues();

	public void mapThis(ACommand cmd);

	public void build(int numVals);

	public void setCompareColor(String colorStr);
	
	public void doSorterAction(SorterActionType sorterAction);

}
