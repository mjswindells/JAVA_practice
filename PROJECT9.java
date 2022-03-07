import java.util.InputMismatchException;
import java.util.Scanner;

//1 
//interface    implements

interface Player9{
    public void play();
    public void stop();
}

interface ExPlayer9 extends Player9{
    public void slow();
}

class DVDPlayer9 implements ExPlayer9{
    public void play(){
        System.out.println("DVD 재생 시작!");
    }
    public void stop(){
        System.out.println("DVD 재생 종료!");
    }
    public void slow(){
        System.out.println("DVD 느린 재생 시작!");
    }
}

class PR9_Ex1 {
    public static void main(String[] args) {
        DVDPlayer9 d = new DVDPlayer9();
        Player9 p = new DVDPlayer9();
        ExPlayer9 e = new DVDPlayer9();

        System.out.println("*** DVDPlayer형 변수 d ***");
        d.play();
        d.stop();
        d.slow();

        System.out.println("*** Player형 변수 p ***");
        p.play();
        p.stop();

        System.out.println("*** ExPlayer형 변수 e ***");
        e.play();
        e.stop();
        e.slow();
    }
}


//2
//abstract
//추상클래스

abstract class Shape9{
    private String name;
    public Shape9(String name){this.name=name;}
    public String getName(){return name;}
    //추상메소드 : 다른클래스에 상속될 때 항상 오버라이드를 해줘야한다
    public abstract double getArea();
}

class Circle9 extends Shape9{
    private int r;
    public Circle9(String name, int r){
        super(name);    this.r=r;
    }
    @Override
    public double getArea(){return r*r*3.14;}
}

class Rectangle9 extends Shape9{
    private int x, y;
    public Rectangle9(String name,int x,int y){
        super(name);    this.x=x;   this.y=y;
    }
    @Override
    public double getArea(){return x*y;}
}

class Triangle9 extends Shape9{
    private int x, y;
    public Triangle9(String name,int x,int y){
        super(name);    this.x=x;   this.y=y;
    }
    @Override
    public double getArea(){return x*y/2.0;}
}

class PR9_Ex2 {
    public static void main(String[] args) {
        Shape9[] arr = { new Circle9("Circle", 5), 
            new Rectangle9("Rectangle", 3, 4), 
            new Triangle9("Triangle", 5, 5) 
            };
                
        double sum = 0;
        for (Shape9 a : arr) {
            System.out.println(a.getName() + "면적 : " + a.getArea());
            sum += a.getArea();
            }
        System.out.println("면적의 합 : " + sum);
    }
}


//3



class PR9_Ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            System.out.print("x값 : ");
            int x = scan.nextInt();
            System.out.print("y값 : ");
            int y = scan.nextInt();

            System.out.println("x * y = " + mul(x, y));
            System.out.println("x / y = " + div(x, y));
            //InputMismatchException : 입력한 값이 매치가 되지 않는다
        }catch (InputMismatchException e){
            //printStackTrace() : 오류를 전부 프린트한다.
            e.printStackTrace();
            //ArithmeticException : 수학적인 오류를 캐치한다. ex) 나누기 0
        }catch (ArithmeticException e){
            e.printStackTrace();
            //finally : 무조건 실행한다. 캐치가 되든 안되든
        }finally{
            System.out.println("프로그램을 종료합니다.");
        }
        scan.close();

    }
    public static int mul(int x, int y){ return x*y;}
    public static int div(int x, int y){ return x/y;}
}
