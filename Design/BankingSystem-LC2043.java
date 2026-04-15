class Solution{
    long[] accounts;

    public Bank(long[] balance) {
        int len = balance.length;
        accounts = new long[len]; // defining the accounts array with the number of the balances given

        for (int i = 0; i < balance.length; i++) {
            accounts[i] = balance[i]; // shifting the amounts to the respective accounts
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!checkIfAccountExists(accounts, account1) || !checkIfAccountExists(accounts, account2)) {
            return false;
        }

        if (accounts[account1 - 1] < money) {
            return false;
        }

        accounts[account1 - 1] -= money;
        accounts[account2 - 1] += money;

        return true;
    }

    public boolean deposit(int account, long money) {
        if (!checkIfAccountExists(accounts, account)) {
            return false;
        }

        accounts[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!checkIfAccountExists(accounts, account)) {
            return false;
        }
        if (accounts[account - 1] < money) {
            return false;
        }
        accounts[account - 1] -= money;
        return true;
    }

    // function to check whether the account exists or not
    public boolean checkIfAccountExists(long[] accounts, int accountNumber) {
        return accountNumber >= 1 && accountNumber <= accounts.length;
    }
}