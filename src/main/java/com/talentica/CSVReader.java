/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.talentica;

import com.talentica.model.Product;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Reads input CSV
 *
 * @author harshita.sethi
 */
public class CSVReader {

    /**
     * Reads input csv and generates a map containing list of products grouped
     * by the store id
     *
     * @param filePath
     * @return map containing list of products grouped by the store id
     * @throws IOException
     */
    public Map<Integer, List<Product>> getProductByStoreId(String filePath) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(filePath));

        Map<Integer, List<Product>> map = lines
                .filter(line -> !line.trim().isEmpty()) // skip empty lines
                .map((line) -> { // convert line to a product object
                    line = line.replace(" ", "").trim();
                    String[] data = line.split(",");

                    Product product = new Product();
                    product.setStoreId(Integer.parseInt(data[0].trim()));
                    product.setProductPrice(Double.parseDouble(data[1].trim()));
                    product.setBundledProduct(Arrays.asList(Arrays.copyOfRange(data, 2, data.length)));

                    return product;
                })
                .collect(Collectors.groupingBy(p -> p.getStoreId())); // group all products by store id

        return map;
    }

}
