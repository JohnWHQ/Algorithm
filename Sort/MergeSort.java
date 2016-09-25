class MergeSort{
	public static void main(String[] args) {
		int[] test = {10,9,8,7,6,5,4,3,2,1};

		mergesort(test,0,test.length-1);
		for (int key : test) {
		  System.out.println(key);			
		}

	}
	public static void mergesort(int[] arr,int start,int end){
		if (start < end) {
           int mid = (start + end)/2;
           mergesort(arr,start,mid);
           mergesort(arr,mid+1,end);
		   merge(arr,start,mid,end);
		}
	}
	public static void merge(int[] arr,int start,int mid,int end){
		int[] tmp = new int[arr.length];
        int l = start;
        int r = mid+1;
        int index = l;
        while (l<=mid && r<=end) {
        	if (arr[l]<arr[r]) {
        		tmp[index++] = arr[l++];
        	}else {
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
	}
}