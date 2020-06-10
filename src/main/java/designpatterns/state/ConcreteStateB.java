package designpatterns.state;

public class ConcreteStateB extends State {

    @Override
    public void Handle(Context context) {
        context.setState(new ConcreteStateA()); //设置B的下一个状态是A
    }
}
