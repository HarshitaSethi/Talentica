/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.talentica;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author harshita.sethi
 */
public class TalenticaTest {

    @Before
    public void setUp() {
        System.out.println("creating test file");

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

    @After
    public void tearDown() {
        File file = new File("test.csv");
        System.out.println("deleting file");
        file.delete();
    }

    /**
     * Test of main method, of class Talentica.
     */
    @Test
    public void testMainWithScanner() throws Exception {
        System.out.println("main");

        String input = "test.csv teddy_bear baby_powder";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String[] args = new String[0];
        Talentica.main(args);

        Talentica talentica = mock(Talentica.class);
        when(talentica.findShop(Mockito.anyString(), Mockito.anyList())).thenReturn("2, 11.5");

        System.setIn(sysInBackup);

    }

    /**
     * Test of main method, of class Talentica.
     */
    @Test
    public void testMainWithArgs() throws Exception {
        System.out.println("main");

        String input = "test.csv teddy_bear baby_powder";

        String[] args = input.split(" ");
        Talentica.main(args);

        Talentica talentica = mock(Talentica.class);
        when(talentica.findShop(Mockito.anyString(), Mockito.anyList())).thenReturn("2, 11.5");

    }

    /**
     * Test of main method, of class Talentica.
     */
    @Test
    public void testFindShop() throws Exception {
        System.out.println("main");

        String input = "test.csv";
        List<String> productList = Arrays.asList("teddy_bear", "baby_powder");

        String[] args = input.split(" ");
        Talentica.main(args);

        Talentica talentica = new Talentica();
        String result = talentica.findShop(input, productList);

        Assert.assertEquals("2, 11.5", result);

    }

}
