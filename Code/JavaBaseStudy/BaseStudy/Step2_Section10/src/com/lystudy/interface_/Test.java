package com.lystudy.interface_;

public class Test {
    public static void main(String[] args) {
        useDB(new DBMySql());
    }

    public static void useDB(DBConnect DB) {
        DB.connect();
        DB.close();
    }
}

class DBMySql implements DBConnect {
    @Override
    public void connect() {
        System.out.println("MySql 连接");
    }

    @Override
    public void close() {
        System.out.println("MySql 断开");
    }
}

class DBOracle implements DBConnect {
    @Override
    public void connect() {
        System.out.println("Oracle 连接");

    }

    @Override
    public void close() {
        System.out.println("Oracle 断开");

    }
}

 class DB1 implements DBConnect {
    @Override
    public void connect() {

    }

    @Override
    public void close() {

    }
}


