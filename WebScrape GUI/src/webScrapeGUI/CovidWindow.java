package webScrapeGUI;

import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class CovidWindow {
	public CovidWindow() {
		JFrame f = new JFrame("Coronavirus Update");
		f.setSize(500, 500);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.getContentPane().setLayout(new FlowLayout());  
        
        JList<String> jList1 = new JList<String>(new DefaultListModel<String>());
		((DefaultListModel<String>)jList1.getModel()).addElement("Coronavirus Tracker");

        
        String URL = "https://www.nytimes.com/interactive/2020/us/coronavirus-us-cases.html";
        Document d;
		try {
			d = Jsoup.connect(URL).get();
			for(Element r : d.select("table tr"))
			{
				if(r.select("span:nth-of-type(2)").text().equals("")) {
					continue;
				}
				else {
					String state = r.select("span:nth-of-type(2)").text();
					String cases = "Cases: " + r.select(".tglabl.svelte-cr0hx8.false.num:nth-of-type(2)").text(); 
					String deaths = "Deaths: " + r.select(".tglabl.svelte-cr0hx8.false.num:nth-of-type(4)").text();		
					System.out.println(state + " " + cases + " " + deaths);	
					String t = state + " " + cases + " " + deaths;
					((DefaultListModel<String>)jList1.getModel()).addElement(t);
			
				}
				
				
			}
			f.add(jList1);
			f.pack();
		    f.setVisible(true);
		    
		

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
        
}

