package map_set;

import java.util.*;

public class Test {
    public static Map<Integer,Integer> func(int[] array){
        Map<Integer,Integer> map = new HashMap<>();
        for(int x: array){
            if(map.get(x) == null){
                map.put(x,1);
            }else {
                int val = map.get(x);
                map.put(x,val+1);
            }
        }
        return map;
    }
    public static Set<Integer> func2(int[] array){
        HashSet<Integer> set = new HashSet<>();
        for(int x:array){
            set.add(x);
        }
        return set;
    }
    public static int func3(int[] array){
        HashSet<Integer> set = new HashSet<>();
        for(int x:array){
            if(set.contains(x)){
                return x;
            }
            set.add(x);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = new int[1_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        Map<Integer,Integer> map = func(array);
        System.out.println(map);


    }
    public static void main2(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(set);

    }
    public static void main1(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("abc",3);
        map.put("bit",2);
        map.put("hello",4);
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for(Map.Entry<String,Integer> entry:entrySet){
            System.out.println(entry.getKey() +"-->"+entry.getValue());
        }
        /*System.out.println(map);
        Set<String> set = map.keySet();
        System.out.println(set);*/

        /*int ret = map.getOrDefault("bit2",98);
        System.out.println(ret);
        Integer ret2 = map.remove("bit");
        System.out.println(ret2);
        System.out.println(map);*/


    }
}



class qqwq{
    public static void func(String strExce,String strActual){
        HashSet<Character> set = new HashSet<>();
        for(char ch :strActual.toUpperCase().toCharArray()){
            set.add(ch);
        }
        HashSet<Character> broken = new HashSet<>();

        for(char ch :strExce.toUpperCase().toCharArray()){
            if(!set.contains(ch) && !broken.contains(ch)){
                System.out.print(ch);
                broken.add(ch);
            }
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            func(str1,str2);

        }
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:words){
            if(map.get(s) == null){
                map.put(s,1);
            }else{
                int val = map.get(s);
                map.put(s,val+1);
            }
        }

        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(k,new Comparator<Map.Entry<String,Integer>>(){

            public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
                if(o1.getValue().compareTo(o2.getValue())==0){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue() - o2.getValue();
            }
        });

        PriorityQueue<Map.Entry<String,Integer>> minheap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return 0;
            }
        });

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            }else{
                Map.Entry<String,Integer> top = minHeap.peek();
                if(top.getValue().compareTo(entry.getValue()) == 0){
                    if(top.getKey().compareTo(entry.getKey()) >0){
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }else{
                    if(top.getValue().compareTo(entry.getValue()) <0){
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for(int i = 0;i<k;i++){
            Map.Entry<String,Integer> top = minHeap.poll();
            ret.add(top.getKey());

        }
        Collections.reverse(ret);
        return ret;



    }
}
