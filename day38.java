
class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==x)return true;
            }
        }
        return false;
    }
}
