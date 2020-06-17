package designpatterns.observer.bky;

public class BianYi implements Observer {
    //定义姓名
    private String bName = "张昊天";

    @Override
    public void update(String message, String name) {
        System.out.println(bName + ":" + name + "那里有新情况：" + message);

    }
}
