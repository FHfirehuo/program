package designpatterns.template;

/**
 * $Des$
 *
 * @author liuyi27
 */
public class CharDisplay extends AbstractDisplay {


    String word;

    CharDisplay(String word) {
        this.word = word;
    }

    public void open() {
        System.out.print("<<");
    }

    public void print() {
        System.out.print(word);
    }

    public void close() {
        System.out.println(">>");
    }
}
