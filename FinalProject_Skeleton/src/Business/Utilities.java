/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.List;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author shaoy
 */
public class Utilities {

    public static boolean checkDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid double.", "WARNING", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public static boolean checkAge(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid age.", "WARNING", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public static boolean isPwdValid(String input) {
        Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{2,}$");
        Matcher m = p.matcher(input);
        if (!m.matches()) {
            JOptionPane.showMessageDialog(null, "Password needs to at least 2 characters and contain at least one letter, one number.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return m.matches();
    }

    
    
    public static boolean isNameValid(String input) {
        Pattern p = Pattern.compile("[a-zA-Z0-9]{2,}");
        Matcher m = p.matcher(input);
        if (!m.matches()) {
            JOptionPane.showMessageDialog(null, "Name fields shall be at least 2 chars.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return m.matches();
    }

    public static String nameReformat(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static boolean isPhoneValid(String input) {
        //xxxxxxxxxx or xxx-xxx-xxxx or (xxx)xxx-xxxx or (xxx)xxxxxxx
        Pattern p = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
        Matcher m = p.matcher(input);
        if (!m.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid phone number.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return m.matches();
    }

    public static String encryptString(String input) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            result = Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
        }
        return result;
    }

    public static Date getToday() {
        Date date = new Date();
        return date;
    }

    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }

    public static Date stringToDate(String inputDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return sdf.parse(inputDate);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter valid date.", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public static String fullNameReformat(String input) {
        String[] str = input.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length; i++) {
            sb.append(Character.toUpperCase(str[i].charAt(0))).append(str[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public static String randomName() {
        Random r = new Random(); // just create one and keep it around
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        String randomName = sb.toString();
        return randomName;
    }

//    public static Map<SalesPerson, Double> sortMap(Map<SalesPerson, Double> unsortMap, int i) {
//
//        List<Entry<SalesPerson, Double>> list = new LinkedList<Entry<SalesPerson, Double>>(unsortMap.entrySet());
//
//        Collections.sort(list, new Comparator<Entry<SalesPerson, Double>>() {
//            @Override
//            public int compare(Entry<SalesPerson, Double> o1, Entry<SalesPerson, Double> o2) {
//                if(i==0){
//                    return o2.getValue().compareTo(o1.getValue());
//                }else{
//                    return o1.getValue().compareTo(o2.getValue());
//                }
//                
//            }
//        });
//
//        // Maintaining insertion order with the help of LinkedList
//        Map<SalesPerson, Double> sortedMap = new LinkedHashMap<SalesPerson, Double>();
//        for (Entry<SalesPerson, Double> entry : list) {
//            sortedMap.put(entry.getKey(), entry.getValue());
//        }
//
//        return sortedMap;
//    }
//    
//    public static Map<Product, Double> sortMapP(Map<Product, Double> unsortMap) {
//
//        List<Entry<Product, Double>> list = new LinkedList<Entry<Product, Double>>(unsortMap.entrySet());
//
//        Collections.sort(list, new Comparator<Entry<Product, Double>>() {
//            @Override
//            public int compare(Entry<Product, Double> o1, Entry<Product, Double> o2) {
//                    return o2.getValue().compareTo(o1.getValue());
//              
//            }
//        });
//
//        // Maintaining insertion order with the help of LinkedList
//        Map<Product, Double> sortedMap = new LinkedHashMap<Product, Double>();
//        for (Entry<Product, Double> entry : list) {
//            sortedMap.put(entry.getKey(), entry.getValue());
//        }
//
//        return sortedMap;
//    }
}
