package com.cyancube.haratres_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeStringTest {
    String bigString(){
        String veryBig="";
        for (int i = 0 ;i<2500 ;i++){
            veryBig =veryBig.concat("*");
        }
        return veryBig;
    }

    @Test
    void firstInputStringLengthShouldBeBiggerThan1() {
        assertThrows(IllegalArgumentException.class,()->{
            MergeString.merge("1","bb");  // 1 char or empty string as the first parameter
        });
    }
    @Test
    void secondInputStringLengthShouldBeBiggerThan1() {
        assertThrows(IllegalArgumentException.class,()->{
            MergeString.merge("aa","1");  // 1 char or empty string as the second parameter
        });

    }
    @Test
    void firstInputStringLengthShouldBeSmallerThan2500() {
        assertThrows(IllegalArgumentException.class,()->MergeString.merge(bigString(),"bb"));

    }
    @Test
    void secondInputStringLengthShouldBeSmallerThan2500() {
        assertThrows(IllegalArgumentException.class,()->MergeString.merge("aa",bigString()));
    }
    @Test
    void mergingTheRightWay1(){
        assertEquals("haratres",MergeString.merge("hrte","aars"));
    }
    @Test
    void mergingTheRightWay2(){
        assertEquals("1q2w3e4rtyu",MergeString.merge("1234","qwertyu"));
    }
    @Test
    void mergingTheRightWay3(){
        assertEquals("1q2w3e4r5t6y789",MergeString.merge("123456789","qwerty"));
    }
}
