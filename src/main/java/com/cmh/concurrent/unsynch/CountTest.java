package com.cmh.concurrent.unsynch;

/**
 * Author: 起舞的日子
 * Date:2021/5/5 6:00 下午
 */
public class CountTest {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=1;i<=100;i++){
            sum =+i;
        }
        System.out.println(sum);
    }
}
