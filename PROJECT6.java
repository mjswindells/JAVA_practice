import java.util.Scanner;


//1

class Matrix1{

    public void printMatrix(int a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void addMatrix(int a[][],int b[][],int c[][]){
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[i].length;j++){
                 c[i][j]+=a[i][j]+b[i][j];
           }
        }
    }
}
class PR6_Ex01 {
    public static void main(String[] args){
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] b = { { 6, 3, 4 }, { 5, 1, 2 } };
        int[][] c = new int[2][3];
        Matrix1 mx = new Matrix1();
        System.out.println("행렬 a");
        mx.printMatrix(a);
        System.out.println("행렬 b");
        mx.printMatrix(b);
        System.out.println("행렬 c");
        mx.addMatrix(a, b, c);
        mx.printMatrix(c);
    }
}


//2


class Dictionary1 {
    private static String[] kor = { "사랑", "아기", "돈", "미래", "희망" };
    private static String[] eng = { "love", "baby", "money", "future", "hope" };

    public static String kor2Eng(String word) {
        for(int i=0;i<5;i++){
            if(kor[i].equals(word)) return word+"은"+eng[i];
        }
        return word.concat("는 저의 사전에 없습니다.");
        // if(kor[0].equals(word)){ return word + "은"+eng[0];}
        // else if (kor[1].equals(word)){ return word + "은"+eng[1];}
        // else if (kor[2].equals(word)){ return word + "은"+eng[2];}
        // else if (kor[3].equals(word)){ return word + "은"+eng[3];}
        // else if (kor[4].equals(word)){ return word + "은"+eng[4];}
        // else return word.concat("는 저의 사전에 없습니다.");
    }
}


class PR6_Ex02 {
    public static void main(String[] args){
        System.out.println("한영 단어 검색 프로그램입니다.");
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("한글 단어?");
            String answer = sc.nextLine();
            if(answer.equals("그만")){break;}
            else System.out.println(Dictionary1.kor2Eng(answer));
        }
        sc.close();
    }
}


//3

class Day1 {
    private String work;
    public void set(String work) { this.work = work; }
    public String get() { return work; }
    public void show() {
        if(work == null) System.out.print("없습니다.");
        else System.out.print(work + "입니다.");
    }
}

class MonthSchedule1{
    private static int month;
    private static Day1[] Work;
    private static Scanner sc = new Scanner(System.in);
    MonthSchedule1(int m){
        month=m; Work = new Day1[month+1];
        for(int i =0; i<m+1; i++){
            Work[i]=new Day1();
        }
    }

    public void input(){
        System.out.print("날짜(1~"+month+")?");
        int i = sc.nextInt();
        if(i<1||i>month){System.out.print("\n잘못입력하였습니다."); return;}
        else {
            if(Work[i].get() != null){
                System.out.print("할 일이 이미 있습니다.");
            }
            else{
                System.out.print("할일(빈칸없이입력)?");
                Work[i].set(sc.next());         //scanner가 다른형태를 받고 난 후엔 nextLine()말고 next()를 쓰자
            }
        }
    }

    public void view(){
        System.out.print("날짜(1~"+month+")?");
        int i = sc.nextInt();
        if(i<1||i>month){System.out.print("\n잘못입력하였습니다."); return;}
        else {
            System.out.print(i+"일의 할 일은 ");
            Work[i].show(); return;
        }
    }

    public void finish(){System.out.println("프로그램을 종료합니다.");}
}
   

class PR6_Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthSchedule1 ms = new MonthSchedule1(30);
        System.out.println("*** 이번달 스케쥴 관리 프로그램 ***");
        while (true) {
            System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
            int menu = scanner.nextInt();
            switch (menu) {
            case 1: ms.input(); break;
            case 2: ms.view(); break;
            case 3: ms.finish(); scanner.close(); return;
            default: System.out.println("잘못입력하였습니다.");
            }
            System.out.println();
        }
    }       
}
