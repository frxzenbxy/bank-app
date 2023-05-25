package com.example.rstroybackend.entity.views;

import java.util.HashMap;
import java.util.Map;

public class SecurityViews {
    public static final Map<String, Class> MAPPING = new HashMap<>();

    static {
        MAPPING.put("ROLE_ANONYMOUS", Anonymous.class);
        MAPPING.put("ROLE_ADMIN", Admin.class);
        MAPPING.put("ROLE_MANAGER_3", Manager3.class);
        MAPPING.put("ROLE_MANAGER_2", Manager2.class);
        MAPPING.put("ROLE_MANAGER_1", Manager1.class);
        MAPPING.put("ROLE_USER", User.class);
    }

    public static class Anonymous {}
    public static class User extends Anonymous {}
    public static class Admin extends User {}
    public static class Manager3 extends User {}
    public static class Manager2 extends User {}
    public static class Manager1 extends User {}
}
