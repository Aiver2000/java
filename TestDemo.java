import java.util.Arrays;

public class TestDemo {


    /**
     * 【数组】偶数放在奇数前面
     * @param array
     */
    public static void func(int[] array){
        int i = 0;
        int j = array.length-1;
        while(i<j){
            while (array[i]%2 ==0 && i<j){
                i++;
            }
            while (array[j]%2 !=0 && j>i){
                j--;
            }
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }


    /**
     * [拷贝数组] for
     * [2]Array.copyOf
     * [3] array.clone() 产生一个副本
     * [4] 。。。native
     *
     * 深浅拷贝：人为实现
     * 深：拷贝后两数据互不影响 ----多拷贝一份对象
     * 浅：拷贝后，修改一个会影响另一个
     * @param array
     * @return
     */
    public static int[] copyArray(int[] array){
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }


    public static void main(String[] args) {
        int[][] array = {{1,2},{1,2,3}};
        for (int[] ret :array) {
            for(int x:ret){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        int[][] array2 = new int[2][];
        System.out.println(Arrays.deepToString(array2));

    }
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        int[][] array1 = {{1,2,3},{4,5,6}};
        int[][] array2 = new int[][] {{1,2,3},{1,2,3}};
        int[][] array3 = new int[2][];
        //int[] copy = array.clone();
        for(int i = 0;i<array1.length;i++){
            for (int j = 0; j < array1[i].length; j++) {
                System.out.print(array1[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("=======================");
        for (int[] ret :array1) {
            for(int x:ret){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        System.out.println("=======================");

        System.out.println(Arrays.deepToString(array1));
        //System.out.println(Arrays.toString(array1));

    }
}