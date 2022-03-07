class Point7 {
    private int x, y;
    public Point7(int x, int y) { 
        this.x = x; 
        this.y = y; 
    }
    public int getX() { return x; }
    public int getY() { return y; }
    protected void move(int x, int y) { 
        this.x = x; 
        this.y = y; 
    }
}


// 1

class ColorPoint extends Point7{
    private String color;

    public ColorPoint(int x, int y, String color){
        super(x,y);
        this.color=color;
    }
    public void setXY(int x, int y){move(x,y);}
    public void setColor(String color){this.color=color;}

    public String toString(){
        StringBuffer answer= new StringBuffer(); 
        answer.append(color).append("색의 (");
        answer.append(getX());
        answer.append(",");
        answer.append(getY());
        answer.append(")의 점입니다.");

        return answer.toString();
    }
}

class PR7_Ex1 {
    public static void main(String[] args) {
        ColorPoint cp = new ColorPoint(5, 5, "Yellow");
        cp.setXY(10, 20);
        cp.setColor("Red");
        String str = cp.toString();
        System.out.println(str + "입니다.");
    }
}


// 2


class Point3D extends Point7{
    private int z;

    public Point3D(int a, int b, int c){
        super(a,b);     this.z=c;
    }
    public int getZ(){return z;}
    public void moveUp(){z++;}
    public void moveDown(){z--;}
    public void move(int a, int b,int c){
        move(a,b);
        this.z=c;
    }

    public String toString(){
        StringBuffer answer = new StringBuffer();
        answer.append("(").append(getX()).append(",");
        answer.append(getY()).append(",").append(getZ());
        answer.append(")?? ??");
        return answer.toString();
    }
}

class PR7_Ex2 {
    public static void main(String[] args) {
    Point3D p = new Point3D(1, 2, 3); // x, y, z ??
    System.out.println(p.toString() + "????.");
    p.moveUp();// z ?????? ???? ???
    System.out.println(p.toString() + "????.");
    p.moveDown();// z ?????? ???? ???
    p.move(10, 10);// x, y ?????? ???
    System.out.println(p.toString() + "????.");
    p.move(100, 100, 100);// x, y, z ?????? ???
    System.out.println(p.toString() + "????.");
   }
}


// 3

class Shape7{
    private String name;
    private double area;

    public Shape7(String name){this.name=name;}
    public String getName(){return name;}
    public double getArea(){return area;}
}

class Circle7 extends Shape7{
    private int r;
    public Circle7(String name, int r){
        super(name);    this.r=r;
    }
    @Override
    public double getArea(){return r*r*3.14;}
}

class Rectangle7 extends Shape7{
    private int x, y;
    public Rectangle7(String name,int x,int y){
        super(name);    this.x=x;   this.y=y;
    }
    @Override
    public double getArea(){return x*y;}
}

class Triangle7 extends Shape7{
    private int x, y;
    public Triangle7(String name,int x,int y){
        super(name);    this.x=x;   this.y=y;
    }
    @Override
    public double getArea(){return x*y/2.0;}
}

class PE7_Ex3 {
    public static void main(String[] args) {
    Shape7[] arr = { new Circle7("Circle", 5), 
    new Rectangle7("Rectangle", 3, 4), 
    new Triangle7("Triangle", 5, 5) 
    };
    
    double sum = 0;
    for (Shape7 a : arr) {
   System.out.println(a.getName() + "???? : " + a.getArea());
   sum += a.getArea();
    }
    System.out.println("?????? ?? : " + sum);
    }
}
   