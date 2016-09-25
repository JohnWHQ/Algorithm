class IsContaintTree
{
  public static void main(String[] args) {
  	ProduceTree  p1 = new ProduceTree();
    ProduceTree  p2 = new ProduceTree();
    TreeNode t1 = p1.head;
    TreeNode t2 = p2.head;
    System.out.println(ContaintTree(t1,t2));
    System.out.println(AbsoluteSubTree(t1,t2));


  } 

// 检测t1是否包含与t2
  public static boolean ContaintTree(TreeNode t1 , TreeNode t2){
  	if (t1 == null || t2 == null) {
  		return false;
  	}
  	return checkContaint(t1,t2) || ContaintTree(t1.right,t2) || ContaintTree(t1.left,t2);
  }

  public static boolean checkContaint(TreeNode t1 , TreeNode t2){
  	if (t2 == null) {
  		return true ;
  	}
  	if (t1 == null || t1.value != t2.value) {
  		return false ;
  	}
  	return checkContaint(t1.left,t2.left) && checkContaint(t1.right,t2.right);
  }

  // 检测t2是t1的完整拓扑结构
  public static boolean AbsoluteSubTree(TreeNode t1 , TreeNode t2){
  	if (t1 == null) {
  		return false;
  	}
  	return checkAbsolute(t1,t2) || AbsoluteSubTree(t1.right,t2) || AbsoluteSubTree(t1.left,t2);
  }

  public static boolean checkAbsolute(TreeNode t1 , TreeNode t2){
  	if (t1 == null && t2 == null) {
  		return true ;
  	}
  	if (t1 == null || t2 ==null) {
  		return false;
  	}
  	if (t1.value != t2.value) {
  		return false ;
  	}
  	return checkAbsolute(t1.left,t2.left) && checkAbsolute(t1.right,t2.right);
  }

}








/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        
        boolean flag=false;
        

        if(root1==null||root2==null)
        {
         return false;
        }
        
       if(root1.val==root2.val)
       {
         flag=doesIsSubtree(root1,root2);
       }
        if(!flag)
        {
           flag = HasSubtree(root1.left,root2); 
            if(!flag)
             {
                 flag=HasSubtree(root1.right,root2);   
             }
        }
        return flag;
       
        
        
    }
    public boolean doesIsSubtree(TreeNode root1,TreeNode root2)
    {
        if(root2==null){
            return true;
        }
        if(root1==null||root1.val!=root2.val){
            return false;
        }
      
     
      return doesIsSubtree(root1.right,root2.right)&&doesIsSubtree(root1.left,root2.left);  
    }    
}
*/