package webScrapeGUI;

import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Stock {
	public Stock() {
		JFrame frame = new JFrame("Major Stock Indicies");
		frame.setSize(500, 500);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.getContentPane().setLayout(new FlowLayout());  
        
       

        JList<String> jList1 = new JList<String>(new DefaultListModel<String>());
        
		String url = "https://www.marketwatch.com/tools/marketsummary/indices/indices.asp?indexid=1&groupid=37";
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			for(Element row : doc.select("tbody tr"))
			{
				if(row.select(".symb-col").text().equals("")) {
					continue;
				}
				else {
					String ticker = row.select(".symb-col").text();
					String name = row.select(".company-col").text();
					String tempPrice = row.select(".last-col.aright").text();
					String price = tempPrice.replace(",", "");
					double p = Double.parseDouble(price);
					String s = ticker + " " + name + " " + "$"+price;
					((DefaultListModel<String>)jList1.getModel()).addElement(s);
					
				}
				
			}
			frame.add(jList1);
			frame.pack();
	        frame.setVisible(true);
	        
		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}


