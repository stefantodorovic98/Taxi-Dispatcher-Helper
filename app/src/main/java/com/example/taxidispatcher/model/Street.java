package com.example.taxidispatcher.model;

public class Street {
    private String name;
    private String option_1;
    private String option_2;
    private String option_3;

    public Street(String name, String option_1, String option_2, String option_3) {
        this.name = name;
        this.option_1 = option_1;
        this.option_2 = option_2;
        this.option_3 = option_3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOption_1() {
        return option_1;
    }

    public void setOption_1(String option_1) {
        this.option_1 = option_1;
    }

    public String getOption_2() {
        return option_2;
    }

    public void setOption_2(String option_2) {
        this.option_2 = option_2;
    }

    public String getOption_3() {
        return option_3;
    }

    public void setOption_3(String option_3) {
        this.option_3 = option_3;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", option_1='" + option_1 + '\'' +
                ", option_2='" + option_2 + '\'' +
                ", option_3='" + option_3 + '\'' +
                '}';
    }
}
