package com.cmh.concurrent.unsynch;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: 起舞的日子
 * Date:2021/4/18 3:08 下午
 */
public class Bank {
    private final double[] accounts;

    private Lock bankLock = new ReentrantLock();

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
        bankLock.lock();
        try {
            if (accounts[from] < amount) {
                return;
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("  Total Balance: %10.2f %n", getTotalBalance());
            System.out.println();
        } finally {
            bankLock.unlock();
        }
    }

    /**
     * 来看一下transfer这个方法字节码指令执行情况
     * javac Bank.java
     * javap -c -v Bank
     * <p>
     * 之后看到的是这样的：
     * 大体找到对应accounts[from] -= amount的指令：
     * 22: getfield      #7                  // Field accounts:[D 去from索引位置获取到这个值
     * 25: iload_1     将第二个int类型的值推送至栈顶
     * 26: dup2        复制栈顶的数值并将复制值压入栈顶
     * 27: daload      将double数组指定索引的值推送至栈顶
     * 28: dload_3     将第四个double型本地变量推送至栈顶
     * 29: dsub        将栈顶两double型数值相减并将结果压入栈顶
     * 30: dastore     将栈顶double型数值存入指定数组指定索引的位置
     * <p>
     * 通过以上指令，基本知道在accounts[from] = accounts[from] - amount的时候，
     * 至少需要压栈、详减、存入几个指令，那么在这个过程中，未做并发处理，就会有并发问题。
     */

    public double getTotalBalance() {
        double sum = Arrays.stream(accounts).sum();
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
