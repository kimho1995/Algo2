package backjoon.binarySerach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            System.out.println(binarySearch(Integer.parseInt(st.nextToken())));
        }

        br.close();
    }

    static int binarySearch(int key) {
        int lo = 0;
        int hi = N-1;

        while(lo <= hi) {
            int mid = (lo + hi)/2;
            if(arr[mid]>key) {
                hi = mid-1;
            } else if(arr[mid]<key) {
                lo = mid+1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}

/*
	private static int binary_search(int start, int end, int num) {
		// TODO Auto-generated method stub
		if(start>=end) {
			if(arr_N[start]==num)
				return 1;
			else
				return 0;
		}


		if(num<arr_N[start + (end-start)/2]) return binary_search(start, start +(end-start)/2, num);
		else if(arr_N[start +(end-start)/2]<num) return binary_search( start +(end-start)/2+1, end, num);
		else return 1;

	}
 */

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(nums);
        int m = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(temp[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(findNum(targets[i], nums) + "\n");
        }
        System.out.print(sb);
	}
	private static int findNum(int target, int[] num) {
		int start = 0;
		int end = num.length-1;
		int pivot = 0;
		while(start<=end) {
			pivot = (start+end)/2;
			if(num[pivot]==target) return 1;
			if(num[pivot]>target) {
				end = pivot-1;
			} else {
				start = pivot+1;
			}
		}
		return 0;
	}
}
 */