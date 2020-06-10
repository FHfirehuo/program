package designpatterns.prototype;

/**
 * $Des$
 *
 * @author liuyi27
 */
public interface Product extends Cloneable {
    void use(String word);

    Product createClone();

    void setCh(char ch);
}
