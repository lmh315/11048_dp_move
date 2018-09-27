package q11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] map, memo;
	
	public static void main(String[] args) throws IOException {
		int i,j,n1,n2,n3;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		memo = new int[N][M];
		
		for(i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(i=0;i<N;i++) {
			for(j=0;j<M;j++) {
				n1 = (i-1 < 0 || j-1 < 0) ? 0 : memo[i-1][j-1];
				n2 = (i-1 < 0) ? 0 : memo[i-1][j];
				n3 = (j-1 < 0) ? 0 : memo[i][j-1];
				memo[i][j] = Math.max(Math.max(n1,n2), n3) + map[i][j];
			}
		}
		
		
		System.out.println(memo[N-1][M-1]);
		in.close();
	}
}
