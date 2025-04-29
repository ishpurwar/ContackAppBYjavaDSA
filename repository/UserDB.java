package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.User;

public class UserDB {
    private static Map<String, List<User>> userDatabase = new HashMap<>();

    public static Map<String, List<User>> getUserDatabase() {
        return userDatabase;
    }
}
