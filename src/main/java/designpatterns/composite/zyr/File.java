package designpatterns.composite.zyr;

/**
 * File 类：实现类，叶子结点
 *
 * @author liuyi27
 */
public class File extends Entry {


    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
