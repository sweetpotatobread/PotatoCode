package com.haohao.books.utils;

public enum DelFlagE {

    YES("yes",0),NO("no",1);

    public String name;
    public int code;

    DelFlagE(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
