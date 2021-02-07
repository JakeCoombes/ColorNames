//Student Name: Jake Coombes
//Class:		CIS180-01
//Assignment:	Lab 4 A
//Due Date:		10/2/18
//Description:
//	This code should allow the user to select 6 different RGB values 
//	and have the window change to that color and print said color. 
//	have the window change the color name using only "if" statements
//	using the logical AND (&&) operator for the first 3 values, and 
//	the logical NOT (!) operator, as well as, AND (&&) for the last 3 values

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorNamesA extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	//Create variables for colors and color rgb values
	private Color[] bgColors = { Color.red, Color.green, Color.blue, Color.yellow, Color.cyan, Color.magenta}; //If you want to add White and Black use: Color.white and Color.black
	private String[] strColors = {"(255,0,0)", "(0,255,0)", "(0,0,255)", "(255,255,0)", "(0,255,255)", "(255,0,255)"}; //If you want to add White and Black use: (255,255,255) and (0,0,0)
	
	//Create variables for GUI elements
	private JComboBox<String> colorCombo = new JComboBox<>(strColors);
	private JTextField txtColor = new JTextField("", 10);
	private JPanel backgroundPane = new JPanel();
	
	public ColorNamesA() {
		//Set up the GUI
		super("ColorNamesA");
		backgroundPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
		this.add(backgroundPane);
		
		//Add the combo box to the background pane
		backgroundPane.add(colorCombo);
		colorCombo.setSelectedIndex(0);
		colorCombo.addActionListener(this);
		backgroundPane.setBackground(bgColors[colorCombo.getSelectedIndex()]);
		
		//Add the text field to the background pane
		backgroundPane.add(txtColor);
		txtColor.setEnabled(false);
		txtColor.setText("Red");
		txtColor.setHorizontalAlignment(JTextField.CENTER);
		
		//Set the background pane parameters
		this.setSize(325, 200);
		this.setResizable(false);
		this.setLocationByPlatform(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); // Who generated the event?
		
		//If the combo box has changed
		if (source == colorCombo) {
			//Set the background to the selected color
			backgroundPane.setBackground(bgColors[colorCombo.getSelectedIndex()]);
			
			//Get the red, green, and blue values of the color (int red for red value, int green for green value, and int blue for blue value)
			int[] rgb = getRGB(bgColors[colorCombo.getSelectedIndex()]);
			int red = rgb[0];
			int green = rgb[1];
			int blue = rgb[2];
			
			/***********************************************
			 * Develop your if statements under this comment
			 * *********************************************
			 * Remember to have two separate java files for
			 * part a and b.
			 * Also, pay attention to the variables above.
			 * *********************************************
			 * To set the text value, use:
			 * txtColor.setText("YOUR_COLOR_NAME_HERE");
			 ***********************************************/
			
			//System.out.println("Red: " + red + "\nGreen: " + green + "\nBlue: " + blue + "\n");
				
			
			if(red==255 && green==0 && blue==0) 
				txtColor.setText("Red");
			if(red==0 && green==255 && blue==0) 
				txtColor.setText("Green");
			if(red==0 && green==0 && blue==255) 
				txtColor.setText("Blue");
			
			if(red==255 && green==255 && blue!=255) 
				txtColor.setText("Yellow");
			if(red!=255 && green==255 && blue==255) 
				txtColor.setText("Cyan");
			if(red==255 && green!=255 && blue==255) 
				txtColor.setText("Magenta");
			
		}
		
	}
	public static void main(String[] args) {
		new ColorNamesA();
	}
	
	public int[] getRGB(Color rgb) {
		int[] rgbVals =  new int[3];
		rgbVals[0] = rgb.getRed();
		rgbVals[1] = rgb.getGreen();
		rgbVals[2] = rgb.getBlue();
		return rgbVals;
	}
}