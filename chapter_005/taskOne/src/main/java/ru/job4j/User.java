package ru.job4j;

/**
 * Created by Anton on 20.04.2017.
 * Реализовать коллекцию Map для банка

 Необходимо создать класс User с полями name, passport.

 Необходимо создать класс Account с полями value (кол-во денег), requisites (реквизиты счёта) - это банковский счёт.

 Реализовать коллекцию Map <User, List<Account>>, обозначающую что у каждого пользователя может быть список банковских счетов.

 Необходимо реализовать возможность перечислять деньги, как с одного счёта User на другой счёт того же User, так и на счёт другого User.

 В программе должны быть методы:

 public void addUser(User user) {} - добавление пользователя.

 public void deleteUser(User user) {} - удаление пользователя.

 public void addAccountToUser(User user, Account account) {} - добавить счёт пользователю.

 public void deleteAccountFromUser(User user, Account account) {} - удалить один счёт пользователя.

 public List<Accounts> getUserAccounts (User user) {} - получить список счетов для пользователя.

 public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) - метод для перечисления денег с одного счёта на другой счёт:
 если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.

 */
public class User {
    /**
     * Name.
     */
    private String name;
    /**
     * Passport.
     */
    private int passport;

    /**
     * Constrictor.
     * @param name name
     * @param passport passport
     */
    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Getter.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter.
     * @return passport
     */
    public int getPassport() {
        return this.passport;
    }

    /**
     * Equals.
     * @param user User
     * @return boolean
     */
    @Override
    public boolean equals(Object user) {

        if (this == user) {
            return true;
        }
        if (user == null) {
            return false;
        }
        if (!this.name.equals(((User) user).name) || this.passport != ((User) user).passport) {
            return false;
        }
        return true;
    }

    /**
     * Hashcode.
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return passport * name.hashCode();
    }
}
