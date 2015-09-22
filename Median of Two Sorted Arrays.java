public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len_1 = nums1.length;
        int len_2 = nums2.length;
        if((len_1+len_2)%2!=0) return (double)findMedian(nums1,nums2,(len_1+len_2)/2,0,len_1-1,0,len_2-1);
        else return (findMedian(nums1,nums2,(len_1+len_2)/2,0,len_1-1,0,len_2-1)+findMedian(nums1,nums2,(len_1+len_2)/2-1,0,len_1-1,0,len_2-1))*0.5;
    }
    public int findMedian(int[] nums1, int[] nums2, int k, int left_1, int right_1, int left_2, int right_2){
        int len_1 = right_1 - left_1 + 1;
        int len_2 = right_2 - left_2 + 1;
        if(len_1 == 0) return nums2[left_2+k];
        if(len_2 == 0) return nums1[left_1+k];
        if(k == 0) return nums1[left_1]<nums2[left_2]? nums1[left_1]:nums2[left_2];
        
        int Mid_1 = len_1*k/(len_1+len_2);
        int Mid_2 = k - 1 - Mid_1;
        Mid_1 += left_1;
        Mid_2 += left_2;
        
        if(nums1[Mid_1] > nums2[Mid_2]){
            k = k - (Mid_2 - left_2 + 1);
            right_1 = Mid_1;
            left_2 = Mid_2 + 1;
        }else{
            k = k - (Mid_1 - left_1 + 1);
            left_1 = Mid_1 + 1;
            right_2 = Mid_2;
        }
        
        return findMedian(nums1,nums2,k,left_1,right_1,left_2,right_2);
    }
}