import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class CourseDBStructure implements CourseDBStructureInterface{

	private Node[] arr;
	private int size;
	private final double LOAD_FACTOR = 1.5;
	
	CourseDBStructure(){
		
		this(10);
		
	}
	
	CourseDBStructure(int n){
		
		int num = (int) (n / LOAD_FACTOR);
		arr = new Node[fourKPlusThreePrime(fourKPlusThree(num))];
		size = arr.length;
		
	}
	
	CourseDBStructure(String s, int n){
		
		arr = new Node[n];
		size = arr.length;
		
	}
	
	public Node[] getArray() {
		
		return arr;
		
	}
	
	public int fourKPlusThree(int n) {
		
		int k = (n - 3) / 4;
		
		if( ( (4 * k) + 3) < n)
			
			k++;
		
		return (4 * k) + 3;
		
	}
	
	public int fourKPlusThreePrime(int n) {
		
		for (int i = 2; i <= n / 2; i++) {
			
		      if (n % i == 0) {
		    	  
		    	  return fourKPlusThree(n + 4);
		    	  
		      }
		      
		}
		
		return n;
		
	}
	
	public void add(CourseDBElement element) {
		
		int hashIndex = ("" + element.getCRN()).hashCode() % size;	
		Node current = arr[hashIndex];
		
		if(current == null) {
			
			arr[hashIndex] = new Node(element);
			return;
			
		}
		
		while(current != null) {
			
			if(current.data.compareTo(element) == 1) {
				
				current.data = element;
				return;
				
			}
			
			else if(current.next == null)
				
				break;
			
			current = current.next;
			
		}
		
		current.next = new Node(current, element, null);
		
	}

	public CourseDBElement get(int crn) throws IOException{
		
		int hashIndex = ("" + crn).hashCode() % size;
		
		if(arr[hashIndex] == null)
			
			throw new IOException();
		
		Node current = arr[hashIndex];
		
		while(current.data.getCRN() != crn) {
			
			if(current.next == null)
				
				throw new IOException();
			
			current = current.next;
			
		} 
		
		return current.data;
		
	}

	public ArrayList<String> showAll() {
		
		ArrayList<String> toReturn = new ArrayList<>();
		Node current;
		
		for(int i = 0; i < size; i++) {
			
			current = arr[i];
			
			while(current != null) {
				
				toReturn.add("Course: " + current.data.getID() + " CRN: " + current.data.getCRN() + " Credits: " + current.data.getCredits() + " Instructor: " + current.data.getProfessor() + " Room: " + current.data.getRoomNum());
				current = current.next;
				
			}
			
		}
		
		return toReturn;
		
	}

	public int getTableSize() {
		
		return size;
		
	}
	
	protected class Node{
		
		protected CourseDBElement data;
		protected Node prev;
		protected Node next;
		
		Node(){
			
			data = null;
			prev = null;
			next = null;
			
		}
		
		Node(CourseDBElement data){
			
			this.data = data;
			prev = null;
			next = null;
			
		}
		
		Node(Node prev, CourseDBElement data, Node next){
			
			this.data = data;
			this.prev = prev;
			this.next = next;
			
		}
		
	}
	
}