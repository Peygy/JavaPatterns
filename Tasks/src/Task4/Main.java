package Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main
{
    public static void main(String[] args)
    {
        // Пример использования
        CustomExecutorService executorService = new CustomExecutorService(5);

        for (int i = 1; i < 6; i++)
        {
            final int taskNumber = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskNumber + " executed by thread " + Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }
}

class CustomExecutorService
{
    private final List<WorkerThread> threads;
    private final BlockingQueue<Runnable> taskQueue;

    public CustomExecutorService(int threadPoolSize)
    {
        this.threads = new ArrayList<>(threadPoolSize);
        this.taskQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < threadPoolSize; i++)
        {
            WorkerThread workerThread = new WorkerThread();
            threads.add(workerThread);
            workerThread.start();
        }
    }

    public void submit(Runnable task)
    {
        try
        {
            taskQueue.put(task);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown()
    {
        for (WorkerThread workerThread : threads)
        {
            workerThread.interrupt();
        }
    }

    private class WorkerThread extends Thread
    {
        @Override
        public void run()
        {
            while (!Thread.currentThread().isInterrupted())
            {
                try
                {
                    Runnable task = taskQueue.take();
                    task.run();
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
