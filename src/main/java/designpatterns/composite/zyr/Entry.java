package designpatterns.composite.zyr;

/**
 * Entry 抽象类：共同特质
 *
 * @author liuyi27
 */
public abstract class Entry {

    public abstract String getName();

    public abstract int getSize();

    public abstract void printList(String prefix);

    public void printList() {
        printList("");
    }

    public Entry add(Entry entry) throws RuntimeException {
        throw new RuntimeException();
    }

    public String toString() {
        return getName() + "<" + getSize() + ">";
    }
}
