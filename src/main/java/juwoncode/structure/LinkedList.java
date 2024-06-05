/**
 * @title : 연결 리스트
 * @description : 데이터와 포인터를 갖는 노드들이 연결된 형태의 자료구조.
 *      - 메모리에 비연속적으로 저장하여 공간이 낭비되지 않는다.
 *      - 삭제와 삽입 속도가 빠르다. O(1)
 *      - 조회는 데이터를 순차적으로 접근하므로 느리다. O(n)
 */

package juwoncode.structure;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private T value;
        private Node next;

        /**
         * Node 클래스 객체 생성자.
         * @param value
         *      노드의 값
         */
        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * 헤드 노드를 추가한다.
     * @param value
     *      추가할 노드의 값
     */
    public void addHead(T value) {
        // 새로운 노드를 생성한다.
        Node newNode = new Node(value);

        // 새로운 노드의 다음 노드를 헤드로 설정하고, 헤드를 새로운 노드로 설정한다.
        newNode.next = head;
        head = newNode;

        // 리스트의 크기를 늘린다.
        size++;

        // 다음 노드가 존재하지 않을 경우, 테일 노드로 설정한다.
        if (head.next == null) {
            tail = head;
        }
    }

    /**
     * 테일 노드를 추가한다.
     * @param value
     *      추가할 노드의 값
     */
    public void addTail(T value) {
        // 새로운 노드를 생성한다.
        Node newNode = new Node(value);

        // 리스트가 비어있을 경우, 헤드 노드로 추가한다.
        if (size == 0) {
            addHead(value);
        } else {
            // 기존 테일 노드의 다음 노드로 설정하고, 테일 노드로 설정한다.
            tail.next = newNode;
            tail = newNode;

            // 리스트의 크기를 늘린다.
            size++;
        }
    }

    /**
     * 해당 인덱스에 값을 가진 새로운 노드를 추가한다.
     * @param index
     *      노드를 추가할 인덱스
     * @param value
     *      추가할 값
     */
    public void add(int index, T value) {
        // 리스트가 비어있을 경우, 헤드 노드로 추가한다.
        if (index == 0) {
            addHead(value);
        } else {
            // 이전 노드, 다음 노드, 새로운 노드 객체를 가져온다.
            Node previousNode = getNode(index - 1);
            Node nextNode = previousNode.next;
            Node newNode = new Node(value);

            // 이전 노드 -> 새로운 노드 -> 다음 노드의 형태로 연결한다.
            previousNode.next = newNode;
            newNode.next = nextNode;

            // 리스트의 크기를 늘린다.
            size++;

            // 새로운 노드의 다음 노드가 존재하지 않는다면, 테일 노드에 삽입한다.
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    /**
     * 특정 인덱스의 노드를 반환한다.
     * @param index
     *      값을 찾을 리스트의 인덱스
     * @return
     *      특정 인덱스의 노드 객체
     */
    private Node getNode(int index) {
        // 헤드 노드 객체를 가져온다.
        Node node = head;

        // 헤드부터 목표 인덱스까지 탐색한다.
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    /**
     * 인덱스에 해당하는 노드의 값을 반환한다.
     * @param index
     *      값을 찾을 노드의 인덱스
     * @return
     *      노드의 값
     */
    public T getValue(int index) {
        Node node = getNode(index);

        return node.value;
    }

    /**
     * 리스트의 전체 크기를 반환한다.
     * @return
     *      리스트 크기
     */
    public int getSize() {
        return size;
    }

    /**
     * 리스트의 값과 일치하는 노드의 인덱스를 반환한다.
     * @param value
     *      찾을 값
     * @return
     *      노드의 인덱스
     */
    public int indexOf(T value) {
        Node node = head;
        int index = 0;

        // 일치하는 값을 찾을 때까지 리스트를 순회한다.
        while (node.value != value) {
            node = node.next;
            index++;

            // 노드가 비어있다면 -1을 반환하고 종료한다.
            if (node == null) {
                return -1;
            }
        }

        return index;
    }

    /**
     * 리스트의 헤드 노드를 삭제한다.
     * @return
     *      삭제한 헤드 노드의 값
     */
    public T removeHead() {
        // 삭제할 헤드 노드 객체를 가져온다.
        Node removalNode = head;

        // 기존 헤드 노드를 다음 노드로 설정한다.
        head = head.next;

        // 리스트의 크기를 줄인다.
        size--;

        // 삭제한 헤드 노드의 값을 반환한다.
        return removalNode.value;
    }

    /**
     * 리스트의 테일 노드를 삭제한다.
     * @return
     *      삭제한 테일 노드의 값
     */
    public T removeTail() {
        return remove(size - 1);
    }

    /**
     * 리스트의 특정 인덱스의 노드를 삭제한다.
     * @param index
     *      삭제할 인덱스
     * @return
     *      삭제한 노드의 값
     */
    public T remove(int index) {
        // 인덱스가 0일 경우, 헤드 노드를 삭제한다.
        if (index == 0) {
            return removeHead();
        }

        // 이전 노드와 삭제할 노드를 가져온다.
        Node previousNode = getNode(index - 1);
        Node removalNode = previousNode.next;

        // 이전 노드에 삭제할 노드의 다음 노드를 연결한다.
        previousNode.next = removalNode.next;

        // 삭제할 노드가 테일 노드라면 이전 노드로 설정한다.
        if (removalNode == tail) {
            tail = previousNode;
        }

        // 리스트의 크기를 줄인다.
        size--;

        // 삭제한 헤드 노드의 값을 반환한다.
        return removalNode.value;
    }

    /**
     * 새로운 리스트 반복자 인스턴스를 반환한다.
     * @return
     *      리스트 반복자 객체
     */
    public ListIterator listIterator() {
        return new ListIterator();
    }

    class ListIterator {
        private Node current;
        private Node next;
        private int pointer;

        ListIterator() {
            next = head;
            pointer = 0;
        }

        /**
         * 다음 노드의 값을 가리키고, 이전 노드의 값을 반환한다.
         * @return
         *      현재 노드의 값
         */
        public T next() {
            current = next;
            next = next.next;
            pointer++;

            return current.value;
        }

        /**
         * 다음 노드가 존재하는지 검사한다.
         * @return
         *      다음 노드의 존재여부
         */
        public boolean hasNext() {
            return pointer < getSize();
        }

        /**
         * 현재 인덱스에 새로운 노드를 추가한다.
         * @param value
         *      새로운 노드의 값
         */
        public void add(T value) {
            // 새로운 값을 갖는 노드를 생성한다.
            Node newNode = new Node(value);

            // 리스트가 비어있다면, 헤드 노드를 변경한다.
            if (current == null) {
                head = newNode;
                newNode.next = next;
            } else {
                // 다음 노드를 변경하고, 그 다음 노드를 가리킨다.
                current.next = newNode;
                newNode.next = next;
            }

            // 현재 노드를 새로운 노드로 변경한다.
            current = newNode;

            // 포인터와 리스트 크기를 증가시킨다.
            pointer++;
            size++;
        }

        /**
         * 현재 포인터 이전의 노드를 삭제한다.
         * @exception IllegalStateException
         *      포인터 이전 인덱스의 노드가 존재하지 않을 경우 발생하는 예외
         */
        public void remove() {
            // 포인터가 헤드 노드를 가리키는 경우 예외를 발생시킨다.
            if (pointer == 0) {
                throw new IllegalStateException();
            }

            // 포인터 이전의 노드를 삭제하고 포인터를 감소시킨다.
            LinkedList.this.remove(pointer - 1);
            pointer--;
        }
    }
}
