package com.example.demo.code.other;

import lombok.Data;

import java.util.*;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-28 19:36
 **/
public class Solution56 {
    /**
     *
     给出一个区间的集合，请合并所有重叠的区间。
     示例 1:
     输入: [[1,3],[2,6],[8,10],[15,18]]
     输出: [[1,6],[8,10],[15,18]]
     解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     示例 2:
     输入: [[1,4],[4,5]]
     输出: [[1,5]]
     解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */
    public List<Interval> merge(List<Interval> intervals) {

        intervals.sort((o1, o2) -> o1.start - o2.start == 0 ? o2.end - o1.end : o1.start - o2.start);
        LinkedList<Interval> res = new LinkedList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (res.isEmpty() || res.getLast().end < intervals.get(i).start)
                res.add(intervals.get(i));
            else
                res.getLast().end = Math.max(intervals.get(i).end, res.getLast().end);
        }
        return res;
    }
}



//Definition for an interval.
@Data
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
