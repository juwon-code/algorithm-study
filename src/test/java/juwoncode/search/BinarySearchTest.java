package juwoncode.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @DisplayName("이진탐색 테스트 (조회)")
    @Test
    void indexOf() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int element1 = 3, element2 = 6;
        int expect1 = 2, expect2 = -1;

        assertEquals(BinarySearch.indexOf(array, element1), expect1);
        assertEquals(BinarySearch.indexOf(array, element2), expect2);
    }

    @DisplayName("이진탐색 테스트 (삽입)")
    @Test
    void append() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int element = 6;
        int[] expect = new int[]{1, 2, 3, 4, 5, 6};

        assertArrayEquals(BinarySearch.append(array, element), expect);
    }

    @DisplayName("이진탐색 테스트 (삭제)")
    @Test
    void remove() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int index1 = 2, index2 = 4;
        int[] expect1 = new int[]{1, 2, 4, 5}, expect2 = new int[]{1, 2, 3, 4};

        assertArrayEquals(BinarySearch.remove(array, index1), expect1);
        assertArrayEquals(BinarySearch.remove(array, index2), expect2);
    }
}