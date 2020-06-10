package designpatterns.template;

/**
 * $Des$
 *
 * @author liuyi27
 */
public class StringDisplay extends AbstractDisplay {

    String word;
    int width;

    StringDisplay(String word){
        this.word=word;
        width=word.getBytes().length;
    }

    public void open() {
        printString();
    }

    public void print() {
        for(int i=0;i<5;i++){
            System.out.print("|");
            System.out.print(word);
            System.out.println("|");
        }
    }

    public void close() {
        printString();
    }

    private void printString(){
        System.out.print("#");
        for(int i=0;i<width;i++){
            System.out.print("*");
        }
        System.out.println("#");
    }
}
