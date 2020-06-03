package datastructure.sequence;

import java.util.LinkedList;

public class SunLinkList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList();
        ll.add(1);

        ll.add(1, 1);

        ll.set(1, 1);
        ll.get(1);

        ll.remove(1);
    }
}
