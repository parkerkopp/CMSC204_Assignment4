
public class CourseDBElement implements Comparable<CourseDBElement>{
	
	private String id;
	private int crn;
	private int credits;
	private String professor;
	private String room;
	
	public CourseDBElement() {
		
		id = null;
		crn = 0;
		credits = 0;
		professor = null;
		room = null;
		
	}
	
	public CourseDBElement(String id, int crn, int credits, String professor, String room) {
		
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.professor = professor;
		this.room = room;
		
	}
	
	public String getID() {
		
		return id;
		
	}
	
	public void setID(String id) {
		
		this.id = id;
		
	}
	
	public int getCRN() {
		
		return crn;
		
	}
	
	public void setCRN(int crn) {
		
		this.crn = crn;
		
	}

	public int getCredits() {
		
		return credits;
		
	}
	
	public void setCredits(int credits) {
		
		this.credits = credits;
		
	}
	
	public String getProfessor() {
		
		return professor;
		
	}
	
	public void setProfessor(String professor) {
		
		this.professor = professor;
		
	}
	
	public String getRoomNum() {
		
		return room;
		
	}
	
	public void setRoom(String room) {
		
		this.room = room;
	}
	
	public int compareTo(CourseDBElement other) {
		
		if(id.equals(other.id) && crn == other.crn && credits == other.credits && room.equals(other.room) && professor.equals(other.professor) )
			
			return 1;
		
		else
			
			return 0;
		
	}
	
}
