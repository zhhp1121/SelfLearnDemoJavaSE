
public class FrogStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int result = caculate(32);
		int result = stepNM(1,10);
//		result = fun(8);
//		result = fun3(4);
		System.out.println(result);
	}

	public static int fun(int stair){	
		if(stair == 1){
			return 1;		
		}else if(stair == 2){	
			return 2;		
		}else{		
			return fun(stair - 1)+fun(stair - 2);	
		}	
	}
	
	public static int fun3(int stair){	
		if(stair == 1){		
			return 1;	
		}else if(stair == 2){	
			return 2;		
		}else if(stair == 3){	
			return 4;//3级台阶总共有4种走法	
		}else{		
			return fun3(stair-1)+fun3(stair-2)+fun3(stair-3);	
		}	
	}
		
	
	private static int caculate(int n) {
		if(n <= 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 2;
		}else {
			return 2*caculate(n-1);
		}
	}
	
	public static int stepNM(final int n,final int m){
		if(m <= 0) {
			return 1;
		}else if(m == 1) {
			if(n >=1) {
				return 1;
			}else {
				return 0;
			}
		}else if(m == 2) {
			if(n < 1) {
				return 0;
			}else if(n==1) {
				return 1;
			}else if(n>=2) {
				return 2;
			}
		}else if(n >= m) {
			return 2*stepNM(n,m-1);
		}else {
       	 	return 2*stepNM(n,m-1) - stepNM(n,m-n-1);
        }
		return -1;
    }
}
