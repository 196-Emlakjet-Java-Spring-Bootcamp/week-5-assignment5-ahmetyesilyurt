package com.ysl.rabbitmq.utility;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class AdvertisementGenerator {
    private static Random rand;
    static final String[] titleList1 = new String[]{"Satilik", "Kiralik", "Temiz", "Doktordan", "Ihtiyactan"};
    static final String[] titleList2 = new String[]{"Ev", "Araba", "Villa", "Arsa"};
    static final String[] descriptionList = new String[]{"Ihtiyactan satilik", "Asansorlu", "Kombili", "Fiber altyapisi var", "Guven emlak", "Aktas emlak", "Kalite bizim isimiz"};
    static {
        try {
            rand = rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String generateTitle() {
        String title1 = titleList1[rand.nextInt(titleList1.length)];
        String title2 = titleList2[rand.nextInt(titleList2.length)];
        return title1 + " " + title2;
    }
    public static String generateDescription() {
        return descriptionList[rand.nextInt(descriptionList.length)] + " " + descriptionList[rand.nextInt(descriptionList.length)];
    }




}
