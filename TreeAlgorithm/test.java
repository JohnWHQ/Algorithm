import java.util.Scanner;
class test
{
   public static void main(String args[] )
   {
       // System.out.println("hello new Mac");
    ProduceTree t = new ProduceTree();
    TreeNode head = t.head;
    // System.out.println(SerialorReSerialTree.levelTraceSerial(head));
    // TreeNode test = SerialorReSerialTree.RelevelTraceSerial(SerialorReSerialTree.levelTraceSerial(head));
    // System.out.println(SerialorReSerialTree.preTraceSerial(test));
    System.out.println(SerialorReSerialTree.preTraceSerial(
      SerialorReSerialTree.RelevelTraceSerial("1!2!3!4!#!5!6!#!#!7!8!#!#!#!#!#!#!") ) );
    System.out.println(SerialorReSerialTree.preTraceSerial(head));


   }
 
}

    // System.out.println(TraceTreeUtils.preTraceSerial(head));
    // TraceTreeUtils.preTreeByReturn(TraceTreeUtils.RepreTraceSerial(TraceTreeUtils.preTraceSerial(head)));
// import java.util.Scanner;

// /**
//  * Created by mango on 16/7/13.
//  */
// public class test {

//     public static void main(String[] args) {

        
//         while (true){
// 			Scanner sc=new Scanner(System.in);
//             String str=sc.nextLine();
//             int n=Integer.parseInt(sc.nextLine());

//             // int n1=sc.nextInt();
//             // int n2=sc.nextInt();
//             // str=actString(str,n1,n2);

//             // int n3=sc.nextInt();
//             // int n4=sc.nextInt();
//             // str=actString(str,n3,n4);
//             for(int i=0;i<n;i++){
//                 int n1=sc.nextInt();
//                 int n2=sc.nextInt();
//                 str=actString(str,n1,n2);
//             }
            
//             System.out.println(str);
//         }
//     }

//     public static String actString(String str,int n1,int n2){
//         if(n2>str.length()-1)
//             n2=str.length()-1;
//         if(n1<0)
//             n1=0;
//         String s=str.substring(n1,n2+1);
//         str+=reverse(s);
//         return str;
//     }

//     public static String reverse(String str){
//         char[] chars=str.toCharArray();
//         for(int i=0;i<(str.length()+1)/2;i++){
//             char c=chars[i];
//             chars[i]=chars[str.length()-1-i];
//             chars[str.length()-1-i]=c;
//         }
//         return String.valueOf(chars);
//     }

// }
