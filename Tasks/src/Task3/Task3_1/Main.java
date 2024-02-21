package Task3.Task3_1;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main
{
    public static void main(String[] args)
    {
        // List с использованием Semaphore
        var semaphore = new Semaphore(1);
        var list = new ArrayList<Integer>();

        var writer1 = new Thread(() -> {
            try
            {
                semaphore.acquire();
                list.add(1);
                list.add(2);
                list.add(3);
                list.add(4);
                System.out.println("Список 1 " + list);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            finally
            {
                semaphore.release();
            }
        });

        var writer2 = new Thread(() -> {
            try
            {
                semaphore.acquire();
                list.add(5);
                list.add(6);
                list.add(7);
                list.add(8);
                System.out.println("Список 2 " + list);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            finally
            {
                semaphore.release();
            }
        });

        writer1.start();
        writer2.start();
    }
}
