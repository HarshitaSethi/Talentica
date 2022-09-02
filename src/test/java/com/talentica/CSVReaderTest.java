/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.talentica;

import com.talentica.model.Product;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 *
 * @author harshita.sethi
 */
public class CSVReaderTest {

    @Nested
    class BasicCSVTest {

        @BeforeEach
        public void setUp() {
            File file = new File("test.csv");

            StringBuilder csvDataBuilder = new StringBuilder();

            csvDataBuilder.append("1, 4.00, teddy_bear").append("\n");
            csvDataBuilder.append("1, 8.00, baby_powder").append("\n");
            csvDataBuilder.append("2, 5.00, teddy_bear").append("\n");
            csvDataBuilder.append("2, 6.50, baby_powder").append("\n");

            try ( FileOutputStream outputStream = new FileOutputStream(file)) {
                outputStream.write(csvDataBuilder.toString().getBytes());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CSVReaderTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CSVReaderTest.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        @AfterEach
        public void tearDown() {
            File file = new File("test.csv");
            System.out.println("deleting file");
            file.delete();
        }

        /**
         * Test of getProductByStoreId method, of class CSVReader.
         */
        @Test
        public void testGetProductByStoreId() throws Exception {
            System.out.println("getProductByStoreId csv without empty lines");
            String filePath = "test.csv";
            CSVReader instance = new CSVReader();

            Map<Integer, List<Product>> result = instance.getProductByStoreId(filePath);

            assertTrue(result.get(1).size() == 2);
        }

    }

    @Nested
    class CSVWithEmptyLinesTest {

        @BeforeEach
        public void setUp() {
            File file = new File("test.csv");

            StringBuilder csvDataBuilder = new StringBuilder();

            csvDataBuilder.append("1, 4.00, teddy_bear").append("\n");
            csvDataBuilder.append("\n");
            csvDataBuilder.append("1, 8.00, baby_powder").append("\n");
            csvDataBuilder.append("\n");
            csvDataBuilder.append("2, 5.00, teddy_bear").append("\n");
            csvDataBuilder.append("\n");
            csvDataBuilder.append("2, 6.50, baby_powder").append("\n");

            try ( FileOutputStream outputStream = new FileOutputStream(file)) {
                outputStream.write(csvDataBuilder.toString().getBytes());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CSVReaderTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CSVReaderTest.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        @AfterEach
        public void tearDown() {
            File file = new File("test.csv");
            System.out.println("deleting file");
            file.delete();
        }

        /**
         * Test of getProductByStoreId method, of class CSVReader.
         */
        @Test
        public void testGetProductByStoreId() throws Exception {
            System.out.println("getProductByStoreId for csv with empty lines");
            String filePath = "test.csv";
            CSVReader instance = new CSVReader();

            Map<Integer, List<Product>> result = instance.getProductByStoreId(filePath);

            assertTrue(result.get(1).size() == 2);
        }

    }

}
