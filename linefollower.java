/*
    lego linefollower
*/

import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Stopwatch;

public class LineFollowerTemplate  implements ButtonListener //make sure the classname matches the filename (case-sensitive)
{
    private DifferentialPilot bot;  //field declaration for a Pilot object
    private LightSensor light;  //field declaration for a LightSensor object

    //create a constant for the light threshold
    private final int THRESHOLD = 55;

    //the code in the main method will not change (except for the classname)
    public static void main(String[] args)
    {
        LineFollowerTemplate myProgram = new LineFollowerTemplate(); //matches classname (case-sensitive)
        Button.ESCAPE.addButtonListener(myProgram);
        Button.LEFT.addButtonListener(myProgram);  //register this object as a listener
        myProgram.run();
    }//main()

    //the constructor generally instantiates field objects and
    //sets other initial state information
    public LineFollowerTemplate()   //matches classname (case-sensitive)
    {
        //instantiate a DifferentialPilot object named "bot"
        bot = new DifferentialPilot(56, 108, Motor.B, Motor.C);

        // place light sensor on Port 1
        light = new LightSensor(SensorPort.S1);

    }//constructor

    //your code goes in this method
    public void run()
    {

        // Create a Stopwatch that monitors elapsed time in milliseconds
        Stopwatch sw = new Stopwatch();
        long time_in_milliseconds = 30000L;

        // Create your variables here

        // Determine a good threshold value first to set the threshold constant
        // this may be commented out after the threshold has been set.
        checkLight();

        // Find the line, then follow the line until ESCAPE is pressed,
        // use light.readValue() to read the sensor

        while ( sw.elapsed() < time_in_milliseconds )
        {
            bot.forward (); // Send the robot forward

            if ( light.readValue() > THRESHOLD )
            {
			bot.stop();
            rotate(360);
			if ( light.readValue() < THRESHOLD && rotate < 180 )
			{
				bot.forward ();
			}
			else {
				rotate (360); }
            } // if
		bot.forward();
        } // while

    } //run()

    //displays values for light and dark until LEFT is pressed
    public void checkLight()
    {
        // Use the light sensor as a reflection sensor
        light.setFloodlight(true);
        LCD.drawString("Light %: ", 0, 0);

        // Show light percent until LEFT is pressed
        while (! Button.LEFT.isPressed())
        {
            LCD.drawInt(light.readValue(), 3, 9, 0);
            LCD.refresh();
        }
    }

    //the following method writes a string to the screen. Useful for debugging.
    public void displayString(String msg)
    {
        LCD.clear();
        LCD.drawString(msg, 0, 0);  //writes the msg to the screen
        LCD.refresh();
    }//displayString()

    //the following method writes an int (whole number) to the screen. Useful for debugging.
    public void displayInt(int num)
    {
        LCD.clear();
        LCD.drawInt(num, 4, 0, 0);  //writes the num to the screen
        LCD.refresh();
    } //displayInt

    //the following method allows the bot to do what it was doing, but suspends execution of the
    //next statement. When this method returns, the program continues executing where it left off.
    public void pause(int milli)
    {
        try
        {
            Thread.sleep(milli);
        }//try
        catch(InterruptedException e)
        {
        }//catch
    }//sleep()

    // this method is required when a class is a ButtonListener
    // it responds to the action of the button being pressed
    public void buttonPressed(Button b)
    {
        if (b.equals(Button.ESCAPE))
        {
            displayString("ESCAPE pressed");
            bot.stop();
        }
        else return;

    }

    // this is also required, but we aren't using it, so it is empty
    public void buttonReleased(Button b) {}

}//class
