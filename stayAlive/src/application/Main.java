package application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
/**
 * This class represents a method to keep certain Windows programs from going to sleep.
 * This is accomplished by automatically clicking on the application every n minutes to
 * give the impression the windows application is actively in use. The application must
 * be positioned according to the x and y coordinates of the screen and positioned in 
 * such a way that when the cursor automatically moves to the specified position  after
 * the specified number of minutes, it will left mouse click in an area within the 
 * application that will keep the application from falling asleep. This program uses
 * the Java Robot class for the automation.

 * @author CBHowell
 * Last Updated: 4 December 2020
 */
public class Main {

	/**
	 * @param args
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		//**************************PROGRAM CONFIGURATION SETTINS*****************************************		
		int x = 1900;          	// Set the x position of where the cursor should move on the user's screen.
		int y = 30;            	// Set the y position of where the cursor should move on the user's screen.		
		int waitTime = 420000; 	//Set the time between loop iterations (7 minutes = 420000 milliseconds)	
		int delayTime = 8;     	// Set the time between individual mouse events (For testing purposes).
		int numberOfLoops = 3; 	//Here, the user can set the number of times the program should loop/run.
		//************************************************************************************************
		
		
		//**************************ADMINISTRATIVE CODE  BLOCK********************************************
		Robot robot = new Robot();  // Create Robot Java object.
		boolean loopAgain = true;   // Variable to determine whether loop should execute.
		int count = 0; 				// Variable to track the number of loops
		//************************************************************************************************
		
		
		//****************************MAIN PROGRAM LOGIC**************************************************
		do {
			//Keep track of the number of loops
			count++;
			//If the desired number of loops is met, then don't run the loop again, otherwise, run the loop again
			loopAgain = (count == numberOfLoops)? false: true;
			//Move the mouse cursor to the specified location on the screen
			robot.mouseMove(x, y);
			//Delay for n milliseconds
			robot.delay(delayTime);		
			// Click left mouse button
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			//Delay for n milliseconds
			robot.delay(delayTime);
			//Release left mouse button
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			//If the desired number of loops is not met, put the thread to sleep for n milliseconds
			if(count != numberOfLoops)				
				Thread.sleep(waitTime);	
		}while(loopAgain);	
		//*****************************************************************************************************
	}
}
