package com.example.taxidispatcher.util;

import android.content.Context;

import com.example.taxidispatcher.R;
import com.example.taxidispatcher.model.Street;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StreetUtil {

    private static Map<Integer, List<Street>> mapOfStreets = new HashMap<>();
    private static List<Integer> listOfIds =
            Arrays.asList(
                    R.raw.letter_1,  //A
                    R.raw.letter_2,  //B
                    R.raw.letter_3,  //C
                    R.raw.letter_4,  //Č-
                    R.raw.letter_5,  //Ć-
                    R.raw.letter_6,  //D
                    R.raw.letter_7,  //Dž-
                    R.raw.letter_8,  //Đ
                    R.raw.letter_9,  //E
                    R.raw.letter_10, //F
                    R.raw.letter_11, //G
                    R.raw.letter_12, //H
                    R.raw.letter_13, //I
                    R.raw.letter_14, //J
                    R.raw.letter_15, //K
                    R.raw.letter_16, //L
                    R.raw.letter_17, //Lj
                    R.raw.letter_18, //M
                    R.raw.letter_19, //N
                    R.raw.letter_20, //Nj
                    R.raw.letter_21, //O
                    R.raw.letter_22, //P
                    R.raw.letter_23, //R
                    R.raw.letter_24, //S
                    R.raw.letter_25, //Š
                    R.raw.letter_26, //T
                    R.raw.letter_27, //U
                    R.raw.letter_28, //V
                    R.raw.letter_29, //Z
                    R.raw.letter_30  //Ž
            );

    public static void readFiles(Context context) {
        for (int i = 0; i < listOfIds.size(); i++) {
            Integer id = listOfIds.get(i);
            List<Street> streetList = new LinkedList<>();
            try(InputStream is = context.getResources().openRawResource(id);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
                for(CSVRecord record : csvParser) {
                    String name = record.get("Street");
                    String option1 = record.get("Option1");
                    String option2 = record.get("Option2");
                    String option3 = record.get("Option3");
                    Street street = new Street(name, option1, option2, option3);
                    streetList.add(street);
                }
                mapOfStreets.put(id, streetList);
            }
            catch(Exception ex) {
                System.out.println("Baca se izuzetak");
            }
        }
    }

    public static List<Street> getStreetForLetter(String letter) {
        Integer id = mapLetterToId(letter);
        return mapOfStreets.get(id);
    }

    private static Integer mapLetterToId(String letter) {
        switch (letter) {
            case "A":
                return R.raw.letter_1;
            case "B":
                return R.raw.letter_2;
            case "C":
                return R.raw.letter_3;
            case "Č":
                return R.raw.letter_4;
            case "Ć":
                return R.raw.letter_5;
            case "D":
                return R.raw.letter_6;
            case "Dž":
                return R.raw.letter_7;
            case "Đ":
                return R.raw.letter_8;
            case "E":
                return R.raw.letter_9;
            case "F":
                return R.raw.letter_10;
            case "G":
                return R.raw.letter_11;
            case "H":
                return R.raw.letter_12;
            case "I":
                return R.raw.letter_13;
            case "J":
                return R.raw.letter_14;
            case "K":
                return R.raw.letter_15;
            case "L":
                return R.raw.letter_16;
            case "Lj":
                return R.raw.letter_17;
            case "M":
                return R.raw.letter_18;
            case "N":
                return R.raw.letter_19;
            case "Nj":
                return R.raw.letter_20;
            case "O":
                return R.raw.letter_21;
            case "P":
                return R.raw.letter_22;
            case "R":
                return R.raw.letter_23;
            case "S":
                return R.raw.letter_24;
            case "Š":
                return R.raw.letter_25;
            case "T":
                return R.raw.letter_26;
            case "U":
                return R.raw.letter_27;
            case "V":
                return R.raw.letter_28;
            case "Z":
                return R.raw.letter_29;
            case "Ž":
                return R.raw.letter_30;
            default:
                throw new IllegalArgumentException("Error in method mapLetterToId");
        }
    }
}
