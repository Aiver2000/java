import java.util.*;


class My_ArrayList<E>{
    private E[] elem;
    private int usedSize;

    public My_ArrayList(){
        this.elem =(E[]) new Object[10];
    }
    public void add(E val){
        this.elem[usedSize] = val;
        usedSize++;
    }
    public E get(int pos){
        return this.elem[pos];
    }
}
public class test {
    public static String func(String str){
        StringBuilder stringBuilder = new StringBuilder();
        int[] array = new int[58];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(array[ch-65 ] == 0){
                stringBuilder.append(ch);
                array[ch-65] = 1;
            }
        }
        return stringBuilder.toString();
    }
    public static String func1(String str){
        StringBuilder stringBuilder  = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!stringBuilder.toString().contains(ch+"")){
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

}
class Student {
    private String name;
    private String classes;
    private double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }

}
class Card{
    private int rank;
    private String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "[" +
                suit +
                 " "+ rank  +
                ']';
    }
}


class Test3{
    private static final String[] suits = {"♥","♣","♠","♦"};
    public static List<Card> buyCard(){
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13 ; j++) {
                String suit = suits[i];
                int rank = j;
                Card card = new Card(rank,suit);
                cards.add(card);
            }
        }
        return cards;
    }

    private static void swap(List<Card> cards,int i,int j){
        Card tmp = cards.get(i);
        cards.set(i,cards.get(j));
        cards.set(j,tmp);
    }
    private static void shuffle(List<Card> cards){
        int size = cards.size();
        for (int i = size-1; i >0 ; i--) {
            Random random = new Random();
            int rand = random.nextInt(i);
            swap(cards,i,rand);
        }

    }

    public List<List<Integer>> generate (int numRows){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        lists.add(list0);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> preRow = lists.get(i-1);
            for (int j = 1; j < i; j++) {
                int num1 = preRow.get(j) +preRow.get(j-1);
                list.add(num1);
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }
    public static void main(String[] args) {

    }
    public static void main10(String[] args) {
        List<Card> cards = buyCard();
        System.out.println("买牌"+cards);
        shuffle(cards);
        System.out.println("洗牌"+cards);

        System.out.println("揭牌:三人每人五张"+cards);

        ArrayList<ArrayList<Card>> hand = new ArrayList<>();
        ArrayList<Card> hand0 = new ArrayList<>();
        ArrayList<Card> hand1 = new ArrayList<>();
        ArrayList<Card> hand2 = new ArrayList<>();
        hand.add(hand0);
        hand.add(hand1);
        hand.add(hand2);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = cards.remove(0);
                hand.get(j).add(card);
            }
        }
        System.out.println("第1个人的牌"+hand0);

        System.out.println("第2个人的牌"+hand1);
        System.out.println("第3个人的牌"+hand2);
        System.out.println("剩下的牌"+cards);



    }
    public static void main9(String[] args) {
        ArrayList<Character> arrayList = new ArrayList<>();
        String str1 = "hello to bit";
        String str2 = "come";
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")) {
                arrayList.add(ch);
            }
        }
        for(char ch : arrayList){
            System.out.print(ch);
        }
    }
    public static void main8(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        //Collections.sort(integers);
        Collections.reverse(integers);

        System.out.println(integers);

    }
    public static void main7(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("lqx","102",99.9));
        students.add(new Student("huya","100",44.0));
        students.add(new Student("zjy","102",66.4));
        students.add(new Student("lyf","100",88.9));
        students.add(new Student("wuyifan","102",45.3));
        System.out.println(students);


    }
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //func(str);
    }
    public static void main5(String[] args) {
        My_ArrayList<String> myArrayList = new My_ArrayList<>();
        System.out.println(myArrayList);
        My_ArrayList<Integer> myArrayList1 = new My_ArrayList<>();
        System.out.println(myArrayList1);
        My_ArrayList<Boolean> myArrayList2 = new My_ArrayList<>();
        System.out.println(myArrayList2);
        myArrayList.add("123");
        myArrayList.add("kekeaiai");
        String ret = myArrayList.get(1);
        System.out.println(ret);
        myArrayList1.add(12);
        myArrayList1.add(33);
        Integer ret1 = myArrayList1.get(1);
        System.out.println(ret1);



    }
    public static void main4(String[] args) {
        My_ArrayList myArrayList = new My_ArrayList();
        myArrayList.add(1);
        myArrayList.add("hello");
        String ret =(String) myArrayList.get(4);
        System.out.println(ret);

    }



    public static void main3(String[] args) {
        Map<Integer,String> map = new TreeMap<>();
        map.put(3,"456");

        map.put(1,"456");
        System.out.println(map);
    }

    public static void main2(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("国民女神","高圆圆");
        map.put("及时雨","松江");

        String ret = map.getOrDefault("国民女神1","博哥");
        System.out.println(ret);
        boolean flg = map.containsKey("国民女神");
        System.out.println(flg);
        System.out.println(map);

        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for (Map.Entry<String,String> e:
             entrySet) {
            System.out.println(e.getKey()+e.getValue());
        }




        Map<String,String> map2 = new TreeMap<>();




    }
    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        System.out.println(collection);
        Collection<Integer> collection1 = new ArrayList<>();
        collection1.add(123);
        collection1.add(5);
        Object[] objects= (Object[])collection.toArray();
        System.out.println(Arrays.toString(objects));
//        System.out.println(collection1);
//        collection.clear();
//        System.out.println(collection);
//        System.out.println(collection.isEmpty());





    }
}
