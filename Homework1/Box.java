public class Box 
{
    double width;
    double height;
    double depth;

    public Box(double w, double h, double d)
    {
        width = w;
        height = h;
        depth = d;
    }

    double getWidth()
    {
        return width;
    }

    double getHeight()
    {
    	return height;
    }

    double getDepth()
    {
    	return depth;
    }

    double getVolume()
    {
    	return (width * height * depth);
    }
}