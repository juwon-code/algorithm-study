package juwoncode.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    @DisplayName("버블정렬 테스트")
    @Test
    void sort() {
        int[] array1 = new int[]{5, 4, 3, 2, 1};
        int[] array2 = new int[]{3, 4, 5, 1, 2};
        int[] expect = new int[]{1, 2, 3, 4, 5};

        BubbleSort.sort(array1);
        BubbleSort.sort(array2);

        assertArrayEquals(array1, expect);
        assertArrayEquals(array2, expect);
    }

    @DisplayName("버블정렬 테스트 (개선)")
    @Test
    void fasterSort() {
        int[] array1 = new int[]{5, 4, 3, 2, 1};
        int[] array2 = new int[]{3, 4, 5, 1, 2};
        int[] expect = new int[]{1, 2, 3, 4, 5};

        BubbleSort.fasterSort(array1);
        BubbleSort.fasterSort(array2);

        assertArrayEquals(array1, expect);
        assertArrayEquals(array2, expect);
    }
}