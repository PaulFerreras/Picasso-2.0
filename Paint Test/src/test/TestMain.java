package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class TestMain {

	public static void main(String[] args) {
		JFrame main_frame = new JFrame();
		main_frame.setTitle("TestMain");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainPanelTest main_panel = new MainPanelTest(new BorderLayout());
		
		NullAreaPanel null_area_panel = new NullAreaPanel(null);
		
		JScrollPane scroll_pane = new JScrollPane(null_area_panel, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll_pane.setPreferredSize(
				new Dimension(main_panel.getWidth(), main_panel.getHeight()));
		
		ResizablePanel resizable_panel = new ResizablePanel();
		resizable_panel.addObserver(null_area_panel);
		
		JPanel white_area = new JPanel();
		white_area.setBackground(Color.WHITE);
		
		//PF: Add Panels
		resizable_panel.add(white_area, BorderLayout.CENTER);
		null_area_panel.add(resizable_panel);
		main_panel.add(scroll_pane, BorderLayout.CENTER);
		
		main_frame.setContentPane(main_panel);
		
		main_frame.pack();
		main_frame.setVisible(true);
		
		null_area_panel.setPreferredSize(
				new Dimension(scroll_pane.getViewport().getWidth(), scroll_pane.getViewport().getHeight()));
	}

}
