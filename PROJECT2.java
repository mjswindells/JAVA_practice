class pr1{
    public static void main(String[] args){
        System.out.println("안녕하세요!");
        System.out.print("저는 ");
        System.out.println("홍길동입니다.");
        System.out.println();
        System.out.println("반갑습니다.");
    }
}

class pr2 {
    public static void main(String[] args){
        System.out.println("안녕하세요!\n"+"저는 홍길동입니다.\n"+"\n반갑습니다.");
    }
}

class pr3 {
    public static void main(String[] args){
        int n1 = 100, n2 = 3;
        double result=(double)n1/n2;
        System.out.println("100/3 = "+result);
        System.out.println("100/3:몫"+n1/n2+",나머지"+n1%n2);

    }
}

class pr4 {
    public static void main(String[] args){
        int money = 65367;
        System.out.println("오만원\t:"+(money/50000)); money%=50000;
        System.out.println("만원\t:"+(money/10000));money%=10000;
        System.out.println("오천원\t:"+(money/5000));money%=5000;
        System.out.println("천원\t:"+(money/1000));money%=1000;
        System.out.println("오백원\t:"+(money/500));money%=500;
        System.out.println("백원\t:"+(money/100));money%=100;
        System.out.println("오십원\t:"+(money/50));money%=50;
        System.out.println("십원\t:"+(money/10));money%=10;
        System.out.println("일원\t:"+(money/1));money%=1;
    }
}

class pr5 {
    public static void main(String[] args){
        System.out.println("10진수 12\t:"+ 12);
        System.out.println("8진수 12\t:"+ 012);
        System.out.println("16진수 12\t:"+ 0x12);
        System.out.println("Sum\t  :"+ (12+012+0x12));
        System.out.println("Average\t  :"+ (12+012+0x12)/3);


        //String asd = null;
        //System.out.println(asd.length());
        //System.out.println(asd.getBytes().length);

        String temp="10진수 12",  tem="sum", temp3="한자ㄹ";// 한글은 3바이트, 나머지는 1바이트
        System.out.println(temp.length());
        System.out.println(temp.getBytes().length);
        System.out.println(tem.length());
        System.out.println(tem.getBytes().length);
        System.out.println(temp3.getBytes().length);
        System.out.println((int)(Math.log10(12321)+1));
    }
}

class pr6 {
    public static void main(String[] args){
        byte n1 = 0B101111, n2 = 0B10101;
        System.out.println("& 결과:"+(n1&n2));
        System.out.println("| 결과:"+(n1|n2));
    }
    
}

class pr7 {
    public static void main(String[] args){
        int num = 3;
        int result = (num << 4) - num;
        System.out.println("result:"+result);
    }
}
