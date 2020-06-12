package designpatterns.proxy;

//委托人：
public class MaYun implements ZiRanRen {

    private void eat() {
        System.out.println("今天吃满汉全席");
    }

    private void drink() {
        System.out.println("今天喝大西洋");
    }

    public void quanLi() {
        System.out.println("我赋予我的代理律师来行使这些权利,此时代理律师全权代理我处理某些事务");
        eat();
    }
}
