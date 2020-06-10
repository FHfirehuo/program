package designpatterns.intermediary;


/**
 * 职员接口
 */
public abstract class ZhiYuan {

    String name;
    private Mediator mediator;
    public ZhiYuan(Mediator mediator,String name){
        this.mediator = mediator;
        this.name = name;
    }
    //被调停者调用的方法
    public void called(String message,String nname){
        System.out.println(name + "接收到来自"+ nname + "的需求：" + message);
    }
    //调用调停者
    public void call(String message,ZhiYuan zhiyuan,String nname){
        System.out.println(nname + "发起需求："+ message);
        mediator.change(message,zhiyuan,nname);
    }
}
