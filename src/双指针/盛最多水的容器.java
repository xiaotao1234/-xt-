package 双指针;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/18 0:04
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {//左边界和右边界
            ans = (height[left] < height[right] ?//当前的左右边界哪个更矮，矮边界就是此时不能积更多水的原因
                    Math.max(ans,(right - left)*height[left++] ) ://若左边更矮，则将当前位置积水和当前最大积水比较后，将左边界右移，
                    // 左边界右移，可能获取到比当前更大值的原因是因为，当前的宽度已经为最大宽度了（未进行记录过的（左右边界的）区域的）
                    // 当前是因为左边界高度成为瓶颈，若将左边界右移，可能就能找到在未搜索区域内更多的积水情况（积水宽度较少了）但是当前的高度可能增加了，
                    // 因此积水量就有可能增加
                    Math.max(ans,((right - left)*height[right--]))


                    //****这个递推关系基于当前状态，接下来可能获得更大的积水的变换方法，即将影响当前积水的瓶颈（左右更低的一边）进行向下变换
                    //进而完成暴力的简化遍历
            );
        }
        return ans;
    }

    public int maxArea1(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
