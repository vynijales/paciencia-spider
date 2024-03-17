package Stack;

public class Stack <T> implements InterfaceStack<T>{

    T[] vector;
    int top;
    int size;


    @SuppressWarnings("unchecked")
    public Stack(int size){
        this.size = size;
        vector = (T[]) new Object[size];
        top = -1;
    }
    

    @Override
    public void push(T number) throws Exception {
        if(isFull()){
            throw new Exception("The stack is full");
        }
        else{
            top+=1;
            vector[top] = number;
        }
       
    }
    @Override
    public T pop() throws Exception {
        if(isEmpty()){
            throw new Exception("The stack is empty");
        }
        else{
            T element = vector[top];
            top -=1;
            return element;
        }
    }

    @Override
    public T peek() throws Exception {
        if(isEmpty()){
            throw new Exception("The stack does not contain elements");
        }
        else{
            return vector[top];
        }
    }

    @Override
    public boolean isEmpty() {
        if(top == -1)
            return true;
        else
            return false;
    }

    @Override
    public boolean isFull() {
        if(top == size-1)
            return true;
        else
            return false;
    }


    @Override
    public void show() {
        System.out.print("[ ");
        for(int i = 0; i <= top; i++){
            System.out.print(vector[i] + " ");
        }
        System.out.print("]");
    }


    public int getTop() {
        return top;
    }


    public int getSize() {
        return size;
    }
}
