class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0, high = m-1;
        int row=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[mid][0]==target){
                return true;
            }
            if(target > matrix[mid][0]){
                if(mid == m-1 || (mid+1<=m-1 && target < matrix[mid+1][0])){
                    row = mid;
                    break;
                }else if(mid+1<=m-1 && target == matrix[mid+1][0]){
                    low = mid+1;
                }
                else if(target > matrix[mid+1][0]){
                    low = mid+1;
                }
            }
            else{
                if( mid-1 >=0 && target >= matrix[mid-1][0]){
                    row = mid-1;
                    break;
                }else if(mid==0 || target <= matrix[mid-1][0]){
                    high = mid-1;
                }
            }
        }
        
        if(row==-1){
            return false;
        }
        low = 0; 
        high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[row][mid]==target){
                return true;
            }
            if(matrix[row][mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}