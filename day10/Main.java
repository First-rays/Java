package day10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String addend = sc.next();
        String augend = sc.next();

        AddLongInter(addend,augend);

    }

    private static String AddLongInter(String addend,String augend){
        StringBuffer stringBuffer = new StringBuffer();

        int i = addend.length()-1;
        int j = augend.length()-1;
        Integer tem = 0;
        while(i>=0&&j>=0){
            tem = 0;
            Integer a = Integer.parseInt(addend.charAt(i)+"");
            Integer b = Integer.parseInt(augend.charAt(j)+"");
            if(a+b+tem == 10){
                stringBuffer.append(0);
                tem = 1;
            } else if(a+b<10){
                stringBuffer.append(a+b);
            }
            i--;
            j--;
        }
        if(tem == 1){
            if(i<0 && j>=0){
                stringBuffer.append(Integer.parseInt(augend.charAt(j)+"")+1);
                if(j-1<=0){
                    return stringBuffer.reverse().toString();
                }
                stringBuffer.append(augend.substring(0,j-1));
            } else{
                stringBuffer.append(Integer.parseInt(addend.charAt(j)+"")+1);
                if(i-1<=0){
                    return stringBuffer.reverse().toString();
                }
                stringBuffer.append(addend.substring(0,i-1));
            }
        } else{
            if(i<0 && j>=0){
                stringBuffer.append(augend.substring(0,j));
            } else{
                stringBuffer.append(addend.substring(0,i));
            }
        }

        return stringBuffer.reverse().toString();
    }

}
