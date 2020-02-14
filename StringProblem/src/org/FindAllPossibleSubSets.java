package org;

import java.util.ArrayList;

public class FindAllPossibleSubSets {

	public static void main(String[] args) {
		FindAllPossibleSubSets soa= new FindAllPossibleSubSets();
		int[] nums= {4, 5, 6};
		ArrayList<ArrayList<Integer>> subsets = soa.subsets(nums);
 
		for (ArrayList<Integer> subset: subsets) {
			System.out.println(subset);
		}
	}
 
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		subsetsHelper(list, new ArrayList<>(), nums, 0);
		return list;
	}
 
	private void subsetsHelper(ArrayList<ArrayList<Integer>> list , ArrayList<Integer> resultList, int [] nums, int start){
		list.add(new ArrayList<>(resultList));
		for(int i = start; i < nums.length; i++){
           // add element
			resultList.add(nums[i]);
           // Explore
			subsetsHelper(list, resultList, nums, i + 1);
           // remove
			resultList.remove(resultList.size() - 1);
		}
}
}
//[]
//[4]
//[4,5]
//[4,5,6]
//[4,6]
//[5]
//[5,6]
//[6]
				