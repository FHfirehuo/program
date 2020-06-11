package datastructure.stack;

public class FireMinStack {

    private FireStack data;
    private FireStack minIndex;

    public FireMinStack(){
        data = new FireStack();
        minIndex = new FireStack();
    }

    public int Size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void push(Integer element){
        if (data.isEmpty()){
            minIndex.push(element);
        }else if(element < minIndex.top()){
            minIndex.push(element);
        }
        data.push(element);
    }

    public Integer pop(){
        int item = data.pop();
        if (item == minIndex.top()){
            minIndex.pop();
        }
        return item;
    }

    public Integer top(){
        return data.top();
    }

    public Integer getMin(){
        if(minIndex.isEmpty()){
            throw new RuntimeException("no min");
        }
        return minIndex.top();
    }

    public static void main(String[] args) {
        FireMinStack fireMinStack = new FireMinStack();
        fireMinStack.push(-2);
        fireMinStack.push(0);
        fireMinStack.push(-3);
        System.out.println(fireMinStack.getMin());
        fireMinStack.pop();
        System.out.println(fireMinStack.top());
        System.out.println(fireMinStack.getMin());
    }
}
