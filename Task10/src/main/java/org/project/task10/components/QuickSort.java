package org.project.task10.components;

import org.project.task10.interfaces.SortingAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class QuickSort implements SortingAlgorithm
{
    @Override
    public void doSort()
    {
        System.out.println("Doing quick sort");
    }
}
