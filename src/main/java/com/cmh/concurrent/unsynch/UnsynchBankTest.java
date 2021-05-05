package com.cmh.concurrent.unsynch;

/**
 * This program shows data corruption when multiple threads access a data structure
 * <p>
 * Author: 起舞的日子
 * Date:2021/4/18 3:08 下午
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_ACCOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable runnable = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_ACCOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }


}
