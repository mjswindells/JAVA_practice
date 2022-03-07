//1

class PR5_Ex01{
    public static void main(String[] args){
        String text ="I love you";
        for(int i=0;i<text.length();i++){
            String s=text.substring(0,i+1);
            System.out.println(text.substring(i+1)+s);
        }
    }
}

//2

class CurrencyConverter5{
    private static double rate=1000;
    
    public static void setRate(double R){rate=R;}
    public static double getRate(){return rate;}
    public static double toDollar(double n){return n/rate;}
    public static double toKW(double n){return n*rate;}
}

class PR5_Ex02 {
    public static void main(String[] args) {
        CurrencyConverter5.setRate(1121);
        System.out.println("환율1달러 : " + CurrencyConverter5.getRate());
        System.out.println("백만원은 $" + 
       CurrencyConverter5.toDollar(1000000) + "입니다.");
        System.out.println("$120는 " + 
       CurrencyConverter5.toKW(120) + "원 입니다.");
    }       
}


//3

class PR5_Ex03 {
    public static void main(String[] args){
        String text1 = "eW"; 
        String text2 = "LOVE";
        String text3 = "C++";
        String text4 = "        programming.        ";

        StringBuilder textA= new StringBuilder(text1);
        
        textA.reverse();
        textA.append(' ').append(text2.toLowerCase());
        textA.append(' ').append(text3);
        textA.replace(8,12,"JAVA");
        textA.append(' ').append(text4.trim());

        System.out.println(textA.toString());
        }
}


//4

class Circle2{
    private int x,y,r;

    public Circle2(int X, int Y, int R){x=X;y=Y;r=R;}
    public Circle2(int R){this(0,0,R);}
    public Circle2(int X, int Y){this(X,Y,5);}

    public String toString(){
        return "Circle2("+x+","+y+") 반지름"+r;
    }
    public boolean equals(Circle2 t){
        if(x==t.x&&y==t.y) return true;
        else return false;
    }

}

class PR5_Ex04 {
    public static void main(String[] args){
        Circle2 a = new Circle2(2, 3, 30);
        Circle2 b = new Circle2(5);
        Circle2 c = new Circle2(2, 3);

        System.out.println("원 a : " + a);
        System.out.println("원 b : " + b);
        System.out.println("원 c : " + c);

        if (a.equals(b))
        System.out.println("같은 원");
        else
        System.out.println("서로 다른 원");
        if (a.equals(c))
        System.out.println("같은 원");
        else
        System.out.println("서로 다른 원");
    }
}


//5

class ExId5{
    private static int n=1;
    private static int Id=0;
    private int myId=0;

    public ExId5(){
        Id+=n;
        myId=Id;
    }
    
    public int getId(){return myId;}   
    public static int getStep(){return n;}
    public static void setStep(int N){n=N;}
    public static int getMaxId(){return Id;}
}

class PR5_Ex05 {
    public static void main(String args[]) {
        ExId5 a = new ExId5();
        ExId5 b = new ExId5();
        ExId5.setStep(3);
        ExId5 c = new ExId5();
        ExId5 d = new ExId5();
        System.out.println("a의 식별번호 : " + a.getId());
        System.out.println("b의 식별번호 : " + b.getId());
        System.out.println("c의 식별번호 : " + c.getId());
        System.out.println("d의 식별번호 : " + d.getId());
        ExId5.setStep(1);
        int max = ExId5.getMaxId();
        System.out.println("마지막 부여한 식별 번호 : " + max);
        System.out.println("다음에 부여할 식별 번호 : " + 
       (max+ExId5.getStep()));
        }
}
