import java.util.Scanner;


//1

class myEx_Ex1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("두 개의 정수 입력 : ");
        int A =sc.nextInt();
        int B =sc.nextInt();

        System.out.println("\n"+A+"의 "+B+"승 = "+(int)Math.pow(A, B));
        sc.close();
    }
}


//2

class ArrayUtilMM{
    public static int[] calc(int A[],int B[],int C[]){
        int[] answer=new int[A.length];
        for(int i=0;i<A.length;i++){
            answer[i]=A[i];
        }

        for(int i=0;i<answer.length;i++){
            for(int j=0;j<B.length;j++){
                if(answer[i]==B[j]){answer[i]=-3000000;}
            }
        }
        for(int i=0;i<answer.length;i++){
            for(int j=0;j<C.length;j++){
                if(answer[i]==C[j]){answer[i]=-3000000;}
            }
        }
        int check=0;
        for(int i=0;i<answer.length;i++){
            if(answer[i]==-3000000){check++;}
        }
        check=answer.length-check;
        int[] R = new int[check];
        int j=0;
        for(int i=0;i<answer.length;i++){
            if(answer[i]!=-3000000){R[j++]=answer[i];}
        }

        return R;
    }
}

class myEx_Ex2 {
    public static void main(String[] args) {
        int[] A = { 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };
        int[] B = { 3, 2, 1, -1 };
        int[] C = { 5, 3, 2, 1, -3 };
        int[] R = ArrayUtilMM.calc(A, B, C);
        System.out.print("A - (B U C) = { " + R[0]);
        for (int i = 1; i < R.length; i++){
            System.out.print(", " + R[i]);
        }
        System.out.println(" }");
  }
}


//3

class TVMM{
    private int size;
    public TVMM(int size){this.size=size;}

    int getSize() { return size; }
    void setSize(int size) { this.size = size; }
}

class SmartTVMM extends TVMM{
    String ipAddr;
    public SmartTVMM(int size, String ipAddr) {
        super(size);    this.ipAddr = ipAddr;
    }
    int getSize() { return getSize(); }
    void setSize(int size) { super.setSize(size); }
    String getIpAddr () { return ipAddr; }
    void setIpAddr (String ipAddr)
    { this. ipAddr = ipAddr; }
}

class WideTVMM extends TVMM{
    boolean videoIn;
    public WideTVMM(int size, boolean videoIn) {
        super(size);    this.videoIn = videoIn;
    }
    int getSize() { return getSize(); }
    void setSize(int size) { super.setSize(size); }
    boolean getVideoIn() { return videoIn; }
    void setVideoIn(boolean videoIn)
    { this.videoIn = videoIn; }
}

//4

class BookMM{
    private String name;
    private int won,page;

    public BookMM(String name,int won, int page){
        this.name=name;
        this.won=won;
        this.page=page;
    }
    public String getTitle(){return name;}
    public String show(){
        return getTitle()+" "+won+"원 "+page+"페이지";
    }
}

class myEx_Ex4 {
    public static void main(String[] args) {
   BookMM[] b = { new BookMM("Java", 20000, 200),
   new BookMM("cpp", 15000, 150),
   new BookMM("Cpgm", 10000, 100),
   new BookMM("DB", 25000, 250),
   new BookMM("Python", 16000, 160)
    };
    int f = 0;
   for (int i = 0; i < b.length; i++) {
    if (b[i].getTitle().compareToIgnoreCase(b[f].getTitle()) < 0)
   f = i;
   }
   System.out.println("First : "+ b[f].show());
    }
} 


//5


class myEx_Ex5 {
    public static void main(String[] args) {
    String str = "123";
    System.out.println(str+"는 숫자입니까? "+isNumber(str));
    str = "1234x";
    System.out.println(str+"는 숫자입니까? "+isNumber(str));
    }

    public static boolean isNumber(String str){
        for(int i =0;i<str.length();i++){
            if(str.substring(i, i+1).equals("0")){continue;}
            if(str.substring(i, i+1).equals("1")){continue;}
            if(str.substring(i, i+1).equals("2")){continue;}
            if(str.substring(i, i+1).equals("3")){continue;}
            if(str.substring(i, i+1).equals("4")){continue;}
            if(str.substring(i, i+1).equals("5")){continue;}
            if(str.substring(i, i+1).equals("6")){continue;}
            if(str.substring(i, i+1).equals("7")){continue;}
            if(str.substring(i, i+1).equals("8")){continue;}
            if(str.substring(i, i+1).equals("9")){continue;}
            else return false;
        }
        return true;
    }
}