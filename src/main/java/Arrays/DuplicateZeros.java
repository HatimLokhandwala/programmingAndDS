package Arrays;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        if(arr.length == 0) {
            return;
        }
        int count = 0;
        int last = arr.length - 1;
        int length = arr.length - 1;
        int start = 0;
        while(start <= last) {
            if(arr[start] == 0) {
                if(start == last) {
                    arr[length] = 0;
                    length--;
                } else {
                    last--;
                    count++;    
                }
            } 
            start++;
        }
        int index = length - count;
        last = length;
        
        for(int i = index; i >=0 ; i--) {
            if(arr[i] == 0) {
                arr[last] = 0;
                last--;
                arr[last] = 0;
                last--;
            } else {
                arr[last] = arr[i];
                last--;
            }
        }
    }

    public static void main(String[] args) {


    }
}
