package com.cyancube.haratres_test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NearNumbersTest {


    @Test
    void nearestNumbersOf1() {
        int[] in_arr = { 32, 41, 12 , 15, 21, 32, 48, 35};
        String[] out_arr = new String[]{"12 15","32 35"};
        for (int i=0 ; i<out_arr.length;i++) {
            assertEquals(out_arr[i],NearNumbers.nearestNumbersOf(in_arr)[i]);
        }

    }
    @Test
    void nearestNumbersOf2() {
        int[] in_arr = { 3, 1, 5, 23, 2, 4, 9, 10, 15, 31};
        String[] out_arr = new String[]{"1 2","2 3","3 4","4 5","9 10"};
        for (int i=0 ; i<out_arr.length;i++) {
            assertEquals(out_arr[i],NearNumbers.nearestNumbersOf(in_arr)[i]);
        }
    }

    @Test
    void validateThat1SizedArrayThrowsException() {
        assertThrows(IllegalArgumentException.class,()->NearNumbers.nearestNumbersOf(new int[1]));
    }
    @Test
    void validateThat1000SizedArrayThrowsException() {
        assertThrows(IllegalArgumentException.class,()->NearNumbers.nearestNumbersOf(new int[1000]));
    }
    @Test
    void validateThatElementsEqualOrBiggerThan20_000ThrowsException() {
        assertThrows(IllegalArgumentException.class,()->NearNumbers.nearestNumbersOf(new int[]{1,20_000}));
    }
    @Test
    void validateThatElementsEqualOrLessThanNegative20_000ThrowsException() {
        assertThrows(IllegalArgumentException.class,()->NearNumbers.nearestNumbersOf(new int[]{1,-20_000}));
    }
}
