package designpatterns.chainofresponsibility.dazhe;

/**
 * 价格处理人：负责处理客户的折扣申请
 * 使用抽象类作为Handler的载体，
 * 因为Handler需要有一个指向自身类型的引用，使用interface不方便
 *
 * @author liuyi27
 */
public abstract class PriceHandler {


    /**
     * 直接后继，用于传递请求
     * 指向自身类型的引用
     * protected:使子类都可以访问到
     */
    protected PriceHandler successor;

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理折扣请求
     * @param discount
     */
    public abstract void processDiscount(float discount);


}
