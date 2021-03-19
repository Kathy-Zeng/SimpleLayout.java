/*	Kathy Zeng
	Date: 3/18/21 
	SimpleLayout.java
	This program provides examples of:
	
	1. BorderLayout
	2. GridLayout
	3. FlowLayout
	4. CardLayout
	5. Nested layouts
*/
import javax.swing.JFrame;	
import javax.swing.JPanel;

import java.awt.event.MouseListener; 
import java.awt.event.MouseEvent;

import java.awt.Color;		
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Dimension;
///////////////////////// import Classes needed for Layouts ////////////////////////
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout; 

public class SimpleLayout 
{
	// each is a frame with the given type of layout.
	private JFrame borderFrame, gridFrame, flowFrame, cardFrame;  
	
	public static void main(String[] args) 
	{
		SimpleLayout sl = new SimpleLayout();
		sl.run();
	}
	
	public void run() 
	{
		makeBorderLayout();		// BorderLayout window
		makeGridLayout();		// GridLayout window
		makeFlowLayout();		// FlowLayout window
		makeCardLayout();		// CardLayout window
	}
	
	public void makeBorderLayout() 
	{
		MyPanel panBL1, panBL2, panBL3, panBL4, panBL5;
		MyColorPanel colorPanel;
		
		// Create a JFrame with BorderLayout
		borderFrame = new JFrame("BorderLayout");	// Create the JFrame
		
		/////////////////////////////////////////////////
		// Set the layout to BorderLayout (default for JFrame)
		//
		borderFrame.setLayout( new BorderLayout() );
		borderFrame.setDefaultCloseOperation(borderFrame.EXIT_ON_CLOSE);
		borderFrame.setSize(300, 300);
		borderFrame.setLocation(10, 10);
		
		/* Create panels
		*  for each panel, one of the numbers for width and height does nothing.  
		*  Play with the numbers.  Change them to other numbers.
		*  start #s shown , then the #s after the //,  then play with these. 
		*/
		panBL1 = new MyPanel(1, Color.RED); panBL1.setPreferredSize(new Dimension(20, 50)); //  20, 120
		panBL2 = new MyPanel(2, Color.BLUE); panBL2.setPreferredSize(new Dimension(20, 50));
		panBL3 = new MyPanel(3, Color.GREEN); panBL3.setPreferredSize(new Dimension(20, 50)); // 50, 100
		panBL4 = new MyPanel(4, Color.ORANGE); panBL4.setPreferredSize(new Dimension(20, 50)); // 80, 20
		panBL5 = new MyPanel(5, Color.MAGENTA); panBL5.setPreferredSize(new Dimension(20, 50)); // 100, 20
		
		/////////////////////////////////////////////////
		// Initialize colorPanel (part 5)
		//
		colorPanel = new MyColorPanel();
		/////////////////////////////////////////////////
		// Add panels to the frame
		//
		borderFrame.getContentPane().add(panBL1, BorderLayout.NORTH);
		//borderFrame.getContentPane().add(panBL2, BorderLayout.CENTER);
		borderFrame.getContentPane().add(panBL3, BorderLayout.SOUTH);
		borderFrame.getContentPane().add(panBL4, BorderLayout.EAST);
		borderFrame.getContentPane().add(panBL5, BorderLayout.WEST);
		borderFrame.getContentPane().add(colorPanel, BorderLayout.CENTER);

		// Make the JFrame visible
		borderFrame.setVisible(true);
	}
	
	public void makeGridLayout() 
	{
		MyPanel panGL1, panGL2, panGL3, panGL4, panGL5, panGL6;
		// Create a JFrame with BorderLayout
		gridFrame = new JFrame("GridLayout");	// Create the JFrame
		
		/////////////////////////////////////////////////
		// Set the layout to GridLayout
		//
		gridFrame.setLayout( new GridLayout(3,2) );
		gridFrame.setDefaultCloseOperation(gridFrame.EXIT_ON_CLOSE);
		gridFrame.setSize(300, 300);
		gridFrame.setLocation(210, 120);
		
		// Create panels
		panGL1 = new MyPanel(1, Color.RED);
		panGL2 = new MyPanel(2, Color.BLUE);
		panGL3 = new MyPanel(3, Color.GREEN);
		panGL4 = new MyPanel(4, Color.ORANGE);
		panGL5 = new MyPanel(5, Color.MAGENTA);
		panGL6 = new MyPanel(6, Color.YELLOW);
		
		// Add panels to the frame
		gridFrame.getContentPane().add(panGL1);
		gridFrame.getContentPane().add(panGL2);
		gridFrame.getContentPane().add(panGL3);
		gridFrame.getContentPane().add(panGL4);
		gridFrame.getContentPane().add(panGL5);
		gridFrame.getContentPane().add(panGL6);
		
		// Make the JFrame visible
		gridFrame.setVisible(true);
	}
	
	public void makeFlowLayout() 
	{
		MyPanel panFL1, panFL2, panFL3, panFL4, panFL5, panFL6;
		// Create a JFrame with BorderLayout
		flowFrame = new JFrame("FlowLayout");	// Create the JFrame
		
		/////////////////////////////////////////////////
		// Set the layout to FlowLayout
		//
		flowFrame.setLayout( new FlowLayout() );
		// notice this has DISPOSE.  What is the effect of that?
		flowFrame.setDefaultCloseOperation(flowFrame.DISPOSE_ON_CLOSE);	
		flowFrame.setSize(300, 300);
		flowFrame.setLocation(310, 220);
		
		// Initialize panels
		panFL1 = new MyPanel(1, Color.RED);
		panFL2 = new MyPanel(2, Color.BLUE);
		panFL3 = new MyPanel(3, Color.GREEN);
		panFL4 = new MyPanel(4, Color.ORANGE);
		panFL5 = new MyPanel(5, Color.MAGENTA);
		panFL6 = new MyPanel(6, Color.YELLOW);

		/////////////////////////////////////////////////
		// setPreferredSize for all panels - 1st we will run the prog with out this.
		//
		panFL1.setPreferredSize( new Dimension(40, 100) );
		panFL2.setPreferredSize( new Dimension(50, 200) );
		panFL3.setPreferredSize( new Dimension(60, 300) );
		panFL4.setPreferredSize( new Dimension(70, 100) );
		panFL5.setPreferredSize( new Dimension(40, 300) );
		panFL6.setPreferredSize( new Dimension(40, 200) );

		flowFrame.getContentPane().add(panFL1);
		flowFrame.getContentPane().add(panFL2);
		flowFrame.getContentPane().add(panFL3);
		flowFrame.getContentPane().add(panFL4);
		flowFrame.getContentPane().add(panFL5);
		flowFrame.getContentPane().add(panFL6);
		
		// Make the JFrame visible
		flowFrame.setVisible(true);
	}
	
	public void makeCardLayout() 
	{
		
		// Create a JFrame with BorderLayout
		
		cardFrame = new JFrame("CardLayout");	// Create the JFrame
		cardFrame.setDefaultCloseOperation(cardFrame.EXIT_ON_CLOSE);
		cardFrame.setSize(300, 300);
		cardFrame.setLocation(410, 320);
		
		// Create panels
		MyColorPanel colorPanel = new MyColorPanel();
		
		// Add panels to the frame
		cardFrame.getContentPane().add(colorPanel);
		
		// Make the JFrame visible
		cardFrame.setVisible(true);
	}
}	// end SimpleLayout

// a simple panel with number and background color. 
// Note: It is not required to have a number on a panel or a card. Anything or nothing can be on it
class MyPanel extends JPanel 
{
	private String num;  // number to be printed on each card/panel
	private Color color;  // color of each card/panel
	
	public MyPanel(int numIn, Color colorIn) 
	{
		num = "" + numIn;
		setBackground(colorIn);
	}
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.BOLD, 18));
		g.setColor(Color.WHITE);
		g.drawString(num, 10, 20);
	}
}	// end class MyPanel
	
class MyColorPanel extends JPanel implements MouseListener 
{
	//////////////////////////////////////////////////////////
	// Declare CardLayout and JPanel objects
	//
	private CardLayout cards;	
	private MyPanel color1, color2, color3;  // each is a card/JPanel that will respond to
											 // the mouse.
	public MyColorPanel() 			// constructor
	{	////////////////////////////////////////////////////////
		// Initialize CardLayout and setLayout() to this panel
		//
		cards = new CardLayout();
		setLayout(cards);
		
		// Create blue, green and red JPanels and set their backgrounds
		color1 = new MyPanel(1, Color.blue);
		color2 = new MyPanel(2, Color.green);
		color3 = new MyPanel(3, Color.red);

		////////////////////////////////////////////////////////
		// Add the MouseListener to *each* JPanel  
		//
		color1.addMouseListener(this);
		color2.addMouseListener(this);
		color3.addMouseListener(this);
		// add each JPanel to MyColorPanel 
		add(color1, "Panel1");
		add(color2, "Panel2");
		add(color3, "Panel3");
		
	}
	public void mousePressed(MouseEvent evt) 
	{
		////////////////////////////////////////////////////////
		// Select the next panel on the stack of panels
		//
		cards.next(this);
	}

	public void mouseEntered(MouseEvent evt) { }
	public void mouseExited(MouseEvent evt) { }
	public void mouseClicked(MouseEvent evt) { }
	public void mouseReleased(MouseEvent evt) { }
}
