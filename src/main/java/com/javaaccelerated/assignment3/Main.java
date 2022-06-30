package com.javaaccelerated.assignment3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    Predicate<Integer> isZero = i -> i == 0;
    List<Integer> nlist = new ArrayList<>();

    public static void main(String[] args) {
        log.info("Inside main()");
        try {
            Main obj = new Main();
            String file = "src/main/resources/com/javaaccelerated/assignment3/file.txt";
            BufferedReader rd = new BufferedReader(new FileReader(file));
            obj.readFile(rd);
            obj.writeFile();
        } catch (Exception e) {
            log.info("Error at main()" + e.getMessage());
        }
    }

    private void readFile(BufferedReader read) {
        log.info("Inside readFile()");
        try {
            String line;
            while ((line = read.readLine()) != null)
               nlist.add(Integer.parseInt(line.trim()));
        } catch (Exception e) {
            log.info("Error at readFile()" + e.getMessage());
        }
    }

    private void writeFile(){
        log.info("inside writeFile()");
        try{
            Path path = Files.createTempFile(Path.of("src/main/resources/com/javaaccelerated/assignment3"), "out", ".txt");
            nlist.stream()
                    .filter(Predicate.not(isZero))
                    .forEach(i -> {
                        try {
                            i += 5;
                            Files.write(path, String.valueOf(i).getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, "\n".getBytes(), StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            log.info("Runtime Exception at writeFile()" + e.getMessage());
                        }
                    });
        }catch (Exception e){
            log.info("Exception at writeFile()" + e.getMessage());
        }
    }
}
