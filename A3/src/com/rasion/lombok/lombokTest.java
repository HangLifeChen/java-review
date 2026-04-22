package com.rasion.lombok;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

public class lombokTest {
    public static void main(String[] args) {
        DataExample data=new DataExample("test");
        System.out.println(data.toString());
    }
}


@Data class DataExample {
    private final String name;
    @Setter(AccessLevel.PACKAGE) private int age;
    private double score;
    private String[] tags;

    @ToString(includeFieldNames=true)
    @Data(staticConstructor="of")
    public static class Exercise<T> {
        private final String name;
        private final T value;
    }
}