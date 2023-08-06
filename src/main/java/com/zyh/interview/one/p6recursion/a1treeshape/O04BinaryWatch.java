package com.zyh.interview.one.p6recursion.a1treeshape;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二进制手表
 * @author：zhanyh
 * @date: 2023/8/4
 */
public class O04BinaryWatch {


    private List<List<Integer>> res;

    public List<String> readBinaryWatch(int turnedOn) {
        res = new ArrayList<>();
        readBinaryWatchCore(turnedOn, 0, new ArrayList<Integer>());
        return decoder(res);
    }

    private List<String> decoder(List<List<Integer>> res){
        int[] map = new int[]{1,2,4,8,1,2,4,8,16,32};
        List<String> ans = new ArrayList<>();
        for(List<Integer> list : res ){
            String sh = "";
            String smm = "";
            int h = 0;
            int mm = 0;
            for(Integer e : list ){
                if(e <= 3){
                    h += map[e];
                }else{
                    mm += map[e];
                }
            }
            if(h <= 11 && mm <= 59){
                sh += h;
                smm = mm < 10 ? "0" + mm : ""+mm;
                ans.add(sh + ":" + smm);
            }
            h = 0;
            mm = 0;
        }

        return ans;
    }

    private void readBinaryWatchCore(int turnedOn, int start, List<Integer> list){
        if(turnedOn == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < 10; i++){
            list.add(i);
            readBinaryWatchCore(turnedOn - 1,  i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
