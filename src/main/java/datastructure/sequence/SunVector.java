package datastructure.sequence;

import java.util.Vector;

public class SunVector {

    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(1,1);
        v.addElement(1);
        v.contains(1);
        v.elementAt(0);
        v.get(0);
        v.isEmpty();
        v.remove(1);
        v.size();
        v.set(1,1);

        System.out.println("v size:" + v.size());

        int[] a = new int[10];
        System.out.println("a length:" + a.length);



    }
}
