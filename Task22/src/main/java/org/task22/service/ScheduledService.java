package org.task22.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

@Service
@EnableScheduling
@AllArgsConstructor
public class ScheduledService
{
    private final GameService service;

    @Scheduled(cron = "0 * * * * *")
    public void task() throws IOException
    {
        String path = "D:\\Programming\\JavaPatterns\\Task22\\src\\main\\resources\\entities";
        System.out.println("Scheduled task");
        for (File myFile : Objects.requireNonNull(new File(path).listFiles()))
        {
            if (myFile.isFile()) myFile.delete();
        }

        File file = new File(path +"/Games.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(service.GetAllGame().toString());
        fileWriter.close();
    }
}
