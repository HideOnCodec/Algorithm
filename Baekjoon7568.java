import java.util.Scanner;

public class Main{
	
	void Grade(int N,int[][] arr) {
		int grade[]= new int[N];
		int x,y,p,q;
		for(int i=0; i<N; i++)
			grade[i]=1;
		
		for(int i=0; i<N; i++) {
			x=arr[i][0];
			y=arr[i][1];
			for(int j=0; j<N; j++) {
				if(i!=j) {
					p=arr[j][0];
					q=arr[j][1];
					if(x<p && y<q)
						grade[i]++;
				}
			}
		}
		for(int i=0; i<N; i++)
			System.out.print(grade[i]+" ");
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main Main = new Main();
		
		int N = scanner.nextInt();
		int[][] arr=new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0]=scanner.nextInt();
			arr[i][1]=scanner.nextInt();
		}
		
		Main.Grade(N,arr);

	
		scanner.close();
	}

}
