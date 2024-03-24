package org.project.task10.components;

import org.project.task10.interfaces.SortingAlgorithm;
import org.springframework.stereotype.Component;

@Component()
public class MergeSort implements SortingAlgorithm
{
    @Override
    public void doSort()
    {
        System.out.println("Doing merge sort");
    }
}
