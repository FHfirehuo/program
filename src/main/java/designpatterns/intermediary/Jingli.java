package designpatterns.intermediary;

/**
 * 调停者：经理
 */
public class Jingli implements Mediator {

    @Override
    public void change(String message,ZhiYuan zhiyuan,String nname) {
        System.out.println("经理收到" + nname + "的需求：" + message);
        System.out.println("经理将" + nname + "的需求发送给目标职员");
        zhiyuan.called(message,nname);
    }
}
