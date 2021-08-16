// Author: Justin Ong
// Date: 7 September 2017
// Homework Assignment: 1
// Objective: This program creates a "Box" class and a "DemoBox" class
// "DemoBox" tests all aspects of the "Box" class.

public class DemoBox
{
	public static void main(String args[])
	{
        Box box1 = new Box(4, 4, 4);
        Box box2 = new Box(5, 6, 7);

        System.out.println("The width of box1 is: " + box1.getWidth() );

        System.out.println("The height of box2 is: " + box2.getHeight() );

        System.out.println("The volume of box1 is: " + box1.getVolume() );

        System.out.println("The volume of box2 is: " + box2.getVolume() );

	}
}