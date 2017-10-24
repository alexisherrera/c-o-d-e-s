public class Main {

    public static int bs(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int target = -1;

        while (low <= high) {
            int mid = (low + high) /2;
            if (arr[mid] == 0) {
                low = mid + 1;
            }
            //equals 1
            else {
                target = mid;
                high = mid - 1;
            }
        }
        return target;
    }

    public static void main(String[] args) {
	    int[] arr = new int[] { 0};git
        System.out.println(bs(arr));
    }
}
