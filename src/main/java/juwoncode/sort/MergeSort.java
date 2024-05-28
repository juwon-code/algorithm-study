/**
 * @title : 합병정렬
 * @description : 배열을 동일한 크기의 부분배열로 분할, 합병의 과정을 거쳐서 정렬한다.
 *      - 최선, 최악, 평균 모두 동일한 성능을 갖는다. O(nlogn)
 *      - 입력 크기만큼의 추가적인 공간이 필요하며, 제자리 정렬 알고리즘이 아니다.
 *      - 합병 과정에서 값은 값에 대해서 왼쪽 값을 우선하는 안정적인 정렬 알고리즘이다.
 */

package juwoncode.sort;

public class MergeSort {
    /**
     * 정수 배열을 오름차순으로 정렬한다.
     * @param array
     *      정렬할 배열
     */
    public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * 합병정렬 알고리즘을 사용하여 오름차순으로 정렬한다.
     * <pre>
     *     - 부분 배열의 기준이 될 중간 값을 구한다.
     *     - 왼쪽 배열과, 오른쪽 배열을 나누어 재귀호출하여 정렬한다.
     * </pre>
     * @param array
     *      정렬할 배열
     * @param low
     *      낮은 값
     * @param high
     *      높은 값
     */
    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = low + ((high - low) / 2);

            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);

            merge(array, low, middle, high);
        }
    }

    /**
     * 임시 배열에 부분 배열의 값을 사용하여 정렬하고 본 배열에 반영한다.
     * <pre>
     *     1. 왼쪽 부분 배열값이 오른쪽 부분배열 값을 비교하여 낮은 값부터 임시 배열에 삽입한다.
     *     2. 부분 배열에 남은 값이 있을 경우 임시 배열에 삽입한다.
     *     3. 정렬이 끝난 임시 배열의 값을 순서대로 본 배열에 반영한다.
     * </pre>
     * @param array
     *      정렬할 배열
     * @param low
     *      낮은 값
     * @param middle
     *      중간 값
     * @param high
     *      높은 값
     */
    private static void merge(int[] array, int low, int middle, int high) {
        int[] temp = new int[high - low + 1];
        int index = 0, left = low, right = middle + 1;

        while (left <= middle && right <= high) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }

            index++;
        }

        while (left <= middle) {
            temp[index] = array[left];
            index++;
            left++;
        }

        while (right <= high) {
            temp[index] = array[right];
            index++;
            right++;
        }

        for (int i = low; i <= high; i++) {
            array[i] = temp[i - low];
        }
    }
}
