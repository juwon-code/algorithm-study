/**
 * @title : 버블정렬
 * @description :
 *      인접한 데이터를 차례대로 비교하여 자리를 교환하며 정렬한다.
 *      - 입력 데이터의 상태와 상관없이 항상 동일한 성능을 가짐. O(n^2)
 *      - 추가적으로 상수 개의 저장 공간만 필요한 제자리 정렬 알고리즘이다.
 *      - 값이 같은 경우에도 자리가 변경되는 안정적이지 않은 정렬 알고리즘이다.
 *      - 알고리즘을 개선하여 이미 정렬된 경우 좋은 성능을 얻을 수 있다. O(n)
 */

package juwoncode.sort;

public class BubbleSort {
    /**
     * 정수 배열을 오름차순으로 버블정렬 알고리즘을 사용하여 정렬한다.
     * @param array
     *      정렬할 배열
     * @return
     *      오름차순으로 정렬된 배열
     */
    public static int[] sort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }

        return array;
    }

    /**
     * 정수 배열을 오름차순으로 버블정렬 알고리즘을 사용하여 정렬한다.
     * 기존 알고리즘을 개선한 변경사항은 다음과 같다.
     * <pre>
     *     - 반복할 때마다 오른쪽을 제외하여 검사 횟수를 줄인다.
     *     - 정렬된 상태로 판단될 경우 조기 종류한다.
     * </pre>
     * @param array
     *      정렬할 배열
     * @return
     *      오름차순으로 정렬된 배열
     */
    public static int[] fasterSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            boolean isSorted = true;

            for (int j = 0; j < length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }

        return array;
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
