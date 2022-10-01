package com.cyancube.haratres_test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class PurchaseCart {
    /*
    	Alışveriş Sepeti
Dışardan parametere olarak integer bir array alınacak. Bu araydeki her bir değer sepetimizdeki ürünleri ifade ediyor. Eğer sepetimdeki üründen sonraki gelen ürünün fiyatı daha düşük ise o ürünün fiyatı kadar indirim uygulanacaktır.

Örneğin A = {5, 6, 4, 3, 4 }  2. ürün birinci üründen büyük olduğu için birinci ürüne indirim uygulanmaz ama 3. ürün 2. üründen ucuz olduğu için 2. ürüne 4 lira indirim uygulanır. Aynı şekilde 4. ürün 3. üründen ucuz olduğu için 3 lira indirim uygulanır. Yani sepetimizdeki ürünlerin indirim uygulandıktan sonraki fiyatları şu şekilde olur: B = { 5, 2, 1, 3, 4 }

Sonuçlara sizlerden istenen
a.	Sepetimizin son tutarının hesaplanması.
b.	Sepetimizde indirim uygulanmayan elamanların küçükte büyüğe yazdırılması.

Örnek çıktı: Toplam tutar: 15,  İndirim yapılmayan kalemler, C = {3, 4, 5}

Kısıtlar: Arrayimizin boyu  1 < n < 100    arrayimizin elemanları ise 0 < i < 2.000

Kısıtlara uymayan durumlarda system exception throw etmeli.
     */
    public static void print(TreeMap<Integer,Integer[]> map){
        System.out.printf("Toplam tutar: %d,  İndirim yapılmayan kalemler, %s",map.firstKey(), Arrays.toString(map.get(map.firstKey())));
    }
    public static TreeMap<Integer,Integer[]> getTotalPriceOfAndUndiscountedItems(int[] nums){
        validate(nums);
        List<Integer> unChangedValues = new ArrayList<>();
         for (int i= 0 ; i< nums.length-1 ;i++){
             if (nums[i] > nums[i + 1]){
                 nums[i] -= nums[i+1];
             }
             else unChangedValues.add(nums[i]);
         }
         unChangedValues.add(nums[nums.length-1]);
        unChangedValues = unChangedValues.stream().sorted().collect(Collectors.toList());

        TreeMap<Integer,Integer[]> map = new TreeMap<>();
        map.put(
                stream(nums).reduce(0, Integer::sum),
                unChangedValues.toArray(new Integer[0])
        );
        return map;
    }
    static void validate(int[] nums){
        if(nums.length <= 1)
            throw new IllegalArgumentException("array'in boyu 1'den büyük olmalı");
        if(nums.length >=100)
            throw new IllegalArgumentException("array'in boyu 1000'den küçük olmalı");
        for (int num :nums) {
            if(num>=2000)
                throw new IllegalArgumentException("sayılar 2000'den küçük olmalı");
            if(num<=0)
                throw new IllegalArgumentException("sayılar 0'dan büyük olmalı");
        }
    }
}
