class RevesePair{
	public static void main(String[] args) {
		int[] arr = {5,3,1,2,6,-1};
		System.out.println(InversePairs(arr));
	}
    public static int InversePairs(int [] array) {
        
        int[] tmp = new int[array.length];
        for(int i = 0; i < array.length; i++){
        	tmp[i] = array[i];
        }
        int res = mergesort(array,tmp,0,array.length-1);
        return res%1000000007;
    }
	public static int mergesort(int[] arr,int[] tmp,int start,int end){
		int lc = 0;
		int rc = 0;
		int mc = 0;
		if (start < end) {
           int mid = (start + end)/2;
           lc = mergesort(arr,tmp,start,mid);
           rc = mergesort(arr,tmp,mid+1,end);
		   mc = merge(arr,tmp,start,mid,end);
		}
		return lc + rc + mc; 

	}
	public static int merge(int[] arr,int[] tmp,int start,int mid,int end){
        int l = start;
        int r = mid+1;
        int index = l;
        int count = 0;
        while (l<=mid && r<=end) {
        	if (arr[l]<arr[r]) {
        		tmp[index++] = arr[l++];
        	}else {
                count = count + mid - l +1;
        		tmp[index++] = arr[r++];
        	}
        }
        while(l<=mid){
        	tmp[index++] = arr[l++];
        }
        while(r<=end){
        	tmp[index++] = arr[r++];
        }
        for (int i = start;i <= end ; i++) {
        	arr[i] = tmp[i];
        }
        return (count % 1000000007) ;
	}	
}