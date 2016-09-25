class renum{
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,0};
		System.out.println(mergesort(a,0,a.length-1));
		
	}
	public static int mergesort(int[] arr,int start,int end){
		int lc = 0;
		int rc = 0;
		int mc = 0;
		if (start < end) {
           int mid = (start + end)/2;
           lc = mergesort(arr,start,mid);
           rc = mergesort(arr,mid+1,end);
		   mc = merge(arr,start,mid,end);
		}
		return lc + rc + mc; 

	}
	public static int merge(int[] arr,int start,int mid,int end){
		int[] tmp = new int[arr.length];
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
        return count;
	}
}