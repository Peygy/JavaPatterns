package Task6;

public class Builder
{
    public Builder()
    {
        Work();
    }

    private void Work()
    {
        var baker = new Baker();
        var bread1 = baker.CreateBread(new RyeBreadBuilder());
        System.out.println(bread1);
        var bread2 = baker.CreateBread(new WheatBreadBuilder());
        System.out.println(bread2);
    }
}

// Для хлеба
class Flour
{
    public String FlourType;

    public Flour(String flourType)
    {
        FlourType = flourType;
    }
}
class Additive
{
    public String AdditiveName;

    public Additive(String additiveName)
    {
        AdditiveName = additiveName;
    }
}
class Salt
{
    public int saltCount;

    public Salt(int count)
    {
        saltCount = count;
    }
}

class Bread
{
    public String name;
    public Flour flour;
    public Additive additive;
    public Salt salt;

    @Override
    public String toString()
    {
        return "Хлеб " + name + " {" +
                "мука = " + flour.FlourType +
                ", добавки = " + additive.AdditiveName +
                ", соль = " + salt.saltCount + "}";
    }
}

// Получение хлеба
class Baker
{
    public Bread CreateBread(BreadBuilder builder)
    {
        builder.SetName();
        builder.SetFlour();
        builder.SetAdditive();
        builder.SetSalt();
        return builder.bread;
    }
}

abstract class BreadBuilder
{
    public Bread bread;

    public BreadBuilder()
    {
        bread = new Bread();
    }

    abstract void SetName();
    abstract void SetFlour();
    abstract void SetAdditive();
    abstract void SetSalt();
}

class RyeBreadBuilder extends BreadBuilder
{
    void SetName()
    {
        this.bread.name = "Ржаной";
    }
    void SetFlour()
    {
        this.bread.flour = new Flour("Ржанная мука 1 сорт");
    }
    void SetAdditive()
    {
        this.bread.additive = new Additive("Отсутствуют");
    }
    void SetSalt()
    {
        this.bread.salt = new Salt(4);
    }
}
class WheatBreadBuilder extends BreadBuilder
{
    void SetName()
    {
        this.bread.name = "Пшеничный";
    }
    void SetFlour()
    {
        this.bread.flour = new Flour("Пшеничная мука 1 сорт");
    }
    void SetAdditive()
    {
        this.bread.additive = new Additive("Улучшитель хлебопекарный");
    }
    void SetSalt()
    {
        this.bread.salt = new Salt(5);
    }
}