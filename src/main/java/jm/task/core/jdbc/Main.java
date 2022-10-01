package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("Name1", "lastName1", (byte) 1);
        service.saveUser("Name2", "lastName2", (byte) 2);
        service.saveUser("Name3", "lastName3", (byte) 3);
        service.saveUser("Name4", "lastName4", (byte) 4);
        service.getAllUsers().iterator().forEachRemaining(System.out :: println);
    }
}
