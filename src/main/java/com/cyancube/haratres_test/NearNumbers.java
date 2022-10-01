package com.cyancube.haratres_test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class NearNumbers {
    /*
    	Yakın Numaralar Problemi
Dışardan parametre olarak integer sayılardan oluşan bir array alacağız. Bu array içerisindeki mutlak olarak en yakın sayıları tespit etmemiz ve sıralı şekilde yazdırmamız gerekiyor farkımız 0 dan büyük olmalı. Örneğin: Parametre olarak A= { 3, 1, 5, 23, 2, 4, 9, 10, 15, 31 }  min fark = |2-1| = 1 veya |5-4| = 1 demek oluyor bizim arrayimizdeki yakınlık seviyemiz minum 1 o zaman uygulamamızın çıktısı şu şekilde olmalı

1 2
2 3
3 4
4 5
9 10

Eğer listemiz B = { 32, 41, 12 , 15, 21, 32, 48, 35} şekilde olsaydı mutlak en küçük farkımız: |12 - 15| = 3

Çıktımız: String array olarak : D = {"12 15", "32 35"} şeklinde olmalı.

Kısıtlar: Arrayimizin boyu  1 < n < 1000    arrayimizin elemanları ise -20.000 < i < 20.000

Kısıtlara uymayan durumlarda system exception throw etmeli.

     */
    public static String[] nearestNumbersOf(int[] nums){
       validate(nums);
        int minDiff=Integer.MAX_VALUE;
        int[] sortedNums = stream(nums).sorted().toArray();
        for (int i=0; i<sortedNums.length-1; i++){
            int diff = Math.abs(sortedNums[i] - sortedNums[i+1]);
            if (diff != 0 && minDiff> diff)
                minDiff = diff;
            }
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0 ; i < sortedNums.length-1;i++){
            if (Math.abs(sortedNums[i]- sortedNums[i+1] )== minDiff){
                map.put(sortedNums[i],sortedNums[i+1]);
            }
        }
        String[] result = new String[map.size()];
        int counter = 0;
        for (Integer k:map.keySet().stream().sorted().toList()){
            result[counter] = k+" "+ map.get(k);
            counter++;
        }
        return result;
    }
    static void validate(int[] nums){
        if(nums.length <= 1)
            throw new IllegalArgumentException("array'in boyu 1'den büyük olmalı");
        if(nums.length >=1000)
            throw new IllegalArgumentException("array'in boyu 1000'den küçük olmalı");
        for (int num :nums) {
            if(num>=20_000)
                throw new IllegalArgumentException("sayılar 20_000'den küçük olmalı");
            if(num<=-20_000)
                throw new IllegalArgumentException("sayılar -20_000'den büyük olmalı");
        }
    }
}
