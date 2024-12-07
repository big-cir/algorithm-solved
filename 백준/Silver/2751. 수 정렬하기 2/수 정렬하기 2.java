import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
     static int[] arr, temp;
      
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        temp = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
         
        mergeSort(1, N);
         
        for(int i=1; i<=N; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }
    public static void mergeSort(int left,int right) {
        if(left >= right) return;  
         
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);    
         
    }
    public static void merge(int left, int mid, int right) {
        int x = left; int y = mid + 1;    
        int k = left;    
         
        while(x <= mid || y <= right) {    
            if(x <= mid && y <= right) {    
                if(arr[x] <= arr[y]) {
                temp[k] = arr[x++];    
                }
                else if(arr[x] > arr[y]) {
                temp[k] = arr[y++];
                }
            }
            else if (x <= mid && y > right){
                temp[k] = arr[x++];
            }
            else if (x > mid && y <= right){
                temp[k] = arr[y++];
            }
            k++;
        }
        for(int i=left; i<=right; i++)    
            arr[i] = temp[i];
    }
}