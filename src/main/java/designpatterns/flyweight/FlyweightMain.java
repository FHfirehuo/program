package designpatterns.flyweight;

/**
 * 使用工厂模式进行配合，创建对象池，
 * 测试类中的循环，你可以想象成为要举行5场比赛，每场比赛的场地就是体育馆
 *
 * 通过执行结果可以看出，在这个对象池（HashMap）中，
 * 一直都只有一个对象存在，第一次使用的时候创建对象，
 * 之后的每次调用都用的是那个对象，不会再重新创建。
 */
public class FlyweightMain {
    public static void main(String[] args) {
        String yundong ="足球";
        for(int i = 1;i <= 5;i++){
            TiYuGuan tyg = JianZhuFactory.getTyg(yundong);
            tyg.setName("中国体育馆");
            tyg.setShape("圆形");
            tyg.use();
            System.out.println("对象池中对象数量为："+JianZhuFactory.getSize());
        }
    }
}
