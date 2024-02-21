package Task5;

public class Main
{
    public static void main(String[] args)
    {
        // Реализовать паттерн Singleton как минимум 3-мя способами
        System.out.println(Singleton1.getInstance());
        System.out.println(Singleton2.getInstance());
        for (int i = 1; i < 4; i++)
        {
            var t = new Thread(() -> {
                System.out.println(Singleton3.getInstance() + " " + Thread.currentThread().getName());
            });
            t.setName("Поток " + i);
            t.start();
        }
    }
}

// Прстой пример
class Singleton1
{
    private static final Singleton1 Instance = new Singleton1();

    private Singleton1() { }

    public static Singleton1 getInstance()
    {
        return Instance;
    }
}

// Ленивая инициализация
class Singleton2
{
    private static Singleton2 Instance;

    private Singleton2() { }

    public static Singleton2 getInstance()
    {
        if (Instance == null)
        {
            Instance = new Singleton2();
        }
        return Instance;
    }
}

// Потокобезопасный
class Singleton3
{
    private Singleton3() { }

    private static final class InstanceHolder
    {
        private static final Singleton3 Instance = new Singleton3();
    }

    public static synchronized Singleton3 getInstance()
    {
        return InstanceHolder.Instance;
    }
}