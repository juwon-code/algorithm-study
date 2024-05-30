/**
 * @title : 버킷정렬
 * @description : 데이터의 값의 범위를 균등하게 나눈 버킷을 만들고 정렬한다.
 *      - 데이터 분포 정보를 활용하는 정렬 알고리즘이다.
 *      - 입력 데이터 값이 균등하게 분포될 때 유용하다.
 *      - 각 버킷은 상수 시간에 정렬이 가능하다. O(n)
 *      - 데이터를 버킷에 넣을 때, 정렬할 때 순서를 유지하는 안정적인 정렬 알고리즘이다.
 *      - 버킷에 대한 저장 공간이 필요하며 제자리 정렬 알고리즘이 아니다.
 */

package juwoncode.sort;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    /**
     * 정수 배열을 오름차순으로 버킷정렬 알고리즘을 사용하여 정렬한다.
     * @param array
     *      정렬할 배열
     */
    public static void sort(int[] array) {
        int length = array.length, max = getMaxValue(array), size = length + 1;

        // 버킷을 생성하고 초기화한다.
        List<List<Integer>> buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            buckets.add(new ArrayList<>());
        }

        // 버킷의 리스트에 데이터를 삽입한다.
        for (int number : array) {
            int index = (int) (Math.floor((double) (number * length) / max));
            buckets.get(index).add(number);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            // 버킷이 비어있을 경우 정렬하지 않고 넘긴다.
            if (bucket.isEmpty()) {
                continue;
            }

            // 버킷을 정렬한다.
            insertionSort(bucket);

            // 버킷의 데이터를 본 배열에 반영한다.
            for (int number : bucket) {
                array[index] = number;
                index++;
            }
        }
    }

    /**
     * 배열의 정수 중에 최대값을 구한다.
     * @param array
     *      최대값을 구할 배열
     * @return
     *      정수의 최대값
     */
    private static int getMaxValue(int[] array) {
        int max = 0;

        for (int number : array) {
            if (max < number) {
                max = number;
            }
        }

        return max;
    }

    /**
     * 리스트를 삽입정렬 알고리즘을 사용하여 정렬한다.
     * @param list
     *      정렬할 리스트
     */
    private static void insertionSort(List<Integer> list) {
        int size = list.size();

        for (int i = 1; i < size; i++) {
            int value = list.get(i);
            int j = i;

            while (j > 0 && value < list.get(j - 1)) {
                list.set(j - 1, list.get(j));
                j--;
            }

            list.set(j, value);
        }
    }
}
