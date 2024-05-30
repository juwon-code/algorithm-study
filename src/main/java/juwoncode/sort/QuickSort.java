/**
 * @title : 퀵정렬
 * @description : 배열을 부분배열로 분할하여 정렬을 순환적으로 수행한다.
 *      - 입력 데이터의 상태에 따라서 다른 성능을 가짐. O(nlogn), O(n^2)
 *      - 추가적으로 상수 개의 저장 공간만 필요한 제자리 정렬 알고리즘이다.
 *      - 피벗에 따라서 같은 값의 자리가 변경되는 안정적이지 않은 정렬 알고리즘이다.
 */

package juwoncode.sort;

public class QuickSort {
    /**
     * 정수 배열을 오름차순으로 정렬한다.
     * @param array
     *      정렬할 배열
     */
    public static void sort(int[] array) {
        leftPivotSort(array, 0, array.length - 1);
    }

    /**
     * 왼쪽 피벗을 기준으로 퀵정렬 알고리즘을 사용하여 오름차순으로 정렬한다.
     * @param array
     *      정렬할 배열
     * @param low
     *      낮은 값
     * @param high
     *      높은 값
     */
    private static void leftPivotSort(int[] array, int low, int high) {
        if (low < high) {
            // 배열의 분할 기준이 되는 피벗을 찾는다.
            int pivot = partition(array, low, high);

            // 피벗을 기준으로 왼쪽 배열을 정렬한다.
            leftPivotSort(array, low, pivot - 1);

            // 피벗을 기준으로 오른쪽 배열을 정렬한다.
            leftPivotSort(array, pivot + 1, high);
        }
    }

    /**
     * 조건에 따라서 값을 교환하고 피벗값을 반환한다.
     * @param array
     *      정렬할 배열
     * @param left
     *      배열의 왼쪽값
     * @param right
     *      배열의 오른쪽값
     * @return
     *      최종 피벗 인덱스
     */
    private static int partition(int[] array, int left, int right) {
        int lPointer = left, rPointer = right, pivot = array[left];

        while (lPointer < rPointer) {
            // 피벗값이 오른쪽 포인터보다 작고, 왼쪽 포인터가 오른쪽 포인터보다 작을경우 감소한다.
            while (pivot < array[rPointer] && lPointer < rPointer) {
                rPointer--;
            }

            // 피벗값이 왼쪽 포인터보다 크거나 같고, 왼쪽 포인터가 오른쪽 포인터보다 작을경우 증가한다.
            while (pivot >= array[lPointer] && lPointer < rPointer) {
                lPointer++;
            }

            // 왼쪽 포인터와 오른쪽 포인터의 값을 교환한다.
            swap(array, lPointer, rPointer);
        }

        // 피벗값과 왼쪽 포인터의 값을 교환한다.
        swap(array, left, lPointer);

        return lPointer;
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
