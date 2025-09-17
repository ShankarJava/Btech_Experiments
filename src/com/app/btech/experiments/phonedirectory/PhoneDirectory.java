package com.app.btech.experiments.phonedirectory;

import java.io.*;
import java.util.*;

public class PhoneDirectory {
    public static void main(String[] args) {
        // Two hash tables for quick lookup
        Hashtable<String, String> nameToPhone = new Hashtable<>();
        Hashtable<String, String> phoneToName = new Hashtable<>();

        // Load file
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\KLR\\Experiments\\src\\com\\app\\btech\\experiments\\phonedirectory\\PhoneBook.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t"); // split on tab
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String phone = parts[1].trim();
                    nameToPhone.put(name, phone);
                    phoneToName.put(phone, name);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // User input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a name or phone number: ");
        String input = sc.nextLine().trim();

        // Lookup
        if (nameToPhone.containsKey(input)) {
            System.out.println("Phone number of " + input + " is: " + nameToPhone.get(input));
        } else if (phoneToName.containsKey(input)) {
            System.out.println("Name with phone number " + input + " is: " + phoneToName.get(input));
        } else {
            System.out.println("Record not found.");
        }

        sc.close();
    }
}

