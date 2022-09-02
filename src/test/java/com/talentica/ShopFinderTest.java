/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.talentica;

import com.talentica.model.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author harshita.sethi
 */
public class ShopFinderTest {

    private Map<Integer, List<Product>> productMap;
    List<Product> productList;

    @Before
    public void setUp() {
        productMap = new HashMap<>();
        productList = new ArrayList<>();

        productList.add(new Product(1, 6.5, Arrays.asList("teddy_bear", "baby_powder")));
        productList.add(new Product(1, 3.5, Arrays.asList("bath_towel")));

        productMap.put(1, productList);
        productList = new ArrayList<>();

        productList.add(new Product(2, 6.5, Arrays.asList("teddy_bear")));
        productList.add(new Product(2, 4.5, Arrays.asList("baby_powder")));
        productList.add(new Product(2, 4.0, Arrays.asList("bath_towel")));
        productMap.put(2, productList);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findShop method, of class ShopFinder.
     */
    @Test
    public void testFindShopWithSingleProduct() {
        System.out.println("testFindShopWithSingleProduct");
        List<String> desiredProductList = Arrays.asList("bath_towel", "baby_powder");
        ShopFinder instance = new ShopFinder();
        String result = instance.findShop(productMap, desiredProductList);

        String expResult = "2, 8.5";
        assertEquals(expResult, result);
    }

    /**
     * Test of findShop method, of class ShopFinder.
     */
    @Test
    public void testFindShopWithBundledProduct() {
        System.out.println("testFindShopWithBundledProduct");
        List<String> desiredProductList = Arrays.asList("teddy_bear", "baby_powder");
        ShopFinder instance = new ShopFinder();
        String result = instance.findShop(productMap, desiredProductList);

        String expResult = "1, 6.5";
        assertEquals(expResult, result);
    }

    /**
     * Test of findShop method, of class ShopFinder.
     */
    @Test
    public void testFindShopWhenProductNotFound() {
        System.out.println("testFindShopWhenProductNotFound");
        List<String> desiredProductList = Arrays.asList("scissor", "baby_powder");
        ShopFinder instance = new ShopFinder();
        String result = instance.findShop(productMap, desiredProductList);

        String expResult = "none";
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfProducts method, of class ShopFinder.
     */
    @Test
    public void testGetListOfProducts() {
        System.out.println("getListOfProducts");
        List<String> expResult = Arrays.asList("teddy_bear", "baby_powder", "bath_towel");

        ShopFinder instance = new ShopFinder();
        List<String> result = instance.getListOfProducts(productList);
        assertTrue(result.size() == expResult.size());
        assertTrue(result.containsAll(expResult));
    }

}
