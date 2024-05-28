/**
 * @title : 삽입정렬
 * @description : 주어진 데이터를 하나씩 뽑아 올바른 위치에 삽입하여 정렬한다.
 *      - 입력 데이터의 상태에 따라서 다른 성능을 가짐. O(n), O(n^2)
 *      - 추가적으로 상수 개의 저장 공간만 필요한 제자리 정렬 알고리즘이다.
 *      - 값이 같은 경우에는 자리가 변경되지 않는 안정적인 정렬 알고리즘이다.
 */

package juwoncode.sort;

public class InsertionSort {
    /**
     * 정수 배열을 오름차순으로 삽입정렬 알고리즘을 사용하여 정렬한다.
     * @param array
     *      정렬할 배열
     * @return
     *      오름차순으로 정렬된 배열
     */
    public static int[] sort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int key = array[i], j = i;

            while (j > 0 && key < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = key;
        }

        return array;
    }
}
