/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.talentica;

import com.talentica.model.Product;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harshita.sethi
 */
public class Talentica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // If command line arguments are not given, using scanner to get input to the code
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter price csv name followed by the product names user wants to purchase");

            String input = scanner.nextLine();  // Read user input

            args = input.split(" ", -1);
        }

        String csvFile = args[0];

        List<String> productList = Arrays.asList(Arrays.copyOfRange(args, 1, args.length));

        Talentica talentica = new Talentica();
        try {
            String output = talentica.findShop(csvFile, productList);
            System.out.println("output => " + output);
        } catch (IOException ex) {
            Logger.getLogger(Talentica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Calls csv reader and shop finder 
     * @param csvFile
     * @param productList
     * @return desired code output
     * @throws IOException 
     */
    public String findShop(String csvFile, List<String> productList) throws IOException {
        CSVReader csv = new CSVReader();

        Map<Integer, List<Product>> productByStoreId = csv.getProductByStoreId(csvFile);

        ShopFinder shopFinder = new ShopFinder();

        String minPriceShop = shopFinder.findShop(productByStoreId, productList);

        return minPriceShop;
    }

}
