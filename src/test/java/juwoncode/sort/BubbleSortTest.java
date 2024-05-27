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

        assertArrayEquals(BubbleSort.sort(array1), expect);
        assertArrayEquals(BubbleSort.sort(array2), expect);
    }

    @DisplayName("버블정렬 테스트 (개선)")
    @Test
    void fasterSort() {
        int[] array1 = new int[]{5, 4, 3, 2, 1};
        int[] array2 = new int[]{3, 4, 5, 1, 2};
        int[] expect = new int[]{1, 2, 3, 4, 5};

        assertArrayEquals(BubbleSort.fasterSort(array1), expect);
        assertArrayEquals(BubbleSort.fasterSort(array2), expect);
    }
}