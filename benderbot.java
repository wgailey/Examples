/*Bender the bot with a dying motor*/

import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;


public class zigzag  //make sure the classname matches the filename (case-sensitive)
{
private DifferentialPilot bot;  //field declaration for a DifferentialPilot object


//the code in the main method will not change (except for the classname)
public static void main(String[] args)
{
zigzag myProgram = new zigzag(); //matches classname (case-sensitive)
myProgram.run();
}//main()


//the constructor generally instantiates field objects and sets other initial state information
public zigzag()   //matches classname (case-sensitive)
{
bot = new DifferentialPilot(50, 50, Motor.B, Motor.C);  //instantiate a DifferentialPilot object named "bot"

}//constructor


//your code goes in this method
public void run()
{
bot.travel(650);
bot.rotate(30);
bot.travel(700);
bot.rotate(185);
bot.travel(860);
bot.rotate(285);
bot.travel(1050);
bot.rotate(-215);
bot.travel(1050);
bot.rotate(285);
bot.travel(800);
bot.stop();
}//run()

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

}//class zigzag
