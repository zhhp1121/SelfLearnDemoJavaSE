
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(""+binarySearch(a,0,9,8));
	}

	private static int binarySearch(int[] a,int start,int end,int result) {
		if(start < end) {
			int middle = (start+end)/2;
			int middleValue = a[middle];
			if(middleValue < result) {
				start = middle+1;
			}else if(middleValue > result) {
				end = middle;
			}else {
				return middle;
			}
			return binarySearch(a,start,end,result);
		}
		return -1;
	}
}
