import java.util.*;
class SerialorReSerialTree
{
   // 二叉树前序遍历序列化
   public static String preTraceSerial(TreeNode head){
       if(head == null){
        return "#!";
       }
       String str ;
       str = head.value + "!";
       str = str + preTraceSerial(head.left);
       str = str + preTraceSerial(head.right);
       return str;
   }
  // 反前序遍历序列化
   public static TreeNode RepreTraceSerial(String s){
       String[] arr = s.split("!");
       Queue<String> q  = new LinkedList<String>();
       for (int i = 0;i <arr.length ;i++) {
           q.add(arr[i]);
       }
       return rePreS(q);
   }
   public static TreeNode rePreS(Queue<String> q){
         String s = q.poll();
         if(s.equals("#")){
            return null;
         }
         TreeNode head = new TreeNode(Integer.valueOf(s));
         head.left = rePreS(q);
         head.right = rePreS(q);
         return head;
   }

  // 层序遍历序列化
   public static String levelTraceSerial(TreeNode head){
        if (head == null) {
          return "#!";
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        String str = head.value + "!";
        q.add(head);
        TreeNode node;
        while (!q.isEmpty()) {
          node = q.poll();
          if (node.left != null) {
            str = str + node.left.value + "!";
            q.add(node.left);
          }
          else{
            str = str + "#!";
          }
          if (node.right != null) {
            str = str + node.right.value + "!";
            q.add(node.right);
          }
          else{
            str = str + "#!";
          }
        }
        return str;
   }
  // 反层序遍历序列化
   public static TreeNode RelevelTraceSerial(String s){
        String[] arr = s.split("!");
        Queue<String> qs = new LinkedList<String>();
        for (int i = 0;i<arr.length ;i++ ) {
          qs.add(arr[i]);
        }

        TreeNode head  = null;

        Queue<TreeNode> qt = new LinkedList<TreeNode>();

        TreeNode node ;
        qt.add(new TreeNode( Integer.valueOf(qs.poll()) ));

        while(!qs.isEmpty()){
          node = qt.poll();
          head = head != null ? head : node;
          TreeNode tmp ;
          String stmp;
          stmp = qs.poll();
          if (!stmp.equals("#")) {
            tmp = new TreeNode(Integer.valueOf(stmp));
            node.left = tmp;
            qt.add(tmp);
          }
          else{
            node.left =null;
          }
          stmp = qs.poll();
          if (!stmp.equals("#")) {
            tmp = new TreeNode(Integer.valueOf(stmp));
            node.right = tmp;
            qt.add(tmp);
          }
          else{
            node.right = null;
          }
        }
        return head;
   }


} 


