package Task1;

import java.util.Comparator;

public class Main
{
    public static void main(String[] args)
    {
        Comparator<Object[]> comparator = (arr1, arr2) -> arr1.length - arr2.length;
        var newArr1 = new Integer[] {1, 2, 4, 7};
        var newArr2 = new Integer[] {2, 3, 4};
        System.out.println(comparator.compare(newArr1, newArr2));
    }
}