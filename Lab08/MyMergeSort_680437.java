package pack;

public class MyMergeSort_680437 {
    public void mSort(int[] nums) {
            int[] tmp = new int[nums.length];
            mSort(nums, tmp, 0, nums.length-1);
    }
    private void mSort(int[] arr, int[] tmp, int low, int high) {
        if (low >= high)    return;
        int mid = low + ((high - low) >> 1);
        mSort(arr, tmp, low, mid);
        mSort(arr, tmp, mid + 1, high);
        merge(arr, tmp, low, mid, high);
    }
    private void merge(int[] arr,int[] tmp, int low, int mid, int high) { 
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid)  tmp[k++] = arr[i++];
        while (j <= high) tmp[k++] = arr[j++];
        for (int x = low; x <= high; x++) {
            arr[x] = tmp[x];
        }
    }
}