package designpatterns.chainofresponsibility.dazhe;

import java.util.Random;

/**
 * $Des$
 *
 * @author liuyi27
 */
public class Customer {

    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    //只关心折扣请求是否被处理了，不关心被谁处理的。
    public void requestDiscount(float discount){
        priceHandler.processDiscount(discount);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setPriceHandler(Sales.createPriceHandler());

        Random random = new Random();

        for(int i=1;i<100;i++){
            System.out.println(i+":");
            customer.requestDiscount(random.nextFloat());
        }
    }
}
