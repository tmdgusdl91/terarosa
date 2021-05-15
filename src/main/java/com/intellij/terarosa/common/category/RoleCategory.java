package com.intellij.terarosa.common.category;

public enum RoleCategory {
    admin("관리자"),
    user("사용자")
    ;

    public String name;

    RoleCategory(String name) {
        this.name = name;
    }
}
