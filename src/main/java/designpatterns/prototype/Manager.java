package designpatterns.prototype;

import java.util.HashMap;

/**
 * $Des$
 *
 * @author liuyi27
 */
public class Manager {

    HashMap hashmap = new HashMap();

    public void register(String key, Product p) {
        hashmap.put(key, p);
    }

    public Product create(String key) {
        Product p = (Product) hashmap.get(key);
        return p.createClone();
    }
}
