package datastructure.stack;

public class FireStack {
    private int size;
    private Integer[] data;

    public FireStack(){
        data = new Integer[10];
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void push(Integer element){
        //考虑扩容
        data[size++] = element;
    }

    public Integer pop(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("-1");
        }
        int result = data[--size];
        data[size] = null;

//        int[] item = new int[data.length];
//        System.arraycopy(data, 1, item, 0, size);
//        data = item;
        return result;
    }

    public Integer top(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("-1");
        }
        return data[size-1];
    }


    public static void main(String[] args) {
        FireStack fireStack = new FireStack();
        fireStack.push(0);
        fireStack.push(1);
        fireStack.push(2);
        fireStack.push(3);
        int length = fireStack.size;
        for (int i = 0; i < length; i++) {
            System.out.println(fireStack.pop());
        }
    }
}
