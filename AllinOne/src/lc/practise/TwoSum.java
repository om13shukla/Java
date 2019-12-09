package lc.practise;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {

  public int[] twoSum(int[] arr, int sum) {
    int[] result = new int[2];
    boolean flag = false;
    for(int i = 0; i < arr.length; i++) {
      for(int j = i + 1; j < arr.length; j++) {
        if(arr[i] + arr[j] == sum) {
          // System.out.println("the two numbers are "+arr[i]+" and "+arr[j]);
          result[0] = i;
          result[1] = j;
          flag = true;
          break;

        }
      }
      if(flag) {
        return result;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
