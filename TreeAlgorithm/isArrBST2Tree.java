class isArrBST2Tree{
	public static void main(String[] args) {
		int[] test ;
        
        TreeNode res = getTreefromArr(test,0,test.length-1);
	}
	public static TreeNode getTreefromArr(int[] arr,int start ,int end){
        if (start > end) {
        	return null;
        }
		TreeNode head = new TreeNode(arr[end]);
        int l = -1;
        int r = end;
        for (int i=start;i<end;i++) {
        	if (arr[end] > arr[i]) {
        		l = i ;
        	}else{
        		r = r==end? i : r;
        	}
        }
        head.left = getTreefromArr(arr,start,l);
        head.right = getTreefromArr(arr,r,end-1);
        return head;
	}
}
/*
*
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0)
         {
           return false;  
         }
        int root =sequence[sequence.length-1];
        
        int i=0;
        for(;i<sequence.length-1;i++)
        {
            if(sequence[i]>root)
            {
              break;   
            }
                      
        }
        
        int j=i;
        for(;j<sequence.length-1;j++)
        {
            if(sequence[j]<root)
            {
              return false;  
            }
        }
        
        
        boolean left=true;
        boolean right=true;
        if(i>0)
        {
            //left=VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
            int lefta[]=new int[i];
            for(int p=0;p<i;p++)
            {
               lefta[p]=sequence[p]; 
            }
            left=VerifySquenceOfBST(lefta);
        }
        
       
        if(i<sequence.length-1)
        {
             int righta[]=new int[(sequence.length-1)-i];
             for(int p=0;p<(sequence.length-1)-i;p++)
            {
               righta[p]=sequence[i+p]; 
            }
         
            right=VerifySquenceOfBST(righta);   
            //right=VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length-1));
                   
        }
         
        return (left&&right);
        
    }
        public boolean VerifySquenceOfBST(int [] sequence) {
        if(squence == null || sequence.length == 0){
            return true;
        }
        int end = sequence.length;
        return check(sequence,0,end -1 );
    }
*/