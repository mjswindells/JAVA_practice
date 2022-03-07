import java.util.*;

class Ex1 {
    public static void main(String[] args){
        int sum=0;
        int i=1;
        int count=0;
        boolean check=true;
        while(true){
            if(check==true){
                check=false;
                sum+=(i++);
                count++;
            }
            else{
                check=true;
                sum-=(i++); 
                count++;
            }    
            if(sum>=100){break;}        
        }
        System.out.println("num="+count);
        System.out.println("sum="+sum);
    }
}



//2

class Ex2 {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        sb.append("Strawberry Grape Pear Apple");
        System.out.println(sb);
        sb.replace(17,50,"");
        System.out.println(sb);
        sb.replace(10,23," Pear Grape");
        System.out.println(sb);
        sb.replace(0,10,"Apple");
        System.out.println(sb);
    }
}


//3

class Ex3 {
    static public void main(String [] args) {
        Shape [] list = { new Circle(20),
        new Oval(20, 30), new Rect(20, 30)};
        for (Shape a : list)
            a.draw();
        for (Shape a : list)
            System.out.println("면적은 " + a.getArea());
    }
}

interface Shape {
    final double PI = 3.14;
    void draw();
    double getArea();
}
class Circle implements Shape{
    int rad;
    Circle(int r){
        this.rad=r;
    }
    public void draw(){
        System.out.println("반지름이 "+rad+"인 원입니다.");
    }
    public double getArea(){
        return PI*rad*rad;
    }
}
class Oval implements Shape{
    int x;
    int y;
    Oval(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void draw(){
        System.out.println(x+"X"+y+"에 내접하는 타원입니다.");
    }
    public double getArea(){
        return PI*x*y;
    }
}
class Rect implements Shape{
    int x;
    int y;
    Rect(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void draw(){
        System.out.println(x+"X"+y+"크기의 사각형입니다.");
    }
    public double getArea(){
        return x*y;
    }
}


//4

class Ex4 {
    public static void main(String[] args) {
        int size=10;
        GQueue<String> stringQueue = new GQueue<>(size);
        stringQueue.enqueue("seoul");
        stringQueue.enqueue("busan");
        stringQueue.enqueue("LA");

        for(int i=0; i<size; i++) {
            String str = stringQueue.dequeue();
            if(str != null) System.out.println(str);
        }

        GQueue<Integer> intQueue = new GQueue<>(size);
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);

        for(int i=0; i< size; i++) {
            Integer is = intQueue.dequeue();
            if(is != null) System.out.println(is);
        }
    }
}

class GQueue<T>{
    private int size;
    private Object[] array;
    int capacity;

    public GQueue(int capacity){
        this.array=new Object[capacity];
        this.capacity=0;
        this.size=0;
    }
    public void enqueue(T item){
        if(size==array.length) return;
        array[size++]=item;
    }

    public T dequeue(){
        if(size==capacity) return null;
        return (T)array[capacity++];
    }
}

//5



class Ex5 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("????˝?", 100, 100, 100));
        list.add(new Student("??????", 90, 70, 80));
        list.add(new Student("??????", 80, 80, 90));
        list.add(new Student("??????", 70, 90, 70));
        list.add(new Student("??????", 60, 100, 80));
        Collections.sort(list);
        System.out.println("?¤ˇ? 1");
        for(Student s : list)
        System.out.println(s);
        System.out.println("?¤ˇ? 2");
        Collections.sort(list,(p1,p2)->p1.name.compareTo(p2.name));
        for(Student s : list)
        System.out.println(s);
    }
}

class Student implements Comparable<Student>{
    String name;
    int num1;
    int num2;
    int num3;

    Student(String name,int a, int b, int c){
        this.name=name; 
        num1=a; num2=b; num3=c;
    }
    public String toString() {
        int sum= num1+num2+num3;
         return name + " : " + sum+" ("+num1+","+num2+","+num3+")"; 
    }
    @Override
    public int compareTo(Student p2) {
        int numa = num1+num2+num3;
        int numb = p2.num1+p2.num2+p2.num3;
        return numa-numb;
    }
}


