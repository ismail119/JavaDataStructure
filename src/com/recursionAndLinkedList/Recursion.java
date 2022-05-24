package com.recursionAndLinkedList;

//Iterative > Recursion about performance. Eger kuculen yani tree, devide and conquer gibi bir durum yoksa iterative kullan.
// Russian Dolls ornegindeki gibi gittikce kuculen bir graphicte iterative varsa recursion kullanilir.
// Ornegin Tree,Fiboneacci, gibi

public class Recursion {

    //Basic Ornek:
    public static void RussianDolls(int doll){
        if(doll==1)
            System.out.println("All dolls opened!");
        else
            RussianDolls(doll-1);
    }

    /*
    Yapilacak islemler recursive olursa(yani fonksiyon icerisinde kendini cagirirsa) bilgisayar bir stack yapisi kurarak
    her yeni fonksiyonu cagirisinda bir oncekini stacke pushlar.En son istenilen duruma gelince teker teker fonksiyonlari
    tamamlar.
    */


    /*

        Stack:
        sout(AllDollsOpen)
        RussianDolls(2);        --> Seklinde stack olusturuldu.Ve asagi dogru kendini bitirecek.
        RussianDolls(3);
        RussianDolls(4);

     */

    //Stackli Ornek:
    public static void RussianDollsWithStack(int doll){
        if(doll==1){
            System.out.println("All dolls opened!");
        }
        else{
            RussianDollsWithStack(doll-1);
            System.out.println("Opened Doll Number: "+ doll);
        }
    }



    /*
    3 adim cok onemlidir
    1- Yapilacak islemi sag = sol seklinde bir equation olarak yazmaliyiz.
    2- Tekrar eden islemi bulmaliyiz
    3- Duracagi noktayi belirlemeliyiz.
    4- Errorlari engellemeliyiz
    */


    public static int Factorial(int n) {
        if (n<0) return -1;

        if (n == 0 || n == 1)
            return 1;
        else
            return n * Factorial(n - 1);
    }
    //Faktoriyel Ornegi:

    /*
    1- n! = n * (n-1)!
    2- Duracagi nokta n==0 yada n==1 olabilir.
    3- error verebilecegi nokta negatif sayi girilmesi olabilir
    */



    /*
        1- equation = 0 1 1 2 3 5 8 13 21... => Fibonacci(n) = Fibonacci((n-1)) + Fibonacci((n-2))
        2- Duracagi nokta = eger n = 0 o zaman return 0 yada n==1 o zaman return 1
        3- negatif sayi alamaz
    */

    public static int Fibonacci(int n){
        if(n<0)return -1;

        if(n==1)return 1;
        else if(n==0) return 0;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    //A function that gives sum of digit of any number
    public static int DigitSum(int number){
        if(number<=0)return -1;

        if(number<10)
            return number;
        else
            return number%10 + DigitSum(number/10);
    }

    //A function that find any power of any number
    public static int PowerOfNumber(int number,int power){
        if(power<0)return -1;
        if(power==0)
            return 1;
        else
            return number * PowerOfNumber(number,power-1);
    }


    //Euclidian Algorithm
    public static int GDC(int a,int b){
        if (b==0)
            return a;
        else
            return GDC(b,a%b);
    }

    //A function that convert decimal to binary
    public static void DecimalToBinary(int number) {
        if (number / 2 == 0)
            System.out.print(number%2);
        else {
            DecimalToBinary(number / 2);
            System.out.print(number%2);
        }
    }


    //A function that writes a string reversly
    public static String Reverse(String str)
    {
        if(str.isEmpty())return str;
        return Reverse(str.substring(1)) + str.charAt(0);
    }


    //A function that find is string Palindrome or not
    public static boolean isPalindrome(String s)
    {
        if(s.isEmpty()|| s.length()==1) return true;
        if(s.charAt(0)==(s.charAt(s.length()-1)))
            return isPalindrome(s.substring(1,s.length()-1));
        return false;
    }


    //A function that find First UpperCase in Any String
    static char First(String str) {
        if(str.isEmpty()) return ' ';

        if(Character.isUpperCase(str.charAt(0))){
            return str.charAt(0);
        }
        else{
            return First(str.substring(1));
        }
    }

    //Polyndrom or not
    public static boolean Polindrom(String str){
        if (str.isEmpty() || str.length()==1) return true;
        else
            if(str.charAt(0)==str.charAt(str.length()-1))
                return Polindrom(str.substring(1,str.length()-1));
        return false;
    }


    //A function that reverses the number
    public static int ReverseTheNumber(int number){
        if(Integer.toString(number).length()-1==0) return 1;
        return (number%10)*(int)Math.pow(10,Integer.toString(number).length()-1) + ReverseTheNumber(number/10);
    }

    //Number of digits
    public static int SumOfDigits(int number)
    {
        if(number<10)return number;
        return number%10 + SumOfDigits(number/10);
    }

}
