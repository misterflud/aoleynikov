package ru.job4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Anton on 20.04.2017.
 * Логика работы банка.
 */
public class LogicAction {
    private HashMap<User, ArrayList<Account>> accountsOfUsers = new HashMap<>();

    private ArrayList<User> users = new ArrayList(); //нам необходимо не просто оперировать данными аккаунт-юзер но и просто иметь список юзеров без аккаунтов,
    // который мы можем передать кому угодно или использовать для получения объекта user

    public void addUser(User user) {
        accountsOfUsers.put(user, new ArrayList<>());
        users.add(user); //могут быть проблемы -- в памяти объект юзер то один
    }

    public void deleteUser(User user) {
        accountsOfUsers.remove(user);
        users.remove(user);
    }

    public void addAccountToUser(User user, Account account) {
        accountsOfUsers.get(user).add(account);
    }

    public void deleteAccountFromUser(User user, Account account) {
        accountsOfUsers.get(user).remove(account);
    }

    public List<Account> getUserAccounts (User user) {
        return accountsOfUsers.get(user);
    }

    public User getUser(String name, int passport) { //получение юзера из списка
        User user = null;
        for (User it : users) {
            if (it.getName().equals(name) && it.getPassport() == passport) {
                user = it;
                break;
            }
        }
        return user;
    }

    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;
        try {
            int index1 = accountsOfUsers.get(srcUser).indexOf(srcAccount); //мы не знаем что за юзер и что за аккаунт, поэтому мы должны найти его в своем списке
            int index2 = accountsOfUsers.get(dstUser).indexOf(dstAccount);
            Account sAcc = accountsOfUsers.get(srcUser).get(index1);
            Account dAcc = accountsOfUsers.get(dstUser).get(index2); // destination

            if (sAcc.getValue() < amount) {

            } else {
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
