//알고리즘 수업 - 피보나치 수 1
//https://www.acmicpc.net/problem/24416
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt1=0;
	static int cnt2=0;
	static int fib(int n) {
		if(n==1 || n==2) {
			cnt1++;
			return 1;
		}
		else
			return (fib(n-1)+fib(n-2));
	}
	
	static int fibonacci(int n) {
		int f[]=new int[n];
		f[0]=f[1]=1;
		for(int i=2; i<n; i++) {
			f[i]=f[i-1]+f[i-2];
			cnt2++;
		}
		return f[n-1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		fib(n);
		fibonacci(n);
		
		System.out.println(cnt1+" "+cnt2);
	}

}
