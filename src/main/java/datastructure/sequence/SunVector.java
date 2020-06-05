package datastructure.sequence;

import java.util.*;

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

        List<Integer> ccc = new ArrayList<>();

        TreeSet aaa  =new TreeSet();

        aaa.add(2);



        TreeSet<User> uuuuu  =new TreeSet(new Comparator<User>(){

            @Override
            public int compare(User o1, User o2) {
                return 0;
            }
        });


        TreeSet<User> uuu  =new TreeSet();
        User u = new User();
        u.setAge(11);
        uuu.add(u);
        u = new User();
        u.setAge(5);
        uuu.add(u);
        uuu.forEach(uu ->{
            System.out.println(uu.getAge());
        });

    }


}

class User implements Comparable<User>{

    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.age - o.getAge();
    }
}
