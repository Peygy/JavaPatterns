package Task6;

public class AbstractFactory
{
    public AbstractFactory()
    {
        Work();
    }

    private void Work()
    {
        var hero1 = new Hero(new ElfFactory());
        var hero2 = new Hero(new TankFactory());
        hero1.Attack();
        hero2.Attack();
    }
}

// Оружие
abstract class Weapon
{
    abstract void Hit();
}
class Sword extends Weapon
{
    public void Hit()
    {
        System.out.println("Удар мечом!");
    }
}
class Bow extends Weapon
{
    public void Hit()
    {
        System.out.println("Выстрел из лука!");
    }
}

// Герой
class Hero
{
    private Weapon HeroWeapon;

    public Hero(HeroFactory factory)
    {
        HeroWeapon = factory.CreateWeapon();
    }

    public void Attack()
    {
        HeroWeapon.Hit();
    }
}

// Фабрики
abstract class HeroFactory
{
    abstract Weapon CreateWeapon();
}
class TankFactory extends HeroFactory
{
    public Weapon CreateWeapon()
    {
        return new Sword();
    }
}
class ElfFactory extends HeroFactory
{
    public Weapon CreateWeapon()
    {
        return new Bow();
    }
}