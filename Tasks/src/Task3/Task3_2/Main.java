package Task3.Task3_2;

import java.util.HashMap;

public class Main
{
    public static HashMap<String, Integer> synchronizedMap = new HashMap<>();
    public static int iterator = 0;

    public static void main(String[] args)
    {
        // Map с использованием ключевого слова synchronized
        for (int i = 1; i < 5; i++)
        {
            var t = new Thread(() -> {
                synchronized (synchronizedMap) {
                    for (int j = iterator; j < iterator + 4; j++)
                    {
                        synchronizedMap.put("key" + j, j);
                        System.out.println(Thread.currentThread().getName() + " " + j);
                    }
                    iterator+=4;
                }
            });
            t.setName("Thread" + i);
            t.start();
        }
    }
}
