public enum TestEnum {
    one(1,"1"),

    tow(2,"2"),
    three(3,"3");

    int code;
    String mean;

    TestEnum(int code, String mean) {
        this.code = code;
        this.mean = mean;
    }
}
