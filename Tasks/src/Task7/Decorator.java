package Task7;

public class Decorator
{
    public Decorator()
    {
        Pizza pizza1 = new ItalianPizza();
        pizza1 = new TomatoPizza(pizza1);
        System.out.println("Название: " + pizza1.Name);
        System.out.println("Стоимость: " + pizza1.GetCost());

        pizza1 = new BulgerianPizza();
        pizza1 = new CheesePizza(pizza1);
        System.out.println("Название: " + pizza1.Name);
        System.out.println("Стоимость: " + pizza1.GetCost());
    }
}

abstract class Pizza
{
    public String Name;
    public Pizza(String name)
    {
        Name = name;
    }

    abstract int GetCost();
}
class ItalianPizza extends Pizza
{
    public ItalianPizza()
    {
        super("Итальянская пицца");
    }

    @Override
    int GetCost()
    {
        return 5;
    }
}
class BulgerianPizza extends Pizza
{
    public BulgerianPizza()
    {
        super("Болгарская пицца");
    }

    @Override
    int GetCost()
    {
        return 10;
    }
}


abstract class PizzaDecorator extends Pizza
{
    protected Pizza PizzaModel;
    public PizzaDecorator(String name, Pizza PizzaModel)
    {
        super(name);
        this.PizzaModel = PizzaModel;
    }
}
class TomatoPizza extends PizzaDecorator
{
    public TomatoPizza(Pizza pizza)
    {
        super(pizza.Name + " с помидорами", pizza);
    }

    @Override
    int GetCost()
    {
        return PizzaModel.GetCost() + 5;
    }
}
class CheesePizza extends PizzaDecorator
{
    public CheesePizza(Pizza pizza)
    {
        super(pizza.Name + " с сыром", pizza);
    }

    @Override
    int GetCost()
    {
        return PizzaModel.GetCost() + 10;
    }
}