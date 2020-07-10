package webScrapeGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow implements ActionListener {
	private JFrame master;
	private JButton stock;
	private JButton covid;
	private JButton openAnySite;
	public MainWindow()  {
		//set up JFrame
		master = new JFrame("Welcome");
		master.setSize(500, 400);  
        master.setVisible(true);  
        master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        //JPanel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2,3,2,3));
        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5,5,5,5));
        JPanel btnPanel = new JPanel(new GridLayout(10,1,10,5));
        	
        //stock button
        stock = new JButton("Stocks");
        //Add action command, listener, and action performed
        stock.setActionCommand("Stock");
        stock.addActionListener(this);
        
        //Covid button
        covid = new JButton("Covid");
        covid.setActionCommand("Covid-19");
        covid.addActionListener(this);
        
        
        
        
        //Vertically align buttons
        btnPanel.add(stock);
        btnPanel.add(covid);
        layout.add(btnPanel);
        panel.add(layout, BorderLayout.CENTER);
        master.add(panel);
        
        master.pack();
        master.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Stock"))
			new Stock();
		else if(e.getActionCommand().equals("Covid-19"))
			new CovidWindow();
	}
}
