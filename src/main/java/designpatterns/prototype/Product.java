package designpatterns.prototype;

public interface Product extends Cloneable {
    void use(String word);

    Product createClone();

    void setCh(char ch);
}
