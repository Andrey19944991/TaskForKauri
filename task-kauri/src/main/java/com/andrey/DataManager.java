package com.andrey;

import java.util.LinkedList;
import java.util.List;

public class DataManager {

    public List<String> encodeData(long num) {

        List<String> list = new LinkedList<>();
        String ourNumber = Long.toBinaryString(num);
        long intPart = num/128;
        if (intPart == 0) {
            list.add(addCorrectBeginning(ourNumber, intPart));
        } else {
            for (long i =  intPart; i > 0; i--) {
                list.add(addCorrectBeginning(ourNumber, i));
            }
            int index = ourNumber.indexOf("1", ourNumber.length() - 7);
            list.add(addCorrectBeginning(ourNumber.substring(index),0));
        }
        return list;
    }

    public long decodeData(List<String> list) {
        int count = list.size();
        return (count - 1) * 128 + Long.parseLong(list.get(count - 1), 2);
    }

    public String addCorrectBeginning(String str, long intPart) {
        StringBuilder stringBuilder;
        if (intPart == 0) {
            stringBuilder = new StringBuilder("0");
            int count = 8 - str.length();
            for (int i = 0; i < count - 1; i++) {
                stringBuilder.append("0");
            }
            stringBuilder.append(str);
        } else {
            stringBuilder = new StringBuilder("1");
            int count = 8 - Long.toBinaryString(intPart).length();
            for (int i = 0; i < count - 1; i++) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Long.toBinaryString(intPart));
        }

        return String.valueOf(stringBuilder);
    }

}

