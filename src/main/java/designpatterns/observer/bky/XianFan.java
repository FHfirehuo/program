package designpatterns.observer.bky;

import java.util.ArrayList;
import java.util.List;

public class XianFan implements HuaiRen {
    //别称
    private String name = "大熊";
    //定义观察者集合
    private List<Observer> observerList = new ArrayList<Observer>();

    //增加观察者
    @Override
    public void addObserver(Observer observer) {
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    //移除观察者
    @Override
    public void removeObserver(Observer observer) {
        if (observerList.contains(observer)) {
            observerList.remove(observer);
        }
    }

    //通知观察者
    @Override
    public void notice(String message) {
        for (Observer observer : observerList) {
            observer.update(message, name);
        }
    }
}
