package repository;

import entity.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDB {
   
    private static Map<String, List<User>> userDatabase = new HashMap<>();

    public static Map<String, List<User>> getUserDatabase() {
        return userDatabase;
    }
}
