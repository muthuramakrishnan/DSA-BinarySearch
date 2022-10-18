/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class SoldierRowListComparator implements Comparator<Map.Entry<Integer, Integer>>{
    public int compare(Map.Entry<Integer, Integer> row1, Map.Entry<Integer, Integer> row2){
        int row1Soldier = row1.getKey();
        int row1Num = row1.getValue();
        int row2Soldier = row2.getKey();
        int row2Num = row2.getValue();

        if(row1Soldier>row2Soldier){
            return 1;
        }
        if(row1Soldier==row2Soldier){
            if(row1Num>row2Num){
                return 1;
            }
        }
        return -1;
    }
}
public class KWeakestRows {
    public static int getNumSoldiers(int[] arr){
        int len = arr.length;
        int low=0, high=len-1;
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==1){
                ans = mid+1;
                low = mid+1;
            }
            else if(arr[mid]==0){
                if(ans!=0){
//                  System.out.println("hi");
//                  break;
                }
                high = mid-1;
            }
        }
        System.out.println(ans);
        return ans;
    }
    public static int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        List<Map.Entry<Integer, Integer>> soldierRowList = new ArrayList<>();

        for(int i=0; i<m; i++){
            int numSoldiers = getNumSoldiers(mat[i]);
            Map.Entry<Integer, Integer> soldierRowPair = new HashMap.SimpleEntry(numSoldiers, i);
            soldierRowList.add(soldierRowPair);
        }
        Comparator<Map.Entry<Integer, Integer>> c = new SoldierRowListComparator();
        Collections.sort(soldierRowList, c);
        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = soldierRowList.get(i).getValue().intValue();
        }
        return result;
    }
    public static void main(String[] args)throws java.lang.Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        String[] tempString = br.readLine().split(" ");
        m = Integer.parseInt(tempString[0]);
        n = Integer.parseInt(tempString[1]);
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        int[] result = kWeakestRows(arr, m);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}