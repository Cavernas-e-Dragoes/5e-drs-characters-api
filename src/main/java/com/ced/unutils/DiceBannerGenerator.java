package com.ced.unutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

public class DiceBannerGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiceBannerGenerator.class);

    public static void generateBanner() {
        Random random = new Random();
        int diceType = random.nextInt(3);
        int randomNumber;
        String bannerContent;

        switch (diceType) {
            case 0 -> {
                randomNumber = random.nextInt(4) + 1;
                bannerContent = generateDice4(randomNumber);
            }
            case 1 -> {
                randomNumber = random.nextInt(6) + 1;
                bannerContent = generateDice6(randomNumber);
            }
            case 2 -> {
                randomNumber = random.nextInt(20) + 1;
                bannerContent = generateDice20(randomNumber);
            }
            default -> throw new IllegalStateException("Invalid Type.");
        }

        String filePath = Paths.get("src/main/resources/banner.txt").toAbsolutePath().toString();

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(bannerContent);
            LOGGER.info("Banner generated");
        } catch (IOException e) {
            LOGGER.error("Error to generate the dice:{}", e.getMessage());
        }
    }

    private static String generateDice4(int number) {
        return """
                          ;;;;;;
                        ,;      ;,
                       ,;        ;,
                      ,;          ;,
                     ,;     %d      ;,
                    ,;              ;,
                   ,;                ;,
                   ::::::::::::::::::::
                """.formatted(number);
    }

    private static String generateDice6(int number) {
        return """
                     ::::::::::::::
                     ::          ::
                     ::    %d     ::
                     ::          ::
                     ::::::::::::::
                """.formatted(number);
    }

    private static String generateDice20(int number) {
        return """
                           ,:::,
                      ,,,:;   ;:,,, 
                  ,,,:       :      :,,, 
                ,;.....................;,,
                ; ;                   ; ;
                ;  ;       %2d        ;  ;
                ; ;...................; ;
                  ''';             ;'''
                      ''':;;   ;;:'''
                          ':::' 
                """.formatted(number);
    }
}
