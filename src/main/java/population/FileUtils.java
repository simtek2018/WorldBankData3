package population;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {
	
	public void writeFile(String[] dataArr) {
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter("./Population1.txt");
			bw = new BufferedWriter(fw);
			for (int i=0; i<dataArr.length; i++) {
				bw.write(dataArr[i]);
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

	public ArrayList<String> readFile(String fileName) {
		FileReader fr;
		BufferedReader br;
		ArrayList<String> arrList = new ArrayList<>();
		try {
			System.out.println("File = " + fileName);
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				arrList.add(line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return arrList;
	}
}
