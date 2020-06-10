package designpatterns.proxy;

//代理律师
public class LvShi implements ZiRanRen {
    public void Quanli() {
        new MaYun().Quanli();
    }
}
