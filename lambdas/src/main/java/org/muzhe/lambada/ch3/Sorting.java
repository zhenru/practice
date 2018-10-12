package org.muzhe.lambada.ch3;

import com.google.common.collect.Lists;
import org.muzhe.lambada.common.Apple;
import org.muzhe.lambada.common.Common;

import java.util.Comparator;
import java.util.List;

/**
 * @author muzhe-wang on  18-10-9 下午12:49.
 */
public class Sorting {

    public static void main(String[] args) {

        List<Apple> inventory = Lists.newArrayList();
        inventory.addAll(Common.generateAppleList());

//        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
    }

    static class AppleComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }
}
