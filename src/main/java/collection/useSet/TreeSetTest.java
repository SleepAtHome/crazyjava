package collection.useSet;

import java.util.TreeSet;

/**
 * ClassName:TreeSetTest
 * Description: 测试TreeSet
 * date: 2020-01-09 21:51
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet nums = new TreeSet();

        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);

        System.out.println(nums);

        System.out.println(nums.first());
        System.out.println(nums.last());

        // 返回小于4的子集（不包含4）
        System.out.println(nums.headSet(4));
        // 返回大于5的子集，如果集合里有5，则包含5
        System.out.println(nums.tailSet(5));
        System.out.println(nums.subSet(-3,4));

    }
}
