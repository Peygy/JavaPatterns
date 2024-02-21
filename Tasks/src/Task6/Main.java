package Task6;

public class Main
{
    public static void main(String[] args)
    {
        // «Фабричный метод»
        System.out.println("Паттерн «Фабричный метод»:");
        new FactoryMethod();
        System.out.println();

        // «Абстрактная фабрика»
        System.out.println("Паттерн «Абстрактная фабрика»:");
        new AbstractFactory();
        System.out.println();

        // «Строитель»
        System.out.println("Паттерн «Строитель»:");
        new Builder();
        System.out.println();

        // «Прототип»
        System.out.println("Паттерн «Прототип»:");
        new Prototype();
    }
}