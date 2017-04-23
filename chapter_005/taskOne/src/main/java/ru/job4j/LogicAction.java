package ru.job4j;

import java.util.*;


/**
 * Created by Anton on 20.04.2017.
 * Логика работы банка.
 */
public class LogicAction {
    /**
     * Save our users and their accounts.
     */
    private HashMap<User, ArrayList<Account>> accountsOfUsers = new HashMap<>();
    /**
     * List of users.
     */
    private ArrayList<User> users = new ArrayList<>(); //нам необходимо не просто оперировать данными аккаунт-юзер но и просто иметь список юзеров без аккаунтов,
    // который мы можем передать кому угодно или использовать для получения объекта user

    /**
     * Adds user.
     * @param user user
     */
    public void addUser(User user) {
        accountsOfUsers.put(user, new ArrayList<>());
        users.add(user); //могут быть проблемы -- в памяти объект юзер то один
    }

    /**
     * Deletes user.
     * @param user user
     */
    public void deleteUser(User user) {
        accountsOfUsers.remove(user);
        users.remove(user);
    }

    /**
     * Adds account.
     * @param user user
     * @param account account
     */
    public void addAccountToUser(User user, Account account) {
        accountsOfUsers.get(user).add(account);
    }

    /**
     * Deletes account.
     * @param user user
     * @param account account
     */
    public void deleteAccountFromUser(User user, Account account) {
        accountsOfUsers.get(user).remove(account);
    }

    /**
     * Gets accounts.
     * @param user user
     * @return list of accounts
     */
    public List<Account> getUserAccounts(User user) { //не нужный метод
        return accountsOfUsers.get(user);
    }

    /**
     * Get all users and their accounts.
     * @return users .
     */
    public HashMap<User, ArrayList<Account>> getAll() {
        return accountsOfUsers;
    }

    /**
     * Gets Account.
     * @param user user
     * @param requisites of account
     * @return Account
     */
    public Account getUserAccount(User user, int requisites) throws Exception { // не хватает пары методов, поэтому добавлю
        ArrayList<Account> list = accountsOfUsers.get(user); // получаем список аккаунтов. Возможно будут проблемы с памятью -- мы всегда передаем один и тот же элемент
        Account account2 = null;
        for (Account it : list) {
            if (it.getRequisites() == requisites) {
                account2 = it;
            }
        }
        if (account2 == null) {
            throw new NotFoundException("Account");
        }
        return account2;
    }

    /**
     * Gets User.
     * @param name user
     * @param passport of user
     * @return object User.
     */
    public User getUser(String name, int passport) throws Exception { //получение юзера из списка
        User user = null;
        for (User it : users) {
            if (it.getName().equals(name) && it.getPassport() == passport) {
                user = it;
                break;
            }
        }
        if (user == null) {
            throw new NotFoundException("User");
        }
        return user;
    }

    /**
     * Transfers Money.
     * @param srcUser sender
     * @param srcAccount source money
     * @param dstUser taker
     * @param dstAccount destination money
     * @param amount sum
     * @return true or false
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;
        try {
            int index1 = accountsOfUsers.get(srcUser).indexOf(srcAccount); //мы не знаем что за юзер и что за аккаунт, поэтому мы должны найти его в своем списке
            int index2 = accountsOfUsers.get(dstUser).indexOf(dstAccount);
            Account sAcc = accountsOfUsers.get(srcUser).get(index1);
            Account dAcc = accountsOfUsers.get(dstUser).get(index2); // destination

            if (sAcc.getValue() >= amount) {
                sAcc.setValue(sAcc.getValue() - amount);
                dAcc.setValue(dAcc.getValue() + amount);
                result = true;
            }

        } catch (NullPointerException e) {
            System.out.println("нет такого пользователя или аккаунта");
        }

        return result;
    }
}
