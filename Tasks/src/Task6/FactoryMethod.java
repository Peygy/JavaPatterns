package Task6;

public class FactoryMethod
{
    public FactoryMethod()
    {
        Work();
    }

    private void Work()
    {
        Factory factory = new PanelFactory("Завод панельных домов");
        factory.BuildHouse();
        factory = new WoodFactory("Завод деревянных домов");
        factory.BuildHouse();
    }
}

// Фабрики
abstract class Factory
{
    public String Name;

    public Factory(String name)
    {
        Name = name;
    }

    abstract House BuildHouse();
}

class PanelFactory extends Factory
{
    public PanelFactory(String name)
    {
        super(name);
    }

    @Override
    House BuildHouse()
    {
        return new PanelHouse();
    }
}

class WoodFactory extends Factory
{
    public WoodFactory(String name)
    {
        super(name);
    }

    @Override
    House BuildHouse()
    {
        return new WoodHouse();
    }
}

// Виды домов
interface House { }

class PanelHouse implements House
{
    public PanelHouse()
    {
        System.out.println("Panel house!");
    }
}

class WoodHouse implements House
{
    public WoodHouse()
    {
        System.out.println("Wooden house!");
    }
}