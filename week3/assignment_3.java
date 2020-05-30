import java.util.*;
import java.math.*;
public class assignment_3 {
    int return_prime(int i){
        BigInteger b=new BigInteger(String.valueOf(i));
        return Integer.parseInt( b.nextProbablePrime().toString());
    }

    String convert_hex(int i){
        return Integer.toHexString(i).toUpperCase();

    }

    public static void main(String[] args) {
        int i,j,k;
        char ch;
        assignment_3 a1=new assignment_3();
        ArrayList<ArrayList> arr=new ArrayList<ArrayList>();
        arr.add(new ArrayList());
        arr.get(0).add('A');
        arr.get(0).add(1);
        for(i=1;i<26;i++){
            j=Integer.parseInt(arr.get(i-1).get(1).toString());
            j=a1.return_prime(j);
            arr.add(new ArrayList());
            ch= (char)('A'+i);
            arr.get(i).add(ch);
            arr.get(i).add(j);
        }
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String ans="";
        for(i=0;i<s.length();i++){
            ch=s.charAt(i);
            j=ch-'A';
            if(i==s.length()-1){
                ans+=a1.convert_hex(Integer.parseInt(arr.get(j).get(1).toString()));
            }
            else{
                ans+=a1.convert_hex(Integer.parseInt(arr.get(j).get(1).toString()))+",";
            }
        }
        System.out.println(ans);
    }
}
