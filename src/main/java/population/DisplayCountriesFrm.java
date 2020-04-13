package population;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplayCountriesFrm extends JFrame implements ActionListener {
	String[] countriesArr;
	private JList<String> countryLst;
	private JButton showPopulation;
	private ArrayList<WorldBankEntry> data;
	private Charts charts;
	
	public DisplayCountriesFrm(ArrayList<WorldBankEntry> data) {
		this.data = data;
		countriesArr = new String[data.size()];
		Container container = getContentPane();
		for (int i=0; i<data.size(); i++) {
			WorldBankEntry cntRow = data.get(i);
			countriesArr[i] = cntRow.getCountry();
		}
		countryLst = new JList<>(countriesArr);
		JScrollPane scroll = new JScrollPane(countryLst);
		scroll.setViewportView(countryLst);
		
		JPanel centerPnl = new JPanel();
		JPanel southPnl = new JPanel();
		
		showPopulation = new JButton("Show");
		showPopulation.addActionListener(this);
		southPnl.add(showPopulation);
		
		centerPnl.add(scroll);
		container.add(centerPnl, BorderLayout.CENTER);
		container.add(southPnl,BorderLayout.SOUTH);
		setSize(400, 500);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent comp) {
		System.out.println("I hit a button");
		Object src = comp.getSource();
		
		if (src == showPopulation) {
			int idx = countryLst.getSelectedIndex();
			if (idx > -1) {
				WorldBankEntry entry = data.get(idx);
				charts = new Charts(entry);
			}
		}

	}

}
