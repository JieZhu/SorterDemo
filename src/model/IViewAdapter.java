package model;

public interface IViewAdapter {

	void tick();

	void setStatusLabel1(String str);
	void setStatusLabel2(String str);

	void addSorters(Iterable<ISorterFactory> sorterFacs);



}
