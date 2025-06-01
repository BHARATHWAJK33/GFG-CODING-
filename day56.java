
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int start = 0;
        int sum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > target && start < end) {
                sum -= arr[start];
                start++;
            }

            if (sum == target) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(start + 1); // 1-based index
                result.add(end + 1);   // 1-based index
                return result;
            }
        }

        ArrayList<Integer> notFound = new ArrayList<>();
        notFound.add(-1);
        return notFound;
    }
}
