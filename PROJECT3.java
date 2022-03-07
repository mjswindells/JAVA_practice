class PR3_EX01 {
    public static void main(String[] args){
        int count_8 = 0, count_9 = 0;
        for(int i=1;i<100;i++){
            if((i%8==0)&&(i%9==0)) break;
            else if(i%8==0) count_8++;
            else if(i%9==0) count_9++;
        }
        System.out.println("8의 배수:"+count_8+"개");
        System.out.println("9의 배수:"+count_9+"개");
    }
}

class PR3_EX02 {
    public static void main(String[] args){
        for(int i=2;i<10;i++){
            for(int j=1;j<i+1;j++){
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
}

class PR3_EX03 {
    public static void main(String[] args){
        char a = 'e';
        for (int i = (int)(a-'a')+1; i>0; i--){
            for(int j=(int)('a');j<(int)('a'+i);j++){
                System.out.print((char)j);
            }
            System.out.println();
        }
    }
}

class PR3_EX04 {
    public static void main(String[] args) {
       int number1 = 12321, number2 = 1232, result;
       result = palindrome(number1);
       resultPrint(number1, result);
       result = palindrome(number2);
       resultPrint(number2, result);
    }
   public static void resultPrint(int num1, int num2) {
       if (num1 == num2)
            System.out.println(num2 + "는 회문수 입니다.");
       else
           System.out.println(num2 + "는 회문수가 아닙니다.");
   }

   public static int palindrome(int num) {
       int value =0;
       for(int i = (int)(Math.log10(num)+1); i>0; i--){
           value+=(num%10)*(Math.pow(10,i-1)); num/=10;
       }
       return value;
   }
}

class PR3_EX05 {
    public static void main(String[] args){
        for(int i=0;i<6;i++){
            System.out.println("f("+i+")="+recursion(i));
        }
    }
    public static int recursion(int n){
        if (n==0) return 1;
        else return (recursion(n-1)<<1)+1; 
    }
}
