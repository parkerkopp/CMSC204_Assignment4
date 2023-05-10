
import java.io.*;
import java.util.*;
import java.io.IOException;

public class CourseDBManager implements CourseDBManagerInterface {
	
	private CourseDBStructure databaseStructure;
	
	CourseDBManager() {
		
		databaseStructure = new CourseDBStructure();
		
	}

	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		
		databaseStructure.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
		
	}

	public CourseDBElement get(int crn) {
		
		try {
			
			return databaseStructure.get(crn);
			
		} catch (IOException e) {
			
			return null;
			
		}	
		
	}

	public void readFile(File input) throws FileNotFoundException {
			
		Scanner fileIn = new Scanner(input);
		
		while(fileIn.hasNextLine()) {
			
			String temp = "";
			String[] currLine = fileIn.nextLine().split("\\s");
			
			for(int i = 4; i < currLine.length; i ++)
				
				temp += currLine[i] + " ";
			
			add(currLine[0], Integer.valueOf(currLine[1]), Integer.valueOf(currLine[2]), currLine[3], temp.substring(0, temp.length() - 1));
			
		}
		
		fileIn.close();
	
	}

	public ArrayList<String> showAll() {
		
		return databaseStructure.showAll();
		
	}

}