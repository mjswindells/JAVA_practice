import java.util.*;
import java.util.function.*;


//1

class PR13_Ex1 {
    public static void main(String[] args) {
        showAll("FACEBOOK");
        showAll("APPLE", "MICROSOFT");
        showAll("AMAZON", "APPLE", "GOOGLE");

        Company13 a = Company13.valueOf("AMAZON");
        System.out.println(a.price());
    }
    public static void showAll(String...vargs){
        for(String s:vargs){
            Company13 ans = Company13.valueOf(s);
            // System.out.println((ans.ordinal()+1)+"위 "+ans.name()+" 기업가치 "+ans.getValue());
            System.out.println(ans);
        }
        System.out.println("세계 기업가치Top5 중에서 "+vargs.length+"개 기업이 있습니다.\n");
    }
}

//enum에서의 추상메소드활용도 가능하다
enum Company13{
    AMAZON("170조"){String price(){return getValue();}},
     APPLE("165조"){String price(){return this.getValue();}},
     GOOGLE("136조"){String price(){return this.getValue();}},
     FACEBOOK("101조"){String price(){return this.getValue();}},
     MICROSOFT("91조"){String price(){return this.getValue();}};
    private final String value;
    Company13(String value){ this.value=value; }

    public String getValue(){return value;}
    abstract String price();
    public String toString(){return ordinal()+1+"위 "+name()+" 기업가치 "+getValue();}
}



//2


class Pr13_Ex2 {
    public static void main(String[] args) {
        List<Person13> list = new ArrayList<>();
        list.add(new Person13("Yoon", 23));
        list.add(new Person13("Hong", 53));
        list.add(new Person13("Kim", 37));
        list.add(new Person13("Park", 67));
        list.add(new Person13("Lee", 15));

        //람다식을 이용하여 int값인 age를 이용하여 정렬
        //List를 사용할 때는 무조건 Collections.sort를 사용해야함 Arrays.sort 사용불가.
        Collections.sort(list, (p1,p2)->p1.age-p2.age);
        System.out.println("*** 나이순 정렬 ***");
        for(Person13 s:list){
            System.out.println(s);
        }

        System.out.println("\n*** 이름순 정렬 ***");
        //람다식을 이용하여 String값인 name을 이용하여 정렬
        Collections.sort(list, (p1,p2)->p1.name.compareTo(p2.name));
        for(Person13 s:list){
            System.out.println(s);
        }
    }
}
   
class Person13 {
    String name;
    int age;
    
    public Person13(String name, int age) {
        this.name = name; this.age = age;
    }
    public String toString() { return name + " : " + age; }
}


//3



class PR13_Ex3 {
    public static void main(String[] args){

        //100~199까지의 값을 int값으로 리턴
        IntSupplier is=()->{
            Random rand = new Random();
            // 0~99
            return rand.nextInt(100)+100;
        };
        // Supplier<Integer> is=()->{
        //     Random rand = new Random();
        //     return rand.nextInt(100)+100;
        // };


        //int의 각 자리수를 더한 값 리턴
        IntUnaryOperator iuo= x->{
            int ans=0;
            while(true){
                if (x==0) break;
                ans+=x%10;
                x/=10;
            }
            return ans;
        };

        
        List<Integer> list=makeRandomList(is, 10);
        System.out.println(list);
        sumDigits(iuo, list);
        System.out.println(list);
        //람다식으로 list에서 10보다 큰값 제거
        list.removeIf(n->n>=10);
        // Predicate<Integer> ip = i -> i>=10;
        // list.removeIf(ip);
        System.out.println(list);
    }

    //size크기의 List를 리턴 단, IntSupplier s 기준으로
    static <T> List<Integer> makeRandomList(IntSupplier s, int size) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            list.add(s.getAsInt());
        }
        return list;
    }
    // static <T> List<T> makeRandomList(Supplier<T> s, int size) {
    //     List<T> list = new ArrayList<>();
    //     for(int i=0;i<size;i++){
    //         list.add(s.get());
    //     }
    //     return list;
    // }

    //IntUnaryOperator u 기준으로 모든 인덱스의 list값을 바꿈
    static void sumDigits(IntUnaryOperator u, List<Integer> list) {
        for(int i=0;i<list.size();i++){
            int temp = u.applyAsInt(list.remove(i));
            list.add(i,temp);
            //int temp = u.applyAsInt(list.get(i));
            //list.set(i,temp);
        }
    }
}