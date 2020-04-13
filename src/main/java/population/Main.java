package population;

import java.util.ArrayList;

public class Main {
	private ArrayList<String> arr;

	StrUtils utils = new StrUtils();
	FileUtils fUtils = new FileUtils();
	ArrayList<WorldBankEntry> entryArr = new ArrayList<>();
	DisplayCountriesFrm cFrm;

	public Main() {
		arr = fUtils.readFile("./worldBank.txt");

		// parse the country from the string using the ":"
		for (int idx = 1; idx < arr.size(); idx++) {
			WorldBankEntry entry = utils.parseWorldBankEntry(arr.get(idx));
			if (entry != null) {
				entryArr.add(entry);
			}
		}
		
		cFrm = new DisplayCountriesFrm(entryArr);
		//printArrayList(entryArr);
		//Charts chart = new Charts(entryArr);
	}
	

	public static void main(String[] arr) {
		if (arr.length > 0) {
			System.out.println("args[0] = " + arr[0]);
			new Main();
		} else {
			System.out.println("There is no arguments ;(");

		}

	}
}
