package Task8;

public class Shablon
{
    public Shablon()
    {
        var school = new School();
        var university = new University();

        school.Learn();
        university.Learn();
    }
}

abstract class Education
{
    void Learn()
    {
        Enter();
        DoHomework();
        Study();
    }

    abstract void Enter();
    abstract void DoHomework();
    abstract void Study();
}
class School extends Education
{
    void Enter()
    {
        System.out.println("Идем в первый класс");
    }
    void DoHomework()
    {
        System.out.println("Делаем домашку");
    }
    void Study()
    {
        System.out.println("Посещаем уроки");
    }
}
class University extends Education
{
    void Enter()
    {
        System.out.println("Поступаем на первый курс");
    }
    void DoHomework()
    {
        System.out.println("Делаем домашку (нуу такое)");
    }
    void Study()
    {
        System.out.println("Посещаем практики");
        System.out.println("Посещаем лекции (как получится)");
    }
}