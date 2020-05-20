package 各种排序方法;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/24 11:44
 */
public class 数组中的逆序对归并 {
    //这道题在这里充分的利用了归并排序的特点，在并的时候，因为并的两个子集都是分别有序的，
    // 这里在子集并的时候，当现在要并入的数是后子集中的数时，其之所以能轮到当前元素并入，
    // 是因为前子集及其后面的数都大于当前数，所以对当前两个子集范围内来说，
    // 因为后子集的数放到了前子集部分剩余还未合并的元素之前，即前初始的顺序符合逆序对规则，
    // 当然这里还是要论证一下当前计算方法的正确性
    // 提出问题：
    // 1.会不会对一组逆序对存在重复的计算
    // 首先，我们应该知道的是，归并排序归操作每次归一个范围内的数字时，
    // 逆序对只会出现在当前范围内，且一个必定出现在前一个子范围，一个
    // 出现在后一个子范围，因为每次归的范围都是不同的，因此其解不存在
    // 重复的情况，
    // 2.怎样保证了不漏解，换句话说，保证归并所有并的过程的求解的统计结果涵盖了所有的解的情况
    // 解：我们来看结果的组成情况，每一个结果的子集（比如说和第一个元素相关的逆序对）
    // 是由当前的区域中其前面比他大的所有元素加上其后比他所有比他小的所有元素都能组成逆序对，
    // 但是两个固定序号的元素只能组成一对（无关顺序），即要保证找到了所有的结果只需保证对每一个元素
    // 我们都让他与其前面所有的元素和其后所有的元素做比较即可，这里对两个子集并的过程，
    // 保证了一个子集中的任意元素在其前存在的所有解，即每两个子段归的过程，就是求所有较小元素为后段
    // 的所有解，因为逆序对就是相对顺序为大前小后的，两个子集，前子集的所有元素一定在后子集的前面，
    // （每个子集在其的两个子集归并时已经求的了所有的逆序对，或者换句话说再对两个子集归并求解前，
    // 这两个子集已经完成了各自包含的逆序对的求解），即我们现在只需完成两个子集交叉的逆序对就能完成归并
    // 两段，最终得到完成内部求解的新段
    public int reversePairs(int[] nums) {
        devide(nums, 0, nums.length);
        return all;
    }

    int all = 0;

    public void devide(int[] nums, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            devide(nums, start, middle);
            devide(nums, middle + 1, end);
            all = all + mergeNums(nums, start, middle, end);
        }
    }

    public int mergeNums(int[] nums, int start, int middle, int right) {
        int[] ints = new int[right - start + 1];
        int start1 = start;
        int start2 = middle + 1;
        int index = 0;
        int all = 0;
        while (start1 <= middle && start2 <= right) {
            if (nums[start1] <= nums[start2]) {
                ints[index] = nums[start1];
                index++;
                start1++;
            } else {
                ints[index] = nums[start2];
                index++;
                start2++;
                all = all + middle - start1+1;
            }
        }
        while (start1 <= middle) {
            ints[index] = nums[start1];
            index++;
            start1++;
        }
        while (start2 <= right) {
            ints[index] = nums[start2];
            index++;
            start2++;
        }
        for (int i = start; i <= right; i++) {
            nums[i] = ints[i - start];
        }
        return all;
    }
}
