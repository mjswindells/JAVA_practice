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
        System.out.println("DVD ��� ����!");
    }
    public void stop(){
        System.out.println("DVD ��� ����!");
    }
    public void slow(){
        System.out.println("DVD ���� ��� ����!");
    }
}

class PR9_Ex1 {
    public static void main(String[] args) {
        DVDPlayer9 d = new DVDPlayer9();
        Player9 p = new DVDPlayer9();
        ExPlayer9 e = new DVDPlayer9();

        System.out.println("*** DVDPlayer�� ���� d ***");
        d.play();
        d.stop();
        d.slow();

        System.out.println("*** Player�� ���� p ***");
        p.play();
        p.stop();

        System.out.println("*** ExPlayer�� ���� e ***");
        e.play();
        e.stop();
        e.slow();
    }
}


//2
//abstract
//�߻�Ŭ����

abstract class Shape9{
    private String name;
    public Shape9(String name){this.name=name;}
    public String getName(){return name;}
    //�߻�޼ҵ� : �ٸ�Ŭ������ ��ӵ� �� �׻� �������̵带 ������Ѵ�
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
            System.out.println(a.getName() + "���� : " + a.getArea());
            sum += a.getArea();
            }
        System.out.println("������ �� : " + sum);
    }
}


//3



class PR9_Ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            System.out.print("x�� : ");
            int x = scan.nextInt();
            System.out.print("y�� : ");
            int y = scan.nextInt();

            System.out.println("x * y = " + mul(x, y));
            System.out.println("x / y = " + div(x, y));
            //InputMismatchException : �Է��� ���� ��ġ�� ���� �ʴ´�
        }catch (InputMismatchException e){
            //printStackTrace() : ������ ���� ����Ʈ�Ѵ�.
            e.printStackTrace();
            //ArithmeticException : �������� ������ ĳġ�Ѵ�. ex) ������ 0
        }catch (ArithmeticException e){
            e.printStackTrace();
            //finally : ������ �����Ѵ�. ĳġ�� �ǵ� �ȵǵ�
        }finally{
            System.out.println("���α׷��� �����մϴ�.");
        }
        scan.close();

    }
    public static int mul(int x, int y){ return x*y;}
    public static int div(int x, int y){ return x/y;}
}
