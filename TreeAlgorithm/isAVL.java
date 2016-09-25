class isAVL{
    public static void main(String[] args) {
          
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        check(root,res,1);
        return res[0];
        
    }
    public static int check(TreeNode root,boolean[] res,int h){
        if(root == null){
            return h;
        }
        int l = check(root.left,res,h+1);
        if(!res[0]){
            return h;
        }
        int r = check(root.right,res,h+1);
        if(!res[0]){
            return h;
        }
        if(l-r>1 || r-l>1){
            res[0] =false;
        }
        return Math.max(l,r);
    }

}
// public class Solution {
//     public boolean IsBalanced_Solution(TreeNode root) {
//         if(root==null)
//         {
//           return true;  
//         }
//         int l=TreeDepth(root.left);
//         int r=TreeDepth(root.right);
//         int n=l-r;
//         if(n>1||n<-1)
//         {
//          return false;   
//         }
//         return IsBalanced_Solution(root.right)&&IsBalanced_Solution(root.left);
        
//     }
//     public int TreeDepth(TreeNode root) {
//         if(root==null)
//         {
//           return 0; 
//         }
//         int r =TreeDepth(root.right);
//         int l =TreeDepth(root.left);
        
//         return  (r>l)?(r+1):(l+1); 
         
//     }
// }