package Task6;

public class Prototype
{
    public Prototype()
    {
        Work();
    }

    private void Work()
    {
        var figure1 = new Rectangle(20, 40);
        var figure1_1 = figure1.Clone();
        figure1.GetInfo();
        figure1_1.GetInfo();

        var figure2 = new Circle(5);
        var figure2_1 = figure2.Clone();
        figure2.GetInfo();
        figure2_1.GetInfo();
    }
}

interface IFigure
{
    IFigure Clone();
    void GetInfo();
}

class Rectangle implements IFigure
{
    private int X;
    private int Y;

    public Rectangle(int x, int y)
    {
        X = x;
        Y = y;
    }

    public IFigure Clone()
    {
        return new Rectangle(this.X, this.Y);
    }

    public void GetInfo()
    {
        System.out.println("Прямоугольник: X = " + X + ", Y = " + Y);
    }
}

class Circle implements IFigure
{
    private int Radius;

    public Circle(int radius)
    {
        Radius = radius;
    }

    public IFigure Clone()
    {
        return new Circle(this.Radius);
    }

    public void GetInfo()
    {
        System.out.println("Круг: Радиус = " + Radius);
    }
}