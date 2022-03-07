

//1

class GStack11<T>{
    private int size;
    //private T[] array;
    private Object[] array;

    public GStack11(int capacity){
        //this.array=(T[])new Object[capacity];
        this.array=new Object[capacity];
        this.size=0;
    }
    public void push(T item){
        if(size==array.length) return;
        array[size++]=item;
    }

    public T pop(){
        if(size==0) return null;
        //return array[--size];
        return (T)array[--size];
    }
}

class MyStack11 {
    public static void main(String[] args) {
        int size=10;
        GStack11<String> stringStack = new GStack11<String>(size);

        stringStack.push("seoul");
        stringStack.push("busan");
        stringStack.push("LA");

        for(int i=0; i<size; i++) {
            String str = stringStack.pop();
            if(str != null) System.out.println(str);
        }

        GStack11<Integer> intStack = new GStack11<Integer>(size);
        intStack.push(1);
        intStack.push(3);
        intStack.push(5);

        for(int i=0; i<size; i++) {
            Integer is = intStack.pop();
            if(is != null) System.out.println(is);
        }
    }
}


//2

class PairGen11<K,V>{
    private K key;
    private V value;

    PairGen11(K key,V value){
        this.key = key;
        this.value = value;
    }
    public K getkey(){ return this.key;}
    public V getvalue(){return this.value;}
}

class CompareGen11{
    public static<K,V> boolean compare(PairGen11<K,V> p1,PairGen11<K,V> p2){
        return p1.getkey().equals(p2.getkey())&&p1.getvalue().equals(p2.getvalue());
    }
}

class PR11_Ex2 {
    public static void main(String[] args) {
        PairGen11<String, Integer> p1 = new PairGen11<>("Apple", 3);
        PairGen11<String, Integer> p2 = new PairGen11<>("Apple", 3);
        System.out.println(CompareGen11.compare(p1, p2));
        
        PairGen11<String, String> p3 = new PairGen11<>("°´Ã¼ÁöÇâ", "Java");
        PairGen11<String, String> p4 = new PairGen11<>("°´Ã¼ÁöÇâ", "C++");
        System.out.println(CompareGen11.compare(p3, p4));
    }
}
   


//3

class PR11_Ex3 {
    public static void main(String[] args) {
        Integer[] ArrayOne = { 1, 2, 3, 4, 5 };
        Double[] ArrayTwo = { 3.0, 4.0, 1.5, 2.5, 1.5 };
        Long[] ArrayThree = { 7L, 8L, 9L, 10L };

        System.out.println(getAverage(ArrayOne));
        System.out.println(getAverage(ArrayTwo));
        System.out.println(getAverage(ArrayThree));
    }
    public static <T extends Number> double getAverage(T[] arr){
        double answer=0;
        for(int i =0;i<arr.length;i++){
            answer += Double.valueOf(arr[i]+"");
            //answer +=arr[i].doubleValue();
        }
        answer/=arr.length;
        return answer; 
    }
}
