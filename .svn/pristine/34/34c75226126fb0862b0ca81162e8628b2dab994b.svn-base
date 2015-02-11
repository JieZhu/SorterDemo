
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import containers.ACommand;
import containers.AInteger;
import containers.IColoredObject;

public class SorterFrame<SorterActionType> extends JFrame
{

	private static final long serialVersionUID = 7015757832230457645L;
	private BorderLayout borderLayout1 = new BorderLayout();
	private JTextArea outputTA = new JTextArea();
	private JPanel jPanel2 = new JPanel();

	private GridLayout gridLayout1 = new GridLayout();

	private ButtonGroup buttonGroup = new ButtonGroup();
	private JButton gBuildBtn = new JButton();
	private JButton gSortBtn = new JButton();
	private ButtonGroup compareButtonGroup = new ButtonGroup();
	private ButtonGroup drawStyleButtonGroup = new ButtonGroup();


	private JPanel jPanel3 = new JPanel();
	private JLabel jLabel1 = new JLabel();
	private GridLayout gridLayout2 = new GridLayout();
	private JRadioButton compareWhiteRBtn = new JRadioButton();
	private JRadioButton compareBlackRBtn = new JRadioButton();

	private JPanel jPanel4 = new JPanel();
	private GridLayout gridLayout3 = new GridLayout();
	private JPanel jPanel5 = new JPanel();
	private JCheckBox reverseCBox = new JCheckBox();
	private GridLayout gridLayout4 = new GridLayout();
	private JCheckBox metricCBox = new JCheckBox();
	private JCheckBox graphicCBox = new JCheckBox();
	private JCheckBox graphicSortCBox = new JCheckBox();
	private JPanel jPanel6 = new JPanel();
	private JTextField compareDelayTF = new JTextField();
	private JTextField sortDelayTF = new JTextField();
	private GridLayout gridLayout5 = new GridLayout();
	private JPanel jPanel7 = new JPanel();
	
	private JPanel jPanel9 = new JPanel();
	private JPanel jPanel10 = new JPanel();
	private JLabel jLabel2 = new JLabel();
	private GridLayout gridLayout6 = new GridLayout();
	private JLabel jLabel4 = new JLabel();
	private GridLayout gridLayout8 = new GridLayout();
	private JLabel statusLabel1 = new JLabel();
	private JLabel statusLabel2 = new JLabel();
	private JPanel jPanel8 = new JPanel();
	private GridLayout gridLayout7 = new GridLayout();
	private JLabel jLabel3 = new JLabel();
	private JTextField numElementsTF = new JTextField();
	private JPanel jPanel1 = new JPanel();
	private JRadioButton dotsRBtn = new JRadioButton();
	private JRadioButton barsRBtn = new JRadioButton();
	private GridLayout gridLayout9 = new GridLayout();
	private JScrollPane jScrollPane1 = new JScrollPane();

	//private int minSize = 11;
	//private int maxSize = 11;
	//private int minVal = 0;
	//private int maxVal = maxSize-1;

	JPanel graphPanel = new JPanel()
	{
		private static final long serialVersionUID = 489001545813522610L;

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			graphPanelCommand.paintComponent(g);
		}
	};

	abstract class AGraphPanelCommand extends ACommand
	{
		Graphics g;
		int xIdx = 0, dx=0;
		double m, b;
		int minX, maxX, minY, maxY;

		void paintComponent(Graphics g)
		{
			this.g =g;
			xIdx = 0;
			minX = 10;
			maxX = graphPanel.getWidth()-10;
			minY = graphPanel.getHeight()-20;
			maxY = 5;
			//      dx = (maxX-minX)/(gcDataArray.length);
			//      dx = -(maxY-minY)/(gcDataArray.length);
			dx = 20;
			setMB(model.getNumValues());
			model.mapThis(this);
		}

		void setMB(int numVals)
		{
			int minVal = 0;
			int maxVal = numVals-1;
			m = ((double)(maxX-minX))/(maxVal - minVal);
			b = ((double)(minX*maxVal - maxX*minVal))/(maxVal-minVal);
		}


		abstract public void execute(Object x);

	};
	
	
	private AGraphPanelCommand dotGraphPanelCmd = new AGraphPanelCommand() {
		public void execute(Object x)
		{
			g.setColor(((IColoredObject) x).getColor());
			g.fillOval((int)(m*((AInteger)x).getValue()+b), maxY+dx*xIdx++, 10,10);
			//((ColoredIntegerAdapter) x).paint(g, m, b, maxY+dx*xIdx++);
		}		
	};

	private AGraphPanelCommand barGraphPanelCmd = new AGraphPanelCommand(){
		public void execute(Object x)
		{
			g.setColor(((IColoredObject) x).getColor());
			g.fillRect(0, maxY+dx*xIdx++, (int)(m*((AInteger)x).getValue()+b),10);
		}
	};

	AGraphPanelCommand graphPanelCommand = barGraphPanelCmd;
	private IModelAdapter<SorterActionType> model;


	//Construct the frame

	public SorterFrame(int closeOp, IModelAdapter<SorterActionType> model) {
		this.model = model;
		setDefaultCloseOperation(closeOp);
		//enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try
		{
			initGUI();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		//timer.start();
		//      System.out.println("lo = "+loColorValue+"  hi ="+hiColorValue +"  normal =" + normalColor.getValue()+"  compare =" + compareColor.getRGB()+"  black =" + Color.black.getRGB());

	}

	public void start(){
		setVisible(true);
	}

	//Component initialization
	private void initGUI() throws Exception
	{
		this.getContentPane().setLayout(borderLayout1);
		this.getContentPane().setBackground(SystemColor.textHighlightText);
		this.setSize(new Dimension(674, 688));
		this.setTitle("Template Pattern Sorting");

		jPanel2.setLayout(gridLayout1);
		gridLayout1.setColumns(1);
		gridLayout1.setRows(0);

		graphPanel.setBackground(Color.lightGray);
		graphPanel.setPreferredSize(new Dimension(400, 0));
		gBuildBtn.addActionListener(new java.awt.event.ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				model.build(Integer.parseInt(numElementsTF.getText()));
			}
		});
		gBuildBtn.setFont(new java.awt.Font("Dialog", 1, 16));
		gBuildBtn.setText("Build");
		gSortBtn.addActionListener(new java.awt.event.ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				model.doSort(graphicCBox.isSelected(), metricCBox.isSelected(), reverseCBox.isSelected(), Integer.parseInt(sortDelayTF.getText()), Integer.parseInt(compareDelayTF.getText()) );
			}
		});
		gSortBtn.setFont(new java.awt.Font("Dialog", 1, 16));
		gSortBtn.setText("Sort");
		jScrollPane1.setPreferredSize(new Dimension(100, 21));
		jLabel1.setForeground(Color.blue);
		jLabel1.setText("Compare Color:");
		jPanel3.setLayout(gridLayout2);
		gridLayout2.setColumns(1);
		gridLayout2.setRows(0);
		compareWhiteRBtn.setOpaque(false);
		compareWhiteRBtn.setSelected(true);
		compareWhiteRBtn.setText("White");
		compareWhiteRBtn.addActionListener(new java.awt.event.ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				model.setCompareColor("white");
			}
		});
		compareBlackRBtn.setOpaque(false);
		compareBlackRBtn.setText("Black");
		compareBlackRBtn.addActionListener(new java.awt.event.ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				model.setCompareColor("black");
			}
		});

		jPanel4.setLayout(gridLayout3);
		gridLayout3.setColumns(1);
		gridLayout3.setRows(0);
		reverseCBox.setOpaque(false);
		reverseCBox.setBackground(new Color(255, 255, 150));
		reverseCBox.setText("Reverse Order");
		reverseCBox.setForeground(Color.red);
		reverseCBox.setFont(new java.awt.Font("Dialog", 1, 14));
		jPanel5.setLayout(gridLayout4);
		gridLayout4.setColumns(1);
		gridLayout4.setRows(0);
		metricCBox.setOpaque(false);
		metricCBox.setBackground(new Color(255, 255, 150));
		metricCBox.setText("Count Compares");
		metricCBox.setForeground(Color.red);
		metricCBox.setFont(new java.awt.Font("Dialog", 1, 14));
		graphicCBox.setOpaque(false);
		graphicCBox.setBackground(new Color(255, 255, 150));
		graphicCBox.setText("Graphical Ordering");
		graphicCBox.setForeground(Color.red);
		graphicCBox.setFont(new java.awt.Font("Dialog", 1, 14));
		graphicSortCBox.setOpaque(false);
		graphicSortCBox.setText("Graphic Split/Join");
		graphicSortCBox.setForeground(Color.red);
		graphicSortCBox.setFont(new java.awt.Font("Dialog", 1, 14));
		compareDelayTF.setToolTipText("Compare delay (ms)");
		compareDelayTF.setText("50");
		sortDelayTF.setToolTipText("Sort delay (ms)");
		sortDelayTF.setText("100");
		jPanel6.setLayout(gridLayout5);
		gridLayout5.setColumns(1);
		gridLayout5.setRows(0);
		jLabel2.setForeground(Color.black);
		jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel2.setText("Compare Delay = ");
		jPanel9.setLayout(gridLayout6);
		jLabel4.setForeground(Color.black);
		jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel4.setText("Sort Delay = ");
		jPanel10.setLayout(gridLayout8);
		statusLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel1.setPreferredSize(new Dimension(200, 20));
		statusLabel1.setForeground(Color.red);
		statusLabel2.setForeground(Color.red);
		statusLabel2.setPreferredSize(new Dimension(200, 20));
		statusLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jPanel8.setLayout(gridLayout7);
		jLabel3.setForeground(Color.black);
		jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel3.setText("# of Elements = ");
		numElementsTF.setToolTipText("Number of elements to be sorted.");
		numElementsTF.setText("20");
		jPanel2.setBackground(new Color(255, 255, 150));
		jPanel4.setBackground(new Color(255, 255, 150));
		jPanel7.setBackground(new Color(255, 255, 150));
		jPanel7.setOpaque(false);
		jPanel5.setOpaque(false);
		jPanel3.setOpaque(false);
		jPanel6.setOpaque(false);
		jPanel8.setOpaque(false);
		jPanel9.setOpaque(false);
		jPanel10.setOpaque(false);

		jPanel1.setLayout(gridLayout9);
		gridLayout9.setColumns(1);
		gridLayout9.setRows(2);
		jPanel1.setOpaque(false);
		
		barsRBtn.setOpaque(false);
		barsRBtn.setSelected(true);
		barsRBtn.setText("Bars");
		barsRBtn.setFont(new java.awt.Font("Dialog", 1, 16));
		barsRBtn.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				graphPanelCommand = barGraphPanelCmd;
			}
		});
		
		dotsRBtn.setOpaque(false);
		dotsRBtn.setSelected(false);
		dotsRBtn.setText("Dots");
		dotsRBtn.setFont(new java.awt.Font("Dialog", 1, 16));
		dotsRBtn.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				graphPanelCommand = dotGraphPanelCmd;
			}
		});
		
		drawStyleButtonGroup.add(barsRBtn);
		drawStyleButtonGroup.add(dotsRBtn);

		jPanel1.add(barsRBtn, null);
		jPanel1.add(dotsRBtn, null);
		


		this.getContentPane().add(jPanel2, BorderLayout.WEST);
		jPanel2.add(jPanel4, null);
		jPanel4.add(statusLabel2, null);
		jPanel4.add(statusLabel1, null);
		jPanel2.add(jPanel7, null);
		jPanel7.add(gBuildBtn, null);
		jPanel7.add(gSortBtn, null);
		jPanel2.add(jPanel5, null);
		jPanel5.add(graphicCBox, null);
		jPanel5.add(metricCBox, null);
		jPanel5.add(reverseCBox, null);
		jPanel5.add(graphicSortCBox, null);
		jPanel2.add(jPanel3, null);
		jPanel3.add(jLabel1, null);
		jPanel3.add(compareWhiteRBtn, null);
		jPanel3.add(compareBlackRBtn, null);
		jPanel2.add(jPanel6, null);
		jPanel6.add(jPanel8, null);
		jPanel6.add(jPanel9, null);
		jPanel9.add(jLabel2, null);
		jPanel9.add(compareDelayTF, null);
		jPanel8.add(jLabel3, null);
		jPanel8.add(numElementsTF, null);
		jPanel6.add(jPanel10, null);
		jPanel10.add(jLabel4, null);
		jPanel10.add(sortDelayTF, null);
		jPanel2.add(jPanel1, null);


		this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
		outputTA.setFont(new Font("Monospaced", Font.PLAIN, 14));
		jScrollPane1.setViewportView(outputTA);
		this.getContentPane().add(graphPanel, BorderLayout.EAST);


		compareButtonGroup.add(compareBlackRBtn);
		compareButtonGroup.add(compareWhiteRBtn);

	}

	public void showData()
	{
		outputTA.setText("");

		model.mapThis( new ACommand(){
			public void execute(Object x)
			{
				outputTA.append(""+((AInteger)x).getValue()+"\n");
			}
		});
		graphPanel.repaint();
	}


	public void setStatusLabel1(String str) {
		statusLabel1.setText(str);
	}

	public void setStatusLabel2(String str) {
		statusLabel2.setText(str);
	}
	
	
	public void addActions(Iterable<SorterActionType> sorterActions) {
		for(SorterActionType act: sorterActions) {
			final SorterActionType sorterAction = act;
			JRadioButton rBtn = new JRadioButton();
			rBtn.setOpaque(false);
			rBtn.setSelected(true);
			rBtn.setText(sorterAction.toString());
			rBtn.setForeground(Color.red);
			rBtn.setFont(new java.awt.Font("Dialog", 1, 14));
			rBtn.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					model.doSorterAction(sorterAction);
				}
			});
			jPanel2.add(rBtn, null);
			buttonGroup.add(rBtn);
		}
		
	}
}
