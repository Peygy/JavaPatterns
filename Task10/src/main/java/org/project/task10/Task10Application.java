package org.project.task10;

import org.project.task10.config.BeanConfig;
import org.project.task10.interfaces.SortingAlgorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Task10Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Task10Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        SortingAlgorithm bean = context.getBean("GetMergeSort", SortingAlgorithm.class);
        bean.doSort();
        bean = context.getBean("GetInsertionSort", SortingAlgorithm.class);
        bean.doSort();
        bean = context.getBean("GetQuickSort", SortingAlgorithm.class);
        bean.doSort();
    }
}
