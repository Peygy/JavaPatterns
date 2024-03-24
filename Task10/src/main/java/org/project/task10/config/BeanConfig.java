package org.project.task10.config;

import org.project.task10.components.*;
import org.project.task10.interfaces.SortingAlgorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeanConfig
{
    @Bean
    public SortingAlgorithm GetMergeSort()
    {
        return new MergeSort();
    }

    @Bean
    public InsertionSort GetInsertionSort()
    {
        return new InsertionSort();
    }

    @Bean
    public QuickSort GetQuickSort()
    {
        return new QuickSort();
    }
}
