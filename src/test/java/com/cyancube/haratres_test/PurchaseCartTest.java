package com.cyancube.haratres_test;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PurchaseCartTest {

    @Test
    void getTotalPriceOfAndUndiscountedItems1() {
        TreeMap<Integer, Integer[]> result = PurchaseCart.getTotalPriceOfAndUndiscountedItems(new int[]{5, 6, 4, 3, 4});
        int expectedSum = 15;
        assertEquals(expectedSum,result.firstKey());
        var expectedArray= new Integer[]{3,4,5};
        for (int i=0 ; i<result.firstEntry().getValue().length ; i++){
            assertEquals(expectedArray[i],
                    result.firstEntry().getValue()[i]);
        }

    }
    @Test
    void getTotalPriceOfAndUndiscountedItems2() {
        TreeMap<Integer, Integer[]> result = PurchaseCart.getTotalPriceOfAndUndiscountedItems(new int[]{5,8,4,2,6});
        int expectedSum = 19;
        assertEquals(expectedSum,result.firstKey());
        var expectedArray= new Integer[]{2,5,6};
        for (int i=0 ; i<result.firstEntry().getValue().length ; i++){
            assertEquals(expectedArray[i],
                    result.firstEntry().getValue()[i]);
        }

    }

    @Test
    void validateThat1SizedArrayThrowsException() {
        assertThrows(IllegalArgumentException.class,()->PurchaseCart.getTotalPriceOfAndUndiscountedItems(new int[1]));
    }
    @Test
    void validateThat100SizedArrayThrowsException() {
        assertThrows(IllegalArgumentException.class,()->PurchaseCart.getTotalPriceOfAndUndiscountedItems(new int[100]));
    }
    @Test
    void validateThatElementsEqualOrBiggerThan2000ThrowsException() {
        assertThrows(IllegalArgumentException.class,()->PurchaseCart.getTotalPriceOfAndUndiscountedItems(new int[]{5,1999+1}));
    }
    @Test
    void validateThatNegativeElementsThrowsException() {
        assertThrows(IllegalArgumentException.class,()->PurchaseCart.getTotalPriceOfAndUndiscountedItems(new int[]{5,1-1}));
    }
}
