/**
 * @title : 선택정렬
 * @description : 입력 배열에서 가장 작은 값부터 순서대로 선택해서 정렬한다.
 *      - 입력 데이터의 상태와 상관없이 항상 동일한 성능을 가짐. O(n^2)
 *      - 추가적으로 상수 개의 저장 공간만 필요한 제자리 정렬 알고리즘이다.
 *      - 값이 같은 경우에도 자리가 변경되는 안정적이지 않은 정렬 알고리즘이다.
 */

package juwoncode.sort;

public class SelectionSort {
    /**
     * 정수 배열을 오름차순으로 선택정렬 알고리즘을 사용하여 정렬한다.
     * @param array
     *      정렬할 배열
     */
    public static void sort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            int m = i;
            for (int j = i + 1; j < length; j++) {
                if (array[m] > array[j]) {
                    m = j;
                }
            }
            swap(array, i, m);
        }
    }

    /**
     * 정수형 배열의 두 인덱스의 값을 교환한다.
     * @param array
     *      값을 교환할 배열
     * @param index1
     *      교환 인덱스 1
     * @param index2
     *      교환 인덱스 2
     */
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
