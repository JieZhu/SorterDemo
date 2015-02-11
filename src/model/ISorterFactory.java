package model;

import order.AOrder;
import sorter.ASorter;

public interface ISorterFactory {
	public ASorter makeSorter(AOrder aOrder);

}
