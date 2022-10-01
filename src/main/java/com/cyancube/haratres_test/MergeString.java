package com.cyancube.haratres_test;

public class MergeString {
    /*
     	Merge String
    Fonksiyonumuz string olarak 2 parametre alacak. String a ve String b. Amacımız bu iki stringi tek bir stringte sırasıyla birleştirmek.

    Örneğin:
    String a = hrte
    String b = aars

    Çıktı: haratres

    Kısıtlar
    a ve b nin boyuları 1< a, b < 2500 olmalıdır

    Kısıtlara uymayan durumlarda system exception throw etmeli.
     */
    public static String merge(String a , String b){
        validate(a,b);
        StringBuilder result = new StringBuilder();
        for (int i=0 ; i < a.length()+b.length() ;){
            if(a.length()> i) result.append(a.charAt(i));
            if (b.length()>i) result.append(b.charAt(i));
            i++;
        }
        return result.toString();
    }
    static void validate(String a,String b){
        if(1>=a.length()){
            throw new IllegalArgumentException("girilen ilk kelimenin uzunluğu 1'den büyük olmalıdır");
        }
        if(a.length()>=2500 ){
            throw new IllegalArgumentException("girilen ilk kelimenin uzunluğu 2500'den küçük olmalıdır");
        }
        if(1>=b.length()){
            throw new IllegalArgumentException("girilen ikinci kelimenin uzunluğu 1'den büyük olmalıdır");
        }
        if(b.length()>=2500){
            throw new IllegalArgumentException("girilen ikinci kelimenin uzunluğu 2500'den küçük olmalıdır");
        }
    }
}
