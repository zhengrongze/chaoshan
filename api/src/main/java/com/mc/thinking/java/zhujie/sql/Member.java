package com.mc.thinking.java.zhujie.sql;
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String fristName;
    @SQLString(50)
    String lastName;
    @SQLInteger()
    Integer age;
    @SQLString(value = 30,constraints = @Constraints(primaryKey = true))
    String handle;
    static int memberCount;

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    public static void setMemberCount(int memberCount) {
        Member.memberCount = memberCount;
    }
}