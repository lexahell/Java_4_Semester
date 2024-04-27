package com.example.demo.service;

import com.example.demo.model.Departure;
import com.example.demo.model.PostOffice;
import com.example.demo.repository.PostOfficeRepository;
import com.example.demo.repository.DepartureRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.management.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;
import java.util.List;

@AllArgsConstructor
@Service
@ManagedResource(objectName = "com.example.demo.service:type=SchedulerService")
public class SchedulerService {
    private final DepartureRepository departureRepository;
    private final PostOfficeRepository postOfficeRepository;

    @ManagedOperation
    @Scheduled(cron = "0 */30 * * * *")
    public void doScheduledTask() throws IOException {
        List<Departure> departures = departureRepository.findAll();
        List<PostOffice> postOffices = postOfficeRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        File entities = new File("src/main/resources/entities");

        // Проверяем, существует ли каталог entities
        if (!entities.exists() || !entities.isDirectory()) {
            // Если каталог не существует, создаем его
            if (!entities.mkdirs()) {
                // Если не удалось создать каталог, выводим сообщение об ошибке
                System.err.println("Не удалось создать каталог entities");
                return;
            }
        }

        File[] files = entities.listFiles();
        // Проверяем, что массив файлов не равен null
        if (files != null) {
            // Удаляем все файлы в каталоге entities
            for (File f : files) {
                if (f.isFile()) {
                    f.delete();
                }
            }
        } else {
            // Если массив файлов равен null, выводим сообщение об ошибке
            System.err.println("Массив файлов равен null");
            return;
        }

        for (Departure i : departures) {
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("src/main/resources/entities/departure#" + i.getType() + ".json"),
                    StandardCharsets.UTF_8);
            writer.write(objectMapper.writeValueAsString(i));
            writer.close();
        }
        for (PostOffice i : postOffices) {
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("src/main/resources/entities/postOffice#" + i.getName() + ".json"),
                    StandardCharsets.UTF_8);
            writer.write(objectMapper.writeValueAsString(i));
            writer.close();
        }
    }

    @Scheduled(cron = "30 * * * * *")
    public void checkJMX() throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, MBeanException, IOException {
        MBeanServerConnection connection = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.example.demo.service:type=SchedulerService");

        connection.invoke(objectName, "doScheduledTask", null, null);
    }
}

