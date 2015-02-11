package model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;
import containers.*;

import order.*;
import sorter.*;


import counter.Counter;

public class SorterModel {

	private interface IInitCmd {
		void doInit(AOrder aOrder);
		
		static final IInitCmd NO_OP = new IInitCmd() {
			@Override
			public void doInit(AOrder aOrder) {
			}
			
		};
	}
	
	private IInitCmd initCmd = IInitCmd.NO_OP;
	
	private IViewAdapter view;
	
	int waitTime = 200;
	int sortWait = 300;
	private int repaintTime = 100;
	
	private int  loColorValue = 0;
	private int  hiColorValue =  1+Color.white.getRGB()-Color.black.getRGB();	
	
	private SorterColor normalColor = new SorterColor((loColorValue+hiColorValue)/2, loColorValue, hiColorValue);
	private Color compareColor = new SorterColor(hiColorValue-1, hiColorValue-1, hiColorValue-14-5);
	
	private AOrder aOrder = CInteger.makeOrder();
	private Object gcDataArray[] = {new ColoredIntegerAdapter(new ColoredObject(normalColor),new CInteger(0))};
	private  GraphicOrder graphicOrder = new GraphicOrder(compareColor,waitTime, aOrder);
	
	private Counter accessCounter = new Counter(1);
	private CountOrder countOrder = new CountOrder(new Counter(1), aOrder);
	
	private Timer timer  = new  Timer(repaintTime, new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			view.tick();
			

		}
	});
	
	
	private ASorter aCSorter = new InsertionSorter(aOrder);
	
	/**
	 * Constructor for the class
	 * @param view  The adapter to the view
	 */
	public SorterModel(IViewAdapter view) {
		this.view = view;	
	}
	
	
	/**
	 * Start the model.   Makes the sorters and installs them into the view and starts the animation timer.
	 */
	public void start() {
		makeSorters();
		timer.start();
		
	}


	/**
	 * Perfrom the sort using the supplied parameters.  
	 * Before the sorting is done, the initCmd is run to perform any initializations that are needed, e.g. to pre-heapify for HeapSort.
	 * @param isGraphic True if the sorting will be animated
	 * @param isMetric  True if compare and access counting will be done
	 * @param isReverse  True if the sort ordering is to be reversed.
	 * @param sortDelay  Delay in milliseconds between split and joins.
	 * @param compareDelay  Delay in milliseconds per comparison operation.
	 */
	public void doSort(final boolean isGraphic, final boolean isMetric, final boolean isReverse, final int sortDelay, final int compareDelay ) {
		(new Thread() {
			public void run()
			{

				accessCounter.clear();
				countOrder.clearCount();
				
				view.setStatusLabel2("");
				
				AOrder aOrder = buildAOrder();
				initCmd.doInit(aOrder);
				buildSorter(aOrder).sort(gcDataArray,0,gcDataArray.length-1);
				
				if (isMetric) {
					view.setStatusLabel1("# of compares = "+countOrder.getCount());
				}
				else {
					view.setStatusLabel1("");
				}
				view.setStatusLabel2("# of accesses: "+accessCounter.getCount());
			}
			
			ISorter buildSorter(AOrder aOrder)
			{
				ASorter sorter =  aCSorter;
				if(isGraphic)
				{
					sorter = new GraphicSorter (sorter, new GraphicSorter.StatusOutput() {

						@Override
						public void setText(String str) {
							view.setStatusLabel1(str);
						}

						@Override
						public void resetText() {
							view.setStatusLabel1("");
						}
						
					}, sortDelay);
				}
				sorter.setOrder(aOrder);
				return sorter;
			}
			
			
			AOrder buildAOrder()
			{
				AOrder order = aOrder;
				if(isMetric)
				{
					countOrder.setOrder(order);
					order = countOrder;
				}
				if(isReverse)
				{
					order = new ReverseOrder(order);
				}
				if(isGraphic)
				{
					graphicOrder.setOrder(order);
					graphicOrder.setWaitTime(compareDelay);
					order =  graphicOrder;
				}
				return order;
			}
			
			
		}).start();
	}

	public void mapThis(ACommand cmd)
	{
		ArrayMapper.Singleton().map(gcDataArray, cmd );
	}

	public int getNumValues() {
		return gcDataArray.length;
	}





	public void build(int numVals) {
		gcDataArray =  new Object[numVals];

		for(int i=0;i<gcDataArray.length;i++)
		{
			gcDataArray[i] = new ColoredIntegerAdapter(new ColoredObject(normalColor), new CountInteger(accessCounter, new CInteger(i)));
		}
		for(int i=0;i<gcDataArray.length;i++)
		{
			int x = (int) ((gcDataArray.length)*Math.random());
			Object tmp = gcDataArray[i];
			gcDataArray[i] = gcDataArray[x];
			gcDataArray[x] = tmp;
		}
	}


	public void setCompareColor(String colorStr) {
		switch(colorStr) {
		case "white":
			compareColor = new SorterColor(hiColorValue-1, hiColorValue-1, hiColorValue-1);
			break;
		case "black":
			compareColor = new SorterColor(loColorValue, loColorValue, loColorValue);
			break;
		default:
			break;
		}
		graphicOrder.setCompareColor(compareColor);
	}


	public void runSorterFactory(ISorterFactory sorterFac) {
		aCSorter = sorterFac.makeSorter(aOrder);
	}

	
	private void makeSorters() {
		ArrayList<ISorterFactory> sorterFacs = new ArrayList<ISorterFactory>();
		
		sorterFacs.add(new ASorterFactory("Insertion Sort"){
			@Override
			public ASorter makeSorter(AOrder aOrder) {
				initCmd = IInitCmd.NO_OP;
				return new InsertionSorter(aOrder);
			}
		});
		
		aCSorter = new InsertionSorter(aOrder);
		
		sorterFacs.add(new ASorterFactory("Selection Sort"){
			@Override
			public ASorter makeSorter(AOrder aOrder) {
				initCmd = IInitCmd.NO_OP;
				return new SelectionSorter(aOrder);
			}
		});
		
		sorterFacs.add(new ASorterFactory("Bubble Sort"){
			@Override
			public ASorter makeSorter(AOrder aOrder) {
				initCmd = IInitCmd.NO_OP;
				return new BubbleSorter(aOrder);
			}
		});
		
		sorterFacs.add(new ASorterFactory("Shaker Sort"){
			@Override
			public ASorter makeSorter(AOrder aOrder) {
				initCmd = IInitCmd.NO_OP;
				return new ShakerSorter(aOrder);
			}
		});
		
		sorterFacs.add(new ASorterFactory("Merge Sort"){
			@Override
			public ASorter makeSorter(AOrder aOrder) {
				initCmd = IInitCmd.NO_OP;
				return new MergeSorter(aOrder);
			}
		});
		
		sorterFacs.add(new ASorterFactory("QuickSort"){
			@Override
			public ASorter makeSorter(AOrder aOrder) {
				initCmd = IInitCmd.NO_OP;
				return new QuickSorter(aOrder);
			}
		});

		sorterFacs.add(new ASorterFactory("Heap Sort"){
			@Override
			public ASorter makeSorter(AOrder aOrder) {
				initCmd = new IInitCmd() {

					@Override
					public void doInit(AOrder aOrder) {
						// Heapify the array first.
						countOrder.clearCount();
						Heapifier.Singleton().heapify(aOrder, gcDataArray, 0, gcDataArray.length-1);
						if (0  != countOrder.getCount()) {
							view.setStatusLabel1("# of compares = "+countOrder.getCount());
						}
						else {
							view.setStatusLabel1("");
						}
						view.setStatusLabel2("Heapified!");
						try {
							Thread.sleep(3000);   // pause so user can see that array has been heapified.
						}
						catch(Exception e) {
						}
						view.setStatusLabel2("");
					}
				};
				return new HeapSorter(aOrder);
			}	
		});
	
		view.addSorters(sorterFacs);

	}
	
}
