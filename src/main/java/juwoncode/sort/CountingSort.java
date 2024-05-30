/**
 * @title : 계수정렬
 * @description : 데이터의 개수를 기반으로 데이터의 위치를 찾아 정렬한다.
 *      - 데이터 분포 정보를 활용하는 정렬 알고리즘이다.
 *      - 숫자의 범위를 알 수 있고 합리적일 때 사용한다.
 *      - 입력값의 범위를 K라 할 때, 선형 시간을 갖는다. O(n + k)
 *      - 추가적인 데이터 범위의 저장 공간이 필요하며 제자리 정렬 알고리즘이 아니다.
 *      - 입력 배열의 오른쪽부터 오른쪽에 저장하는 안정적인 정렬 알고리즘이다.
 */

package juwoncode.sort;

public class CountingSort {
    /**
     * 정수 배열을 오름차순으로 계수정렬 알고리즘을 사용하여 정렬한다.
     * @param array
     *      정렬할 배열
     * @return
     *      정렬된 배열
     */
    public static int[] sort(int[] array) {
        int length = array.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // 입력값의 최댓값, 최솟값을 얻는다.
        for (int number : array) {
            if (number < min) {
                min = number;
            }

            if (number > max) {
                max = number;
            }
        }

        int[] counts = new int[max - min + 1];

        // 임시배열에 해당 숫자(인덱스)의 출현 횟수를 넣는다.
        for (int number : array) {
            counts[number - min]++;
        }

        // 임시배열에 출현 횟수의 누적값을 계산한다.
        for (int i = 1; i < length; i++) {
            counts[i] += counts[i - 1];
        }

        int[] result = new int[length];

        // 임시배열를 참고하여 정렬한값을 결과배열에 삽입한다.
        for (int i = array.length - 1; i >= 0; i--) {
            int number = array[i];
            int index = --counts[number - min];
            result[index] = number;
        }

        return result;
    }
}
