package keyword;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class FireTransient {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializeUser1();
        deSerializeUser1();

        ConcurrentHashMap<String, Integer> a  = new ConcurrentHashMap();
        a.put("a", 1);
    }

    private static void serializeUser1() throws IOException {
        File file = new File("/opt/test/");
        if (!file.exists()){
            file.mkdirs();
        }
        User1 u = new User1();
        u.setAge(18);
        u.setName("fire");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/opt/test/template1"));
        oos.writeObject(u);
        oos.close();
    }

    private static void deSerializeUser1() throws IOException, ClassNotFoundException {

        File file = new File("/opt/test/template1");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User1 u = (User1) ois.readObject();
        System.out.println(u.toString());
    }

    private static void serializeUser() throws IOException {
        File file = new File("/opt/test/");
        if (!file.exists()){
            file.mkdirs();
        }
        User u = new User();
        u.setAge(10);
        u.setName("fire");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/opt/test/template"));
        oos.writeObject(u);
        oos.close();
    }

    private static void deSerializeUser() throws IOException, ClassNotFoundException {

        File file = new File("/opt/test/template");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User u = (User) ois.readObject();
        System.out.println(u.toString());
    }
}



@Getter
@Setter
@ToString
class User1 implements Externalizable{
    private transient int age;
    private String name;

     //由于实现了Externalizable接口的类，会调用构造函数，
     // 而User1的构造函数是私有的。无法訪问，从而导致抛出异常。
    public User1(){

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(age);
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        age = (int)in.readObject();
        name = (String) in.readObject();
    }
}


@Getter
@Setter
@ToString
class User implements Serializable{
    private transient int age;
    private String name;
}