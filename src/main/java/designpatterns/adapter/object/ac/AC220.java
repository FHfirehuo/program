package designpatterns.adapter.object.ac;

public class AC220 implements AC {

    public final int output = 220;

    public int outputAC() {
        return output;
    }
}
