/**
 * @title : 셸정렬
 * @description : 이동 거리를 늘려서 멀리 떨어진 자리로 이동하여 정렬한다.
 *      - 한 번에 한 자리씩 이동하는 삽입정렬을 개선한 알고리즘이다.
 *      - 입력 데이터의 상태에 따라서 다른 성능을 가짐. O(nlogn), O(n^2)
 *      - 추가적으로 상수 개의 저장 공간만 필요한 제자리 정렬 알고리즘이다.
 *      - 비교 거리에 따라서 같은 값의 자리가 변경되는 안정적이지 않은 정렬 알고리즘이다.
 */

package juwoncode.sort;

public class ShellSort {
    /**
     * 정수 배열을 오름차순으로 셸정렬 알고리즘을 사용하여 정렬한다.
     * @param array
     *      정렬할 배열
     */
    public static void sort(int[] array) {
        int length = array.length;

        for (int i = length / 2; i > 0; i /= 2) {
            for (int j = i; j < length; j++) {
                int value = array[j], k;

                for (k = j - i; k >= 0 && array[k] > value; k -= i) {
                    array[k + i] = array[k];
                }

                array[k + i] = value;
            }
        }
    }
}
