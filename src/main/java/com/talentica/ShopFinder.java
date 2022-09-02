/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.talentica;

import com.talentica.model.Product;
import com.talentica.model.Shop;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Finds the sop to purchase the desired products at minimum price
 *
 * @author harshita.sethi
 */
public class ShopFinder {

    /**
     * Find the shop which is having all the desired products and then comparing
     * their product cost to get most optimized cost
     *
     * @param productMap
     * @param productList
     * @return shop id and price, if no shop found returns none
     */
    public String findShop(Map<Integer, List<Product>> productMap, List<String> productList) {

        Optional<Shop> min = productMap.entrySet().stream().filter((e) -> { // Filtering ony those shops which have all the needful products
            List<String> listOfProducts = getListOfProducts(e.getValue());
            return listOfProducts.containsAll(productList);
        }).map((e) -> { // Creating shop object contains shop id and the total price for the desired products
            Shop shop = new Shop();
            Double totalProductPrice = e.getValue().stream()
                    .filter(p -> p.getBundledProduct().stream().anyMatch(productList::contains))
                    .map(p -> p.getProductPrice()).reduce(0.0, Double::sum);

            shop.setStoreID(e.getKey());
            shop.setTotalProductPrice(totalProductPrice);
            return shop;
        }).min((s1, s2) -> Double.compare(s1.getTotalProductPrice(), s2.getTotalProductPrice())); // finding shop with minimum price

        if (min.isPresent()) {
            return min.get().toString();
        } else { // return none if optional is empty
            return "none";
        }
    }

    /**
     * Converts List<Product> to List<String>
     * @param list
     * @return
     */
    public List<String> getListOfProducts(List<Product> list) {
        return list.stream().map(p -> p.getBundledProduct()).flatMap(l -> l.stream()).collect(Collectors.toList());
    }
}
