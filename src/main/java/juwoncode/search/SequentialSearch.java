/**
 * @title : 순차 탐색
 * @description : 배열로 주어진 원소들을 순차적으로 비교하여 탐색한다.
 *      - 정렬되지 않은 데이터에 적합한 탐색 알고리즘이다.
 *      - 데이터의 탐색, 삭제 연산의 시간 복잡도는 O(n)이다.
 *      - 데이터의 삽입 연산의 시간 복잡도는 O(1)이다.
 */

package juwoncode.search;

import java.util.Arrays;

public class SequentialSearch {
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

        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return  -1;
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
}
