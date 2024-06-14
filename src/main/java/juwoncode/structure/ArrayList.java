/**
 * @title : 배열 리스트
 * @description : 데이터가 연속된 공간에 저장되는 배열 형태의 자료구조.
 *      - 메모리에 연속적으로 저장하여 공간이 낭비되지 않는다. 그러나 배열 크기를 늘릴 때 일시적으로 메모리 공간이 낭비될 수 있다.
 *      - 데이터가 연속된 장소에 저장되므로 중간 인덱스의 추가와 삭제 속도가 느리다. O(n)
 *      - 배열 끝의 데이터의 추가와 삭제는 빠르다. O(1)
 *      - 조회는 인덱스를 통하여 접근하므로 빠르다. O(1)
 */

package juwoncode.structure;

public class ArrayList<T> {
    private int size;
    private T[] elements;

    /**
     * ArrayList 클래스 객체 생성자.
     * 값을 담는 배열과 리스트 크기를 초기화한다.
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        size = 0;
        elements = (T[]) new Object[100];
    }

    /**
     * 새로운 값을 해당 인덱스의 위치에 추가한다.
     * @param index
     *      값을 추가할 인덱스
     * @param value
     *      추가할 값
     */
    public void add(int index, T value) {
        // 추가할 인덱스의 오른쪽 값을 한 칸씩 민다.
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }

        // 값을 삽입하고 리스트의 크기를 늘린다.
        elements[index] = value;
        size++;
    }

    /**
     * 새로운 값을 첫 인덱스의 위치에 추가한다.
     * @param value
     *      추가할 값
     */
    public void addFirst(T value) {
        add(0, value);
    }

    /**
     * 새로운 값을 마지막 인덱스의 위치에 추가한다.
     * @param value
     *      추가할 값
     */
    public void addLast(T value) {
        elements[size] = value;
        size++;
    }

    /**
     * 해당 인덱스의 값을 반환한다.
     * @param index
     *      값을 찾을 인덱스
     * @return
     *      찾은 값
     */
    public Object get(int index) {
        return elements[index];
    }

    /**
     * 값과 일치하는 리스트의 첫번째 인덱스를 반환한다.
     * @param element
     *      찾을 값
     * @return
     *      찾은 리스트의 인덱스
     */
    public Object indexOf(T element) {
        // 배열을 순회하여 값이 일치하는 인덱스를 반환한다.
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }

        // 일치하는 인덱스가 없을 경우 -1을 반환하고 종료한다.
        return -1;
    }

    /**
     * 리스트의 크기를 반환한다.
     * @return
     *      리스트의 크기
     */
    public int size() {
        return size;
    }

    /**
     * 해당 인덱스의 값을 삭제한다.
     * @param index
     *      삭제할 인덱스
     * @return
     *      삭제한 값
     */
    public T remove(int index) {
        T removed = elements[index];

        // 삭제할 인덱스의 오른쪽 값을 한 칸씩 당긴다.
        for (int i = index + 1; i <= size - 1; i++) {
            elements[i - 1] = elements[i];
        }

        // 크기를 줄이고 마지막 인덱스를 삭제한다.
        size--;
        elements[size] = null;

        // 삭제한 값을 반환한다.
        return removed;
    }

    /**
     * 첫번째 인덱스의 값을 삭제한다.
     * @return
     *      삭제한 값
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 마지막 인덱스의 값을 삭제한다.
     * @return
     *      삭제한 값
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 리스트를 문자열로 반환한다.
     * @return
     *      리스트 문자열
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);

            if (i < size - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }

    /**
     * 반복자 인스턴스를 생성하고 반환한다.
     * @return
     *      리스트 반복자 객체
     */
    public ListIterator listIterator() {
        return new ListIterator();
    }

    class ListIterator {
        private int nextIndex;

        ListIterator() {
            nextIndex = 0;
        }

        /**
         * 이전 인덱스가 존재하는지 검사한다.
         * @return
         *      이전 인덱스의 존재여부
         */
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        /**
         * 이전 인덱스의 값을 반환한다.
         * @return
         *      이전 인덱스의 값
         */
        public Object previous() {
            return elements[--nextIndex];
        }

        /**
         * 다음 인덱스가 존재하는지 검사한다.
         * @return
         *      다음 인덱스의 존재여부
         */
        public boolean hasNext() {
            return nextIndex < size();
        }

        /**
         * 다음 인덱스의 값을 반환한다.
         * @return
         *      다음 인덱스의 값
         */
        public Object next() {
            return elements[nextIndex++];
        }

        /**
         * 현재 인덱스에 값을 삽입한다.
         * @param value
         *      추가할 값
         */
        public void add(T value) {
            ArrayList.this.add(nextIndex++, value);
        }

        /**
         * 현재 인덱스의 값을 삭제한다.
         */
        public void remove() {
            ArrayList.this.remove(nextIndex - 1);
            nextIndex--;
        }
    }
}
