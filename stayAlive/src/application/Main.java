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
		
		//Variable Declarations and Initializations
		
		int x = 1900, y = 30, count = 0,  numberOfLoops = 3; //NumberOfLoops = the number of times the program should run
		Robot robot = new Robot();
		boolean loopAgain = true;
		
		//Main program logic
		
		do {
			//Keep track of the number of loops
			count++;
			//If the desired number of loops is met, then don't run the loop again, otherwise, run the loop again
			loopAgain = (count == numberOfLoops)? false: true;
			//Move the mouse cursor to the specified location on the screen
			robot.mouseMove(x, y);
			//Delay for n milliseconds
			robot.delay(8);		
			// Click left mouse button
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			//Delay for n milliseconds
			robot.delay(8);
			//Release left mouse button
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			//If the desired number of loops is not met, put the thread to sleep for n milliseconds
			if(count != numberOfLoops)
				//Set the time between mouse clicks (7 minutes = 420000 milliseconds)
				Thread.sleep(420000);		
		}while(loopAgain);		
	}
}
