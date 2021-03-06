package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.event.MouseInputAdapter;

public class MainPanelTest extends JPanel {

	private JToolBar tool_bar_test;
	
	public MainPanelTest(LayoutManager layout) {
		super(layout);
		
		setPreferredSize(new Dimension(300, 300));
		
		tool_bar_test = new JToolBar("Test");
		tool_bar_test.setPreferredSize(new Dimension(10, 10));
		
		tool_bar_test.addMouseMotionListener(new MouseTest());
		
		add(tool_bar_test, BorderLayout.PAGE_START);
		
//		setBackground(Color.WHITE);
	}
	
	public class MouseTest extends MouseInputAdapter {
		
		public MouseTest() {
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println("Width: " + tool_bar_test.getWidth());
		}
		
	}
	
}
