/**
 * @title : 힙정렬
 * @description : 완전 이진트리 기반의 힙을 사용하여 정렬한다.
 *      - 최선, 최악, 평균 모두 동일한 성능을 갖는다. O(nlogn)
 *      - 추가적으로 상수 개의 저장 공간만 필요한 제자리 정렬 알고리즘이다.
 *      - 값이 같은 경우에도 자리가 변경되는 안정적이지 않은 정렬 알고리즘이다.
 *      - 새로운 값을 삽입하거나 최댓값을 삭제하기 쉬운 특징을 갖는다.
 */

package juwoncode.sort;

public class HeapSort {
    /**
     * 정수 배열을 오름차순으로 힙정렬 알고리즘을 사용하여 정렬한다.
     * @param array
     *      정렬할 배열
     */
    public static void sort(int[] array) {
        int length = array.length;

        // 배열을 힙으로 변환한다.
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // 최댓값을 삭제하며, 힙을 재구성한다.
        for (int i = length - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    /**
     * 정수 배열을 힙의 형태로 변환한다.
     * @param array
     *      변환할 배열
     * @param length
     *      배열의 범위
     * @param parent
     *      부모 인덱스
     */
    private static void heapify(int[] array, int length, int parent) {
        int max = parent;
        int lChild = parent * 2 + 1;
        int rChild = parent * 2 + 2;

        // 왼쪽 자식노드가 부모노드보다 클 경우, 최대 노드를 업데이트.
        if (lChild < length && array[lChild] > array[max]) {
            max = lChild;
        }

        // 오른쪽 자식노드가 부모노드보다 클 경우, 최대 노드를 업데이트.
        if (rChild < length && array[rChild] > array[max]) {
            max = rChild;
        }

        // 최대 노드가 변경되었을 경우, 부모노드와 자식노드를 교체한다.
        if (max != parent) {
            swap(array, parent, max);
            heapify(array, length, max);
        }
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
