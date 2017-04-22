package ru.job4j;

import java.util.*;

/**
 * Created by Anton on 20.04.2017.
 */
public class BankActions {
    /**
     * Actions.
     */
    private ArrayList<Act> actions = new ArrayList<>();
    /**
     * LogicAction.
     */
    private LogicAction logicAction = new LogicAction();
    /**
     * Object with opportunity connects with user or tests.
     */
    private Input input;

    /**
     * Constructor.
     * @param input connect with user or tests.
     */
    public BankActions(Input input) {
        this.input = input;
        fillActions();
    }

    /**
     * Fill.
     */
    private void fillActions() {
        actions.add(new AddUser());
        actions.add(new DeleteUser());
        actions.add(new AddAccount());
        actions.add(new DeleteAccount());
        actions.add(new TransferMoney());
        actions.add(new PrintAllUserAndAccounts());
    }

    /**
     * Show Action.
     */
    public void showBankAction() { //печатаем все наши действия

        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + " " + actions.get(i).info());
        }
    }

    /**
     * Execute action.
     * @param point point of action
     */
    public void select(int point) {
        actions.get(point).execute();
    }

    /**
     * AddUser.
     */
    private class AddUser implements Act {
        /**
         * Execute this class's action.
         */
        @Override
        public void execute() {
            String name = input.askAnswer("Write name");
            int passport = Integer.parseInt(input.askAnswer("Write passport"));
            logicAction.addUser(new User(name, passport));
        }

        /**
         * Gets information.
         * @return String
         */
        @Override
        public String info() {
            return "Adds user";
        }
    }

    /**
     * DeleteUser.
     */
    private class DeleteUser implements Act {
        /**
         * Execute this class's action.
         */
        @Override
        public void execute() {
            String name = input.askAnswer("Write name");
            int passport = Integer.parseInt(input.askAnswer("Write passport"));
            logicAction.deleteUser(logicAction.getUser(name, passport));
        }
        /**
         * Gets information.
         * @return String
         */
        @Override
        public String info() {
            return "Deletes user";
        }
    }

    /**
     * AddAccount.
     */
    private class AddAccount implements Act {
        /**
         * Execute this class's action.
         */
        @Override
        public void execute() {
            String name = input.askAnswer("Write name");
            int passport = Integer.parseInt(input.askAnswer("Write passport"));
            double value = Double.parseDouble(input.askAnswer("Write sum"));
            int requisites = Integer.parseInt(input.askAnswer("Write requisites"));

            logicAction.addAccountToUser(logicAction.getUser(name, passport), new Account(value, requisites));
        }
        /**
         * Gets information.
         * @return String
         */
        @Override
        public String info() {
            return "Adds account to user";
        }
    }

    /**
     * DeleteAccoun.
     */
    private class DeleteAccount implements Act {
        /**
         * Execute this class's action.
         */
        @Override
        public void execute() {
            String name = input.askAnswer("Write name");
            int passport = Integer.parseInt(input.askAnswer("Write passport"));
            int requisites = Integer.parseInt(input.askAnswer("Write requisites"));
            User user = logicAction.getUser(name, passport);
            logicAction.deleteAccountFromUser(user, logicAction.getUserAccount(user, requisites));
        }
        /**
         * Gets information.
         * @return String
         */
        @Override
        public String info() {
            return "Deletes user's account";
        }
    }

    /**
     * TransferMoney.
     */
    private class TransferMoney implements Act {
        /**
         * Execute this class's action.
         */
        @Override
        public void execute() {
            String name1 = input.askAnswer("Write name, from you want take money");
            int passport1 = Integer.parseInt(input.askAnswer("Write passport"));
            int requisites1 = Integer.parseInt(input.askAnswer("Write requisites"));
            double sum = Integer.parseInt(input.askAnswer("Write sum"));
            User user1 = logicAction.getUser(name1, passport1);

            String name2 = input.askAnswer("Write name, witch you want to send money");
            int passport2 = Integer.parseInt(input.askAnswer("Write passport"));
            int requisites2 = Integer.parseInt(input.askAnswer("Write requisites"));
            User user2 = logicAction.getUser(name2, passport2);
            boolean b = logicAction.transferMoney(user1, logicAction.getUserAccount(user1, requisites1), user2, logicAction.getUserAccount(user2, requisites2), sum);
            if (b) {
                System.out.println("-----Done-----");
            } else {
                System.out.println("-----Error-----");
            }

        }
        /**
         * Gets information.
         * @return String
         */
        @Override
        public String info() {
            return "Transfers money";
        }
    }

    /**
     * PrintAllUserAndAccounts.
     */
    private class PrintAllUserAndAccounts implements Act { //печатаем все что есть
        /**
         * Execute this class's action.
         */
        @Override
        public void execute() {
            HashMap<User, ArrayList<Account>> accountsOfUsers = logicAction.getAll();
            for (Map.Entry<User, ArrayList<Account>> it1 : accountsOfUsers.entrySet()) {
                System.out.println(String.format("Name: %s, Passport: %s", it1.getKey().getName(), it1.getKey().getPassport()));
                for (Account it2 : it1.getValue()) {
                    System.out.println(String.format("      № of Account: %s, Sum: %s", it2.getRequisites(), it2.getValue()));
                }
            }
        }
        /**
         * Gets information.
         * @return String
         */
        @Override
        public String info() {
            return "Prints users ond their accounts";
        }
    }
}
