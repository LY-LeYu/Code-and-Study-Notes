package com.lystudy.innerclass;

public class CellPhone {
    public static void main(String[] args) {
        alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("心墙");
            }
        });
    }

    public static void alarmclock(Bell music) {
        music.ring();
    }
}

interface Bell {
    void ring();
}

