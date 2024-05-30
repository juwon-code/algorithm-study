/**
 * @title : 기수정렬
 * @description : 낮은 자릿수부터 비교하여 자리를 교환하며 정렬한다.
 *      - 데이터 분포 정보를 활용하는 정렬 알고리즘이다.
 *      - 높은 자릿수부터 정렬하는 것을 MSD, 낮은 자릿수부터 정렬하는 것을 LSD 기수 정렬이라 한다.
 *      - d 자릿수 n개의 숫자들에 대해서 선형시간의 성능을 갖는다. O(d * n)
 *      - 추가적으로 데이터 개수와 진법 크기의 저장 공간이 필요하며 제자리 정렬 알고리즘이 아니다.
 *      - 자릿수 별로 정렬하는 안정적인 정렬 알고리즘이다.
 */

package juwoncode.sort;

public class RadixSort {
    /**
     * 정수 배열을 오름차순으로 기수정렬 알고리즘을 사용하여 정렬한다.
     * @param array
     *      정렬할 배열
     */
    public static void sort(int[] array) {
        int max = getMaxValue(array), length = array.length;

        // 자릿수를 최대값까지 올려가며, 계수정렬을 수행한다.
        for (int i = 1; max / i > 0; i *= 10) {
            countingSort(array, length, i);
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
     * 정수배열을 자릿수를 기준으로 계수정렬을 수행한다.
     * @param array
     *      정렬할 배열
     * @param length
     *      배열의 길이
     * @param exp
     *      자릿수
     * @return
     *      정렬된 배열
     */
    private static void countingSort(int[] array, int length, int exp) {
        int[] result = new int[length];
        int[] counts = new int[10];

        // 자릿수를 기준으로 출현횟수를 셈한다.
        for (int i = 0; i < length; i++) {
            int index = array[i] / exp % 10;
            counts[index]++;
        }

        // 자릿수의 출현횟수의 누적합을 계산하고 반영한다.
        for (int i = 1; i < 10; i++) {
            counts[i] += counts[i - 1];
        }

        // 자릿수 배열을 참고하여 정렬을 수행한다.
        for (int i = length - 1; i >= 0; i--) {
            int number = array[i] / exp % 10;
            int index = --counts[number];
            result[index] = array[i];
        }

        // 정렬한 배열값을 본 배열에 삽입한다.
        for (int i = 0; i < length; i++) {
            array[i] = result[i];
        }
    }
}
