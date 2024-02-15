package Task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Main
{
    public static void main(String[] args)
    {
        var list = new ArrayList<Human>();
        list.add(new Human(18, "Alex", "Alexandrov", LocalDate.of(2005, 7, 1), 60));
        list.add(new Human(19, "Sveta", "Oblakova", LocalDate.of(2004, 7, 1), 55));
        list.add(new Human(20, "Lesha", "Terekov", LocalDate.of(2003, 7, 1), 50));
        list.add(new Human(21, "Timur", "Ivanov", LocalDate.of(2002, 7, 1), 45));
        list.add(new Human(22, "Denis", "Petrov", LocalDate.of(2001, 7, 1), 40));
        list.add(new Human(23, "Nastya", "Sidorova", LocalDate.of(2000, 7, 1), 35));

        var stream = list.stream();
        var av = stream.filter(human -> human.age > 20)
                .sorted(new HumanComparator())
                .peek(human -> human.age += 3)
                .mapToInt(Human::getAge).average();

        System.out.println(av);
    }
}

class HumanComparator implements Comparator<Human>
{
    @Override
    public int compare(Human x1, Human x2) {
        return x1.firstName.substring(x1.firstName.length() - 1)
                .compareTo(x2.firstName.substring(x2.firstName.length() - 1));
    }
}