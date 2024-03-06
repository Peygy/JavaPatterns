package Task7;

public class Adapter
{
    public Adapter()
    {
        Driver driver = new Driver();
        Auto auto = new Auto();
        driver.Travel(auto);

        Camel camel = new Camel();
        ITransport camelTransport = new CamelToTransportAdapter(camel);
        driver.Travel(camelTransport);
    }
}

class Driver
{
    public void Travel(ITransport transport)
    {
        transport.Drive();
    }
}

interface ITransport
{
    void Drive();
}
class Auto implements ITransport
{
    public void Drive()
    {
        System.out.println("Машина едет врум врум");
    }
}

interface IAnimal
{
    void Move();
}
class Camel implements IAnimal
{
    public void Move()
    {
        System.out.println("Верблюд идет");
    }
}

class CamelToTransportAdapter implements ITransport
{
    Camel camel;
    public CamelToTransportAdapter(Camel c)
    {
        camel = c;
    }

    public void Drive()
    {
        camel.Move();
    }
}