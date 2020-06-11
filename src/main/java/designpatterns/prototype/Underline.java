package designpatterns.prototype;

public class Underline implements Product {
    char ch;

    public Underline(char ch) {
        this.ch = ch;
    }

    public void use(String word) {
        System.out.print(ch);
        System.out.print(word);
        System.out.println(ch);
        for (int i = 0; i < word.getBytes().length + 1; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }
}
