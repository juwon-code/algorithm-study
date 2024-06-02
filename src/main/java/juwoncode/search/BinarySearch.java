/**
 * @title : 이진 탐색
 * @description : 배열로 주어진 원소들을 절반씩 줄여 가면서 원하는 값을 탐색한다.
 *      - 정렬된 데이터에 대해서만 적용 가능한 탐색 알고리즘이다.
 *      - 데이터의 탐색 연산의 시간 복잡도는 O(logn)이다.
 *      - 데이터의 초기화 연산의 시간 복잡도는 O(nlogn)이다.
 *      - 데이터의 삽입 연산의 시간 복잡도는 O(n)이다.
 */

package juwoncode.search;

import java.util.Arrays;

public class BinarySearch {
    /**
     * 배열에 일치하는 값의 인덱스를 반환한다.
     * @param array
     *      탐색할 배열
     * @param value
     *      탐색할 값
     * @return
     *      찾을 경우 인덱스 값을, 찾지 못하면 -1을 반환한다.
     */
    public static int indexOf(int[] array, int value) {
        int length = array.length;

        return search(array, value, 0, length - 1);
    }

    /**
     * 배열의 끝에 값을 추가 삽입한다.
     * @param array
     *      삽입할 배열
     * @param value
     *      삽입할 값
     * @return
     *      값을 삽입한 배열
     */
    public static int[] append(int[] array, int value) {
        int length = array.length;
        int[] result = Arrays.copyOf(array, length + 1);

        result[length] = value;

        return result;
    }

    /**
     * 배열의 특정 인덱스에 해당하는 값을 삭제한다.
     * @param array
     *      값을 삭제할 배열
     * @param index
     *      삭제할 인덱스
     * @return
     *      값이 삭제된 배열
     */
    public static int[] remove(int[] array, int index) {
        int length = array.length;
        int[] result = new int[length - 1];

        // 결과 배열에 삭제 인덱스 이전까지 원 배열의 값을 삽입한다.
        System.arraycopy(array, 0, result, 0, index);
        // 결과 배열에 삭제 인덱스 다음부터 원 배열의 값을 삽입한다.
        System.arraycopy(array, index + 1, result, index, length - index - 1);

        return result;
    }

    /**
     * 배열에서 값의 위치를 찾을 때까지 이진 탐색을 수행한다.
     * @param array
     *      탐색할 배열
     * @param value
     *      탐색할 값
     * @param lPointer
     *      왼쪽 포인터
     * @param rPointer
     *      오른쪽 포인터
     * @return
     *      찾을 경우 인덱스 값을, 찾지 못하면 -1을 반환한다.
     */
    private static int search(int[] array, int value, int lPointer, int rPointer) {
        // 왼쪽 포인터가 오른쪽 포인터 보다 커질 경우, 탐색을 종료한다.
        if (lPointer > rPointer) {
            return -1;
        }

        // 왼쪽 포인터, 오른쪽 포인터 값을 사용하여 중앙 인덱스값을 얻는다.
        int mid = (int) Math.ceil((double) (lPointer + rPointer) / 2);

        /*
            - 중앙 인덱스의 값과 일치할 경우, 탐색을 종료한다.
            - 중앙 값과 비교하여 범위를 조정하고 재귀 호출한다.
         */
        if (array[mid] == value) {
            return mid;
        } else if (value < array[mid]) {
            return search(array, value, lPointer, mid - 1);
        } else {
            return search(array, value, mid + 1, rPointer);
        }
    }
}
