package Task8;

public class Strategy
{
    public Strategy()
    {
        var auto = new Auto("Volvo", new PetrolMove());
        auto.Drive();
        auto.moveType = new ElectricMove();
        auto.Drive();
    }
}

interface IMovable
{
    void Move();
}
class PetrolMove implements IMovable
{
    public void Move()
    {
        System.out.println("Машина едет на бензине");
    }
}
class ElectricMove implements IMovable
{
    public void Move()
    {
        System.out.println("Машина едет на электричестве");
    }
}

class Auto
{
    String model;
    IMovable moveType;
    public Auto(String model, IMovable moveType)
    {
        this.model = model;
        this.moveType = moveType;
    }

    public void Drive()
    {
        moveType.Move();
    }
}