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
            // 부분 배열의 기준이 될 중간값을 구한다.
            int middle = low + ((high - low) / 2);

            // 중간값을 기준으로 왼쪽 배열으로 재귀호출.
            mergeSort(array, low, middle);

            // 중간값을 기준으로 오른쪽 배열으로 재귀호출.
            mergeSort(array, middle + 1, high);

            // 배열을 정렬하고 반영한다.
            merge(array, low, middle, high);
        }
    }

    /**
     * 임시 배열에 부분 배열의 값을 사용하여 정렬하고 본 배열에 반영한다.
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
        // 정렬된 부분 배열의 값을 담을 임시 배열을 생성한다.
        int[] temp = new int[high - low + 1];
        int index = 0, left = low, right = middle + 1;

        while (left <= middle && right <= high) {
            // 왼쪽 부분 배열과 오른쪽 부분 배열의 값을 비교하고 낮은 값부터 임시배열에 저장한다.
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }

            index++;
        }

        // 왼쪽 부분 배열이 남아있을 경우 임시배열에 저장한다.
        while (left <= middle) {
            temp[index] = array[left];
            index++;
            left++;
        }

        // 오른쪽 부분 배열이 남아있을 경우 임시배열에 저장한다.
        while (right <= high) {
            temp[index] = array[right];
            index++;
            right++;
        }

        // 임시 배열의 값을 본 배열에 반영한다.
        for (int i = low; i <= high; i++) {
            array[i] = temp[i - low];
        }
    }
}
