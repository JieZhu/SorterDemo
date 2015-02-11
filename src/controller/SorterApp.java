package controller;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import containers.ACommand;

import model.IViewAdapter;
import model.SorterModel;
import model.ISorterFactory;

import view.IModelAdapter;
import view.SorterFrame;

public class SorterApp extends JApplet {

	private static final long serialVersionUID = 5721458394467242121L;

	private SorterFrame<ISorterFactory> view;
	private SorterModel model;
	
	public SorterApp(){
		this(WindowConstants.HIDE_ON_CLOSE);
	}

	public SorterApp(int windowClosing) {
		
		view = new SorterFrame<ISorterFactory>(windowClosing, new IModelAdapter<ISorterFactory>() {

			@Override
			public void doSort(boolean isGraphicSort, boolean isMetric, boolean isReverse, int sortDelay, int compareDelay ) {
				model.doSort( isGraphicSort, isMetric, isReverse, sortDelay, compareDelay );
			}

			@Override
			public int getNumValues() {
				return model.getNumValues();
			}

			@Override
			public void mapThis(ACommand cmd) {
				model.mapThis(cmd);
			}

			@Override
			public void build(int numVals) {
				model.build(numVals);
			}

			@Override
			public void setCompareColor(String colorStr) {
				model.setCompareColor(colorStr);
			}

			@Override
			public void doSorterAction(ISorterFactory sorterAction) {
				model.runSorterFactory(sorterAction);
				
			}
			
		});
		
		model = new SorterModel(new IViewAdapter() {

			@Override
			public void tick() {
				view.showData();
			}

			@Override
			public void setStatusLabel1(String str) {
				view.setStatusLabel1(str);
				
			}

			@Override
			public void setStatusLabel2(String str) {
				view.setStatusLabel2(str);
				
			}

			@Override
			public void addSorters(Iterable<ISorterFactory> sorterFacs) {
				view.addActions(sorterFacs);
			}
			
		});
	}
	
	public void start(){
		model.start();
		view.start();
		
	}

	//Main method
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				(new SorterApp(WindowConstants.EXIT_ON_CLOSE)).start();
			}
			
		});
	}
} 