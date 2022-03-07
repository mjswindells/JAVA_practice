//1

class TV4 {
    private String tvname;
    private int tvyear;
    private int tvsize;

    public TV4(String brand,int year,int size){
        tvname=brand;
        tvyear =year;
        tvsize = size;
    }
    public void show(){
        System.out.println(tvname+"에서 만든 "+tvyear+"년형 "+tvsize+"인치 TV");
    }    
}
class PR4_Ex01 {    
    public static void main(String[] args){
        TV4 myTV = new TV4("LG",2017,32);
        myTV.show();
    }
}

//2

class Song4{
    private String title, artist, country;
    private int year;
    public Song4(String title1,String artist1,int year1, String country1){
        title= title1;
        artist=artist1;
        year=year1;
        country=country1;
    }
    public void show(){
        System.out.println(year+"년 "+country+" 국적의 "+artist+"가 부른 "+title);
    }
}
class PR4_Ex02 {
    public static void main(String[] args){
        Song4 mySong=new Song4("Dancing Queen","ABBA",1978,"스웨덴" );
        mySong.show();
    }
}

//3

class Rectangle32{
    private int x, y, width, height;
    public Rectangle32(int X,int Y, int Width, int Height){
        x=X;
        y=Y;
        width=Width;
        height=Height;
    }
    public int square(){return width*height;}
    public void show(){
        System.out.println("("+x+","+y+")에서 크기가"+width+"x"+height+"인 사각형");
    }
    public boolean contains(Rectangle32 r){
        int right = x+width, up=y+height;
        int r_right=r.x+r.width,r_up=r.y+r.height;
        return (x<r.x&&y<r.y&&right>r_right&&up>r_up);
    }
}

class PR4_Ex03 {
    public static void main(String[] args){
        Rectangle32 r = new Rectangle32(2, 2, 8, 7);
        Rectangle32 s = new Rectangle32(5, 5, 6, 6);
        Rectangle32 t = new Rectangle32(1, 1, 10, 10);
        r.show();
        System.out.println("s의 면적은 " + s.square());
        if (t.contains(r))
        System.out.println("t는 r을 포함합니다.");
        if (t.contains(s))
        System.out.println("t는 s를 포함합니다.");
    }
}

//4

class Circle1{
    private double radius;
    private String name;
    private final double PI=3.14;
    
    public Circle1(String Name,double Radius){
        setRad(Radius);  name=Name;
    } 
    public void setRad(double r){
        if(r<0) {radius=0;  return;}
        radius=r;
    }
    public String getName(){return name;}
    public double getArea(){return radius*radius*PI;}
    public void show(){
        System.out.println(getName()+"넓이:"+getArea());
    }
}

class PR4_Ex04 {
    public static void main(String[] args){
        Circle1 c1 = new Circle1("Pizza", 0);
        Circle1 c2 = new Circle1("donut", 0);
        Circle1 c3 = new Circle1("hamburger", 0);
        c1.setRad(12);
        c2.setRad(-2);
        c3.setRad(7);
        String maxA=c1.getArea()>c2.getArea() ? c1.getArea()>c3.getArea() ?c1.getName():c3.getName():c2.getArea()>c3.getArea()?c2.getName():c3.getName();
        c1.show();
        c2.show();
        c3.show();
        System.out.println("가장 큰 면적은 "+maxA);
    }
    
}

//5

class Calc4{
    private int x,y;
    private char operator;
    
    public void setValue(int a, int b, char oper){
        x=a;    y=b;    operator=oper;
    }

    public void result(){
        if (operator=='+') System.out.println("result = "+add());
        else if(operator=='-') System.out.println("result = "+sub());
        else if(operator=='*') System.out.println("result = "+mul());
        else if(operator=='/') System.out.println("result = "+div());
        else System.out.println("잘못된 연산자입니다.");

    }
    public int add(){return x+y;}
    public int sub(){return x-y;}
    public int mul(){return x*y;}
    public int div(){return x/y;}

}

class PR4_Ex05 {
    public static void main(String[] args){
        Calc4 c = new Calc4();
        c.setValue(2, 5, '+');
        c.result();
        c.setValue(2, 5, '$');
        c.result();
        c.setValue(2, 5, '-');
        c.result();
        c.setValue(2, 5, '*');
        c.result();
        c.setValue(2, 5, '/');
        c.result();
    }
}
