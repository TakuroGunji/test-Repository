import java.util.Scanner;
class SearchIdx {
	static int serchIdx (int[] a, int n ,int key,int[] idxx)
	{
		int pl = 0;
		int pr = n-1;
		
		do{
			int pc = (pl + pr)/2;
			if(a[pc] == key)
				return pc;
			else if (a[pc] < key)
				pl = pc + 1;
			else
				pr = pc -1;
			
		}while(pl <= pr);
		
		return -1; //探索失敗
	}
	
	static int searchIdx(int []a,int n, int key ,int [] idx){
		int id=0;
		
		for(int i=0; i <= n; i++){
			if(i == n){
				return id;
			}
			
			else if(a [i] == key){
				idx[id] = a[i];
								id++;
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("要素数:");
		int num = stdIn.nextInt();
		
		int [] x = new int[num];
		int [] d = new int[num];  //一致するインデックスを先頭fから格納
		
		System.out.println("入力してください");
		
		System.out.print("x[0]:");
		x[0] = stdIn.nextInt();
		
		for(int i = 1; i < num; i++){
		
				System.out.println("x["+i+"]:");
				x[i] = stdIn.nextInt();
		}
			
		
	System.out.print("探す値:");
	int ky = stdIn.nextInt();
	
	
	
	int idx = searchIdx(x, num,ky,d);
	
	if(idx == -1)
		System.out.println("その値の要素は存在しません。");
	else
		System.out.println("その値は"+ idx +"個存在します。");
}
		}

