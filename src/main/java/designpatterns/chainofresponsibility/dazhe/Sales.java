package designpatterns.chainofresponsibility.dazhe;

public class Sales extends PriceHandler {


    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.05){
            System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(),discount);
        }else{//让直接后继来处理
            if(successor == null){
                System.out.format("%s没有权限批准折扣：%.2f%n", this.getClass().getName(),discount);
            }else{
                successor.processDiscount(discount);
            }

        }
    }

    /**
     * 创建PriceHandler的工厂方法
     * @return
     */
    public final static PriceHandler createPriceHandler() {
        PriceHandler sales = new Sales();
//        PriceHandler manager = new Manager();
//        PriceHandler director = new Director();
//        PriceHandler vicePresident = new VicePresident();
//        PriceHandler ceo = new CEO();

        //设置直接后继
        sales.setSuccessor(null);
//        manager.setSuccessor(director);
//        director.setSuccessor(vicePresident);
//        vicePresident.setSuccessor(ceo);
        return sales;
    }
}
