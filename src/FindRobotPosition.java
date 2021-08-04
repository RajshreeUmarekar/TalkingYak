import java.util.HashMap;
import java.util.Scanner;

public class FindRobotPosition {

	public static void main(String[] args) {
		
		//Accept Input 
		Scanner scanner = new Scanner(System.in);
		String wardCoordinatesInput = scanner.nextLine();
		String robotPositionInput = scanner.nextLine();
		String instructionsInput = scanner.nextLine();
		
		//Processing Input
		String[] s1 = wardCoordinatesInput.split(" ");
		String[] s2 = robotPositionInput.split(" ");

		int[] wardCoordinates = new int[2];
		int[] robotCoordinates = new int[2];
		String robotOrientationString = s2[s2.length-1];
		Character robotOrientation = robotOrientationString.charAt(0);
		
		for(int i=0; i<s1.length;i++) 
			wardCoordinates[i] = Integer.parseInt(s1[i]);
		
		for(int i=0; i<s2.length-1;i++) 
			robotCoordinates[i] = Integer.parseInt(s2[i]);
		
		//Printing Input
		System.out.println("Ward Coordinates: " + wardCoordinates[0] + " " + wardCoordinates[1]);
		System.out.println("Robot Position: " + robotCoordinates[0] + " " + robotCoordinates[1] + " " + robotOrientation);
		System.out.println("Instructions: " + instructionsInput);
		
		//DirectionMap (Current direction to New direction)
		
		HashMap<Character, Character> leftMap = new HashMap<Character, Character>();
		leftMap.put('N', 'W');
		leftMap.put('W', 'S');
		leftMap.put('S', 'E');
		leftMap.put('E', 'N');
		
		HashMap<Character, Character> rightMap = new HashMap<Character, Character>();
		rightMap.put('N', 'E');
		rightMap.put('E', 'S');
		rightMap.put('S', 'W');
		rightMap.put('W', 'N');
		
		// Processing Instructions
		
		for(int i=0; i<instructionsInput.length(); i++) {
			char ch = instructionsInput.charAt(i);
			if(ch == 'L') {
				robotOrientation = leftMap.get(robotOrientation);
			}
			if(ch == 'R') {
				robotOrientation = rightMap.get(robotOrientation);
			}
			if(ch == 'M') {
				if(robotOrientation == 'W') {
					robotCoordinates[0] = robotCoordinates[0] - 1;
				}
				if(robotOrientation == 'E') {
					robotCoordinates[0] = robotCoordinates[0] + 1;
				}
				if(robotOrientation == 'N') {
					robotCoordinates[1] = robotCoordinates[1] + 1;
				}
				if(robotOrientation == 'S') {
					robotCoordinates[1] = robotCoordinates[1] - 1;
				}
			}
		}
		
		//Printing output
		System.out.println("Final Robot Position: " + robotCoordinates[0] + " " + robotCoordinates[1] + " " + robotOrientation);

	}
}
