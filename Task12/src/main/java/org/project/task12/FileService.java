package org.project.task12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import java.io.*;

@Service
public class FileService
{
    String file1 = "D:\\Programming\\JavaPatterns\\Task12\\File1.txt";
    String file2 = "D:\\Programming\\JavaPatterns\\Task12\\File2.txt";

    @PostConstruct
    public void PostConstruct() throws IOException
    {
        var bufferedWriter = new BufferedWriter(new FileWriter(file2));

        if (new File(file1).exists())
        {
            var bufferedReader = new BufferedReader(new FileReader(file1));
            var strBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                strBuilder.append(line);
            }
            bufferedWriter.write(String.valueOf(strBuilder.hashCode()));
            System.out.println("Text from 1 hashing to 2");
            bufferedReader.close();
        }
        else
        {
            System.out.println("First file does not exist");
            bufferedWriter.write("null");
        }

        bufferedWriter.close();
    }

    @PreDestroy
    public void PreDestroy()
    {
        if(new File(file1).delete())
        {
            System.out.println("File 1 - removed");
        }
    }
}
