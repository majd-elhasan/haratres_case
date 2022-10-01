package com.cyancube.haratres_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

@SpringBootApplication
public class HaratresTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaratresTestApplication.class, args);

        System.out.println("-----------------Merge String-------------------");
        System.out.println(MergeString.merge("hrte","aars"));

        System.out.println("----------------Nearest Numbers-----------------");
        System.out.println(Arrays.toString(NearNumbers.nearestNumbersOf(new int[]{ 32, 41, 12 , 15, 21, 32, 48, 35})));

        System.out.println("-----------------Purchase Cart------------------");
        int[] arr = {5, 6, 4, 3, 4,
                5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,
                5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,
                5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,5, 6, 4, 3, 4,
                5, 6, 4, 1999};
        PurchaseCart.print(PurchaseCart.getTotalPriceOfAndUndiscountedItems(arr));
    }
}
