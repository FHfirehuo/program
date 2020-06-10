package designpatterns.iterator.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * $Des$
 *
 * @author liuyi27
 */
public class ListMain {
    public static void main(String[] args) {
        List<String> a =new ArrayList();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        Iterator<String> listIterator = a.iterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
    }
}
