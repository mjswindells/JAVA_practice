import java.util.*;

//1


class PR10_Ex1 {
    public static void main(String[] args) {
        String s1 = "동해물과 백두산이 마르고 닳도록";
        String s2 = "2020/11/03";
        String s3 = "2020년11월03일";

        StringTokenizer st1 = new StringTokenizer(s1," ");
        StringTokenizer st2 = new StringTokenizer(s2,"/");
        StringTokenizer st3 = new StringTokenizer(s3,"년월일");
        int i=1;

        System.out.println("s1 count:"+st1.countTokens());
        while(st1.hasMoreTokens()){
            System.out.print(i++ + ":"); 
            System.out.println(st1.nextToken());
        }
        System.out.println();   i=1;

        System.out.println("s2 count:"+st2.countTokens());
        while(st2.hasMoreTokens()){
            System.out.print(i++ + ":");
            System.out.println(st2.nextToken());
        }
        System.out.println();   i=1;

        System.out.println("s3 count:"+st3.countTokens());
        while(st3.hasMoreTokens()){
            System.out.print(i++ + ":");
            System.out.println(st3.nextToken());
        }
    }
}


//2


class PR10_Ex2 {
    public static void main(String[] args){
        Random rand = new Random();
        int[] count = new int[10];

        for(int i=0;i<100;i++){
            int num = rand.nextInt(10);
            count[num]++;
            System.out.print(num);
            if(i%20==19) System.out.println();//줄바꿈
        }
        System.out.println("\n");

        for(int i=0; i<10;i++){
            System.out.print(i+"개수:");
            for(int j=0;j<count[i];j++){
                System.out.print("*");
            }
            System.out. println();
        }
    }
}
 

//3


class Circle10 {
    private String name;
    private int rad;
    Circle10(String name,int rad){
        this.name=name; this.rad=rad;
    }
    public String getName(){return name;}
    public int getrad(){return rad;}

    // @Override
    // public int compareTo(Circle10 o){
    //     Circle10 O= (Circle10)o;
    //     return this.rad-O.rad; 
    // }

    public String toString(){
        return this.name+" "+this.rad*this.rad*3.14;
    }
}

class PR10_Ex3 {
    public static void main(String[] args){
        Circle10[] c = { new Circle10("Cup", 3),
        new Circle10("Apple", 4),
        new Circle10("Doughnut", 5),
        new Circle10("Pizza", 7),
        new Circle10("Ball", 2) };

        //Arrays.sort(c);
        //Arrays.sort(c,(c1,c2)->c1.getrad()-c2.getrad());

        Comparator<Circle10> cp = (c1,c2) -> (c1.getName()).compareTo(c2.getName());
        //cp에 기준에서 ==0이 되는걸 찾아 리턴해준다. 왜 쓰냐면 Apple의 반지름을 모를경우 사용하면 좋다.
        int index = Arrays.binarySearch(c, new Circle10("Apple",0), cp);

        for(Circle10 n : c){ System.out.println(n); }
        System.out.println("Index of Apple :"+index);
    }
}
