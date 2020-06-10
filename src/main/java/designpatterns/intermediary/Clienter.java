package designpatterns.intermediary;

public class Clienter {
    public static void main(String[] args) {

        //分配职员与经理
        Mediator jingli = new Jingli();
        ZhiYuan zhiyuanA = new ZhiyuanA(jingli,"职员A");
        ZhiYuan zhiyuanB = new ZhiyuanB(jingli, "职员B");
        ZhiYuan zhiyuanC = new ZhiyuanC(jingli, "职员C");
        //职员A的需求
        String messageA = "这些资料需要B职员操作";
        zhiyuanA.call(messageA,zhiyuanB,zhiyuanA.name);
        //职员C的请求
        String messageC = "这些资料需要B职员签名";
        zhiyuanC.call(messageC, zhiyuanB,zhiyuanC.name);

    }
}
