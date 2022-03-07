import java.util.*;


//1


class PR12_Ex1 {
    public static void main(String[] args) {
        List<Person12> list = new ArrayList<>();
        list.add(new Person12("Yoon", 23));
        list.add(new Person12("Hong", 53));
        list.add(new Person12("Kim", 37));
        list.add(new Person12("Park", 67));
        list.add(new Person12("Lee", 15));
        Collections.sort(list);
        //Comparable �̿��Ͽ� ���̼����� ����
        System.out.println("*** ���̼� ���� ***");
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }

        Collections.sort(list, new PersonComparator12());
        //Collections.sort(list,(Person12 p1,person12 p2)->p1.name.compareTo(p2.name));
        //Comparator �̿��Ͽ� �̸������� ����
        System.out.println("\n*** �̸��� ���� ***");
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
   
class PersonComparator12 implements Comparator<Person12>{
    public int compare(Person12 p1,Person12 p2){
        return p1.name.compareTo(p2.name);
    }
}

class Person12 implements Comparable<Person12>{
    String name;
    int age;
    
    public Person12(String name, int age) {
         this.name = name; this.age = age;
    }
    public String toString() { return name + " : " + age; }
    @Override
    public int compareTo(Person12 o) {
        return this.age-o.age;
    }
}


//2



class PR12_Ex2 {
    public static void main(String[] args) {
        //Arrays.asList : �ʱⰪ ����
        List<Integer> a =new ArrayList<>();
        a.add(1);a.add(5);a.add(3);a.add(4);a.add(2);
        System.out.println(a);
        //HashSet�� ����ҋ� comaparable �����ϸ� �����ؼ� �����ִ°� ����.
        Set<Integer> A = new HashSet<>(a);
        Set<Integer> B = new HashSet<>((Arrays.asList(2, 4, 6, 8, 10)));
        Set<Integer> C = new HashSet<>((Arrays.asList(2, 3, 5, 7, 11)));
        Set<Integer> D = new HashSet<>((Arrays.asList(1, 3, 5, 7, 9))); 

        System.out.println("A = "+A);
        System.out.println("B = "+B);
        System.out.println("C = "+C);
        System.out.println("D = "+D);
        A.removeAll(B);
        System.out.println("A - B = "+A);
        C.retainAll(D);
        System.out.println("C �� D = "+C);
        A.addAll(C);
        System.out.println("(A - B) U (C �� D) = "+A);
    }
}
   


//3


class PR12_Ex3 {
    public static void main(String[] args) {
        //Treeset : �ڵ����� ���ĵȴ�.
        TreeSet<Integer> set = new TreeSet<>();
        //SortedSet �ڵ����� �������ִ� set(comparable�̳� comparator �����ø�)
        SortedSet<Integer> subset;

        set.add(80); set.add(100); set.add(70);
        set.add(85); set.add(98); set.add(83);
        
        System.out.println("���� ���� ���� :"+set.first());
        System.out.println("���� ���� ���� :"+set.last());
        System.out.println("90�� �Ʒ� ���� :"+set.lower(90));
        System.out.println("90�� �� ���� :"+set.higher(90));

        //true, false �� ������ ����
        subset=set.subSet(70,true,90,true);
        System.out.println("70������ 90�� ���� ���� :"+subset);
        //headSet(value,TF) value���� ���� ������ set���� ����
        subset=set.headSet(85,false);
        System.out.println("85�� ������ ���� :"+subset);
        subset=set.tailSet(85,true);
        System.out.println("85�� �̻��� ���� : "+subset);
    }
}



//4



class PR12_Ex4 {
    public static void main(String[] args) {
        String[] data = { "A", "K", "A", "K", "D", "A", 
        "K", "K", "K", "Z", "D" };
        HashMap<String, Integer> map = new HashMap<>();

        //�迭�� ������ HashMap���� �����ϴ� ����
        for(String o:data){
            if(map.containsKey(o)) {
                int count = map.get(o);
                map.put(o,count+1);
            }
            else{map.put(o,1);}
        }

        //HashMap�� Ű���� list�� ��ȯ
        List<String> keylist = new ArrayList<>(map.keySet());

        Collections.sort(keylist);

        //��� ���
        for(String s:keylist){
            System.out.println(s+" : "+map.get(s));
        }

        //Iterator<String> itr = keylist.iterator();
        // while(itr.hasNext()){
        //     String k = itr.next();
        //     System.out.println(k+" : "+map.get(k));
        // }
    }
}