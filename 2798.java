import java.util.Scanner;


public class Main {
	
	int BlackJack(int M, int[] arr) {
		int max=0;
		for(int i=0; i<arr.length-2; i++) {
			for(int j=i+1; j<arr.length-1; j++) {
				for(int z=j+1; z<arr.length; z++) {
					int sum=arr[i]+arr[j]+arr[z];
					if(sum<=M) {
						if(max<=sum)
							max=sum;
					}
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
		Main Main = new Main();
		
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int arr[]= new int[N];
		
		for(int i=0; i<N; i++) 
			arr[i]=scanner.nextInt();
		System.out.println(Main.BlackJack(M,arr));
		
		
		scanner.close();
	}

}
