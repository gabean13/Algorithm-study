import java.io.*;
import java.util.*;

class Main {
	static int[] sorted;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		sorted = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(arr, 0, arr.length - 1);
		
		StringBuilder sb = new StringBuilder();
		for(int num : arr) {
			sb.append(num).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void mergeSort(int[] arr, int left, int right) {
		//리스트가 1개인 경우
		if(left == right) return;
		
		int mid = (left + right) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid+1, right);
		
		merge(arr, left, mid, right);
	}
	
	/*
	 * @param arr 정렬할 배열
	 * @param left 배열의 시작점
	 * @param mid 배열의 중간점
	 * @param right 배열의 끝 점
	 */
	static void merge(int[] arr, int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = left;
		
		while(l <= mid && r <= right) {
			if(arr[l] <= arr[r]) {
				sorted[idx++] = arr[l++];
			} else {
				sorted[idx++] = arr[r++];
			}
		}
		
		if(l > mid) {
			while(r <= right) {
				sorted[idx++] = arr[r++];
			}
		} else {
			while(l <= mid) {
				sorted[idx++] = arr[l++];
			}
		}
		
		for(int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}
}