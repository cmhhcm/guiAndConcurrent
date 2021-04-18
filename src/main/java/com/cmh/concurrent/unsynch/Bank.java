package com.cmh.concurrent.unsynch;

import java.util.Arrays;

/**
 * Author: cmh
 * Date:2021/4/18 3:08 下午
 */
public class Bank {
    private final double[] accounts;

    /**
     * 初始化银行
     *
     * @param n              the number of accounts
     * @param initialBalance the initial balance of each account
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * 从一个账户给另一个账户转账
     *
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf("  Total Balance: %10.2f %n", getTotalBalance());
        System.out.println();
    }

    public double getTotalBalance() {
        double sum = Arrays.stream(accounts).sum();
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
