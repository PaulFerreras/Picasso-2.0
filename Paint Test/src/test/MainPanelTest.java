package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class MainPanelTest extends JPanel {

	public MainPanelTest(LayoutManager layout) {
		super(layout);
		
		setPreferredSize(new Dimension(300, 300));
		
//		setBackground(Color.WHITE);
	}
	
}