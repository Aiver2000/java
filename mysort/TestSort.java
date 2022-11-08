package mysort;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class TestSort {

    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void shell(int[] array,int gap){
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >= 0; j-=gap) {
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    public static void shellSort(int[] array){
        int gap = array.length;
        while(gap >1){
            shell(array,gap);
            gap /= 2;
        }
        shell(array,1);
    }

    public static void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[i]){
                    swap(array,i,j);
                }
            }
        }
    }
    public static void selectSort1(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }
    public static void test1(int capacity){
        int[] array = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long start = System.currentTimeMillis();
        //insertSort(array);
       // shellSort(array);
        //selectSort(array);
        heapSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public static void test2(int capacity){
        int[] array = new int[capacity];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(capacity);
        }
        long start = System.currentTimeMillis();
        //insertSort(array);
//        shellSort(array);
        //selectSort(array);
        heapSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }


    public static void heapSort(int[] array){
        createHeap(array);
        int end = array.length-1;
        while (end>0){
            swap(array,0,end);
            shitDown(array,0,end);
            end--;
        }
    }
    public static void createHeap(int[] array){
        for (int parent = (array.length-1-1)/2; parent >=0 ; parent--) {
            shitDown(array,parent,array.length);
        }
    }
    public static void shitDown(int[] array,int parent,int len){
        int child = 2*parent +1;
        while(child < len){
            if(child +1 <len && array[child] < array[child+1]){
                child++;
            }
            if(array[child] > array[parent]){
                swap(array,child,parent);
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            boolean flg = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]){
                    swap(array,j,j+1);
                    flg = true;
                }
            }
            if(flg == false){
                break;
            }

        }
    }

    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }

    public static void insertSort2(int[] array,int start,int end){
        for (int i = 1; i < end; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void quick(int[] array,int start,int end){
        if(start >= end){
            return;
        }
        if(end-start+1 <= 40){
            //使用直接插入排序
            insertSort2(array,start,end);
            return;
        }
        int minValIndex = findMidValIndex(array,start,end);
        swap(array,start,minValIndex);

        int pivot = partition(array,start,end);
        quick(array,0,pivot-1);
        quick(array,pivot,end);

    }
    private static int findMidValIndex(int[] array,int start,int end){
        int mid = start+((end-start) >>>1);
        if(array[start] <array[end]){
            if(array[mid] < array[start]){
                return start;
            }else if(array[mid] > array[end]){
                return end;
            }else {
                return mid;
            }
        }else {
            if(array[mid] >array[start]){
                return start;
            }else if(array[mid] < array[end]){
                return end;
            }else {
                return mid;
            }
        }
    }

    private static int partition(int[] array,int left,int right){
        int tmp = array[left];
        while (left < right){
            while (left < right && array[right] >= tmp ){
                right--;
            }
            array[left] = array[right];
            while(left < right &&array[left] <= tmp){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = tmp;
        return left;

    }

    public static void quickSortNull(int[] array){
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length-1;
        int pivot = partition(array,left,right);
        if(pivot > left+1){
            stack.push(left);
            stack.push(pivot-1);
        }
        if(pivot < right-1){
            stack.push(pivot+1);
            stack.push(right);
        }
        while(!stack.isEmpty()){
            right = stack.pop();
            left = stack.pop();
            pivot = partition(array,left,right);
            if(pivot > left+1){
                stack.push(left);
                stack.push(pivot-1);
            }
            if(pivot < right-1){
                stack.push(pivot+1);
                stack.push(right);
            }
        }
    }
    public static int[] mergeArray(int[] array1,int[] array2){
        int[] tmp = new int[array1.length+array2.length];
        int k = 0;
        int s1 = 0;
        int e1 = array1.length-1;
        int s2 = 0;
        int e2 = array2.length-1;
        while (s1<= e1 && s2<=e2){
            if(array1[s1] <= array2[s2]){
                tmp[k++] = array1[s1++];
            }else {
                tmp[k++] = array2[s2++];
            }
        }

        while(s1<=e1){
            tmp[k++] = array1[s1++];
        }
        while (s2<=e2){
            tmp[k++] = array2[s2++];
        }
        return tmp;

    }

    public static void mergeSort(int[] array){
        mergeSortFunc(array,0,array.length-1);
    }
    private static void mergeSortFunc(int[] array,int low,int high){
        if(low>=high){
            return ;
        }
        int mid = low+((high-low) >>>1);
        mergeSortFunc(array,low,mid);
        mergeSortFunc(array,mid+1,high);
        merge(array,low,mid,high);
    }
    private static void merge(int[] array,int low,int mid,int high){
        int[] tmp = new int[high-low+1];
        int k = 0;
        int s1 = low;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = high;
        while (s1<= e1 && s2<=e2){
            if(array[s1] <= array[s2]){
                tmp[k++] = array[s1++];
            }else {
                tmp[k++] = array[s2++];
            }
        }
        while(s1<=e1){
            tmp[k++] = array[s1++];
        }
        while (s2<=e2){
            tmp[k++] = array[s2++];
        }
        for (int i = 0; i < k; i++) {
            array[i+low] = tmp[i];
        }

    }
    public static void mergeSort2(int[] array){
        int gap = 1;
        while(gap<array.length){
            for (int i = 0; i < array.length ; i+=gap/2) {
                int left = i;
                int mid = left+gap-1;
                if(mid >= array.length){
                    mid = array.length-1;
                }
                int right = mid+gap;
                if(right >= array.length){
                    right = array.length-1;
                }
                merge(array,left,mid,right);
            }
            gap *= 2;
        }
    }

    public static void countintSort(int[] array){
        int maxVal = array[0];
        int minVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < minVal){
                minVal = array[i];
            }
            if(array[i] > maxVal){
                maxVal = array[i];
            }
        }
        int[] count = new int[maxVal-minVal +1];
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - minVal;
            count[index]++;
        }

        int indexArray = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0){
                array[indexArray] = i+minVal;
                count[i] --;
                indexArray++;
            }
        }
    }







    public static void main(String[] args) {
        test1(10_0000);
        test2(10_0000);

    }
    public static void main1(String[] args) {
        int[] array = {12,4,5,456,42,77,3,1};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }


}
