import java.util.ArrayList;
import java.util.Arrays;

/**
 * 顺序表
 */
public class MyArrayList {
    public int[] elem;
    public int usedSize;

    public MyArrayList(){
        this.elem = new int[10];
    }

    public void display(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    public int size(){
        return this.usedSize;
    }

    public void add(int pos,int data){
        if(pos<0 || pos>usedSize){
            System.out.println("POS位置不合法");
            return;
        }
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        for(int i = this.usedSize-1; i >=pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;

    }

    public boolean isFull(){
        return usedSize == this.elem.length;

        /*if(usedSize == this.elem.length){
            return true;
        }else{
            return false;
        }*/
    }
    public boolean contains(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    public int search(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    public int getPos(int pos){
        if(pos<0 || pos >=this.usedSize){
            System.out.println("pos位置不合法");
            return -1;//抛异常
        }
        return this.elem[pos];
    }
    public void setPos(int pos,int val){
        if(pos<0||pos>=this.usedSize){
            System.out.println("pos位置不合法");
            return;
        }
        if(usedSize == 0){
            System.out.println("顺序表为空");
            return;
        }
        this.elem[pos] = val;

    }
    public void remove(int toRemove){
        if(usedSize == 0){
            System.out.println("顺序表为空");
            return;
        }
        int index = search(toRemove);
        if(index == -1){
            System.out.println("没有目标数字");
            return;
        }
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
        //this.elem[usedSize] = null;
        return;
    }
    public void clear(){
        this.usedSize = 0;
//        for (int i = 0; i < this.usedSize; i++) {
//            this.elem[i] = null;
//        }
//        this.usedSize = 0;

    }

}
