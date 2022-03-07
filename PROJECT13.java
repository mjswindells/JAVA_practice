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
            // System.out.println((ans.ordinal()+1)+"�� "+ans.name()+" �����ġ "+ans.getValue());
            System.out.println(ans);
        }
        System.out.println("���� �����ġTop5 �߿��� "+vargs.length+"�� ����� �ֽ��ϴ�.\n");
    }
}

//enum������ �߻�޼ҵ�Ȱ�뵵 �����ϴ�
enum Company13{
    AMAZON("170��"){String price(){return getValue();}},
     APPLE("165��"){String price(){return this.getValue();}},
     GOOGLE("136��"){String price(){return this.getValue();}},
     FACEBOOK("101��"){String price(){return this.getValue();}},
     MICROSOFT("91��"){String price(){return this.getValue();}};
    private final String value;
    Company13(String value){ this.value=value; }

    public String getValue(){return value;}
    abstract String price();
    public String toString(){return ordinal()+1+"�� "+name()+" �����ġ "+getValue();}
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

        //���ٽ��� �̿��Ͽ� int���� age�� �̿��Ͽ� ����
        //List�� ����� ���� ������ Collections.sort�� ����ؾ��� Arrays.sort ���Ұ�.
        Collections.sort(list, (p1,p2)->p1.age-p2.age);
        System.out.println("*** ���̼� ���� ***");
        for(Person13 s:list){
            System.out.println(s);
        }

        System.out.println("\n*** �̸��� ���� ***");
        //���ٽ��� �̿��Ͽ� String���� name�� �̿��Ͽ� ����
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

        //100~199������ ���� int������ ����
        IntSupplier is=()->{
            Random rand = new Random();
            // 0~99
            return rand.nextInt(100)+100;
        };
        // Supplier<Integer> is=()->{
        //     Random rand = new Random();
        //     return rand.nextInt(100)+100;
        // };


        //int�� �� �ڸ����� ���� �� ����
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
        //���ٽ����� list���� 10���� ū�� ����
        list.removeIf(n->n>=10);
        // Predicate<Integer> ip = i -> i>=10;
        // list.removeIf(ip);
        System.out.println(list);
    }

    //sizeũ���� List�� ���� ��, IntSupplier s ��������
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

    //IntUnaryOperator u �������� ��� �ε����� list���� �ٲ�
    static void sumDigits(IntUnaryOperator u, List<Integer> list) {
        for(int i=0;i<list.size();i++){
            int temp = u.applyAsInt(list.remove(i));
            list.add(i,temp);
            //int temp = u.applyAsInt(list.get(i));
            //list.set(i,temp);
        }
    }
}