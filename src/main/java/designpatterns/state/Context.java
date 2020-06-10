package designpatterns.state;

//Context类，维护一个ConcreteState子类的实例，这个实例定义当前的状态
public class Context {

    State state;

    public Context(State state) { //定义Context的初始状态
        super();
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("当前状态为"+state);
    }
    public void request(){
        state.Handle(this); //对请求做处理并且指向下一个状态
    }
}
