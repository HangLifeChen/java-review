package com.rasion.exception;

public class SelfException {
    public static void main(String[] args) {
//        try {
//            checkAge(15);
//        } catch (AgeIllegalException e) {
//            e.printStackTrace();
//            System.out.println("编译异常：程序出现异常，程序退出");
//        }
        try {
            checkAge2(15);
        } catch (AgeIllegalRuntimeException e) {
            e.printStackTrace();
            System.out.println("运行异常：程序出现异常，程序退出");
        }
        checkAge2(16);
    }
    //自定义异常:当年龄小于18，并大于200时为一个年龄非法异常
    public static void checkAge(int age) throws AgeIllegalException{
        if(age<18||age>200){
            throw new AgeIllegalException("编译异常：年龄非法，年龄不能小于18，不能大于200");
        }else{
            System.out.println("年龄合法");
        }
    }
    public static void checkAge2(int age) throws AgeIllegalRuntimeException{
        if(age<18||age>200){
            throw new AgeIllegalRuntimeException("运行异常：年龄非法，年龄不能小于18，不能大于200");
        }else{
            System.out.println("年龄合法");
        }
    }
}

//自定义编译时异常
class AgeIllegalException extends Exception{
    public AgeIllegalException(){}
    public AgeIllegalException(String message){
        super(message);
    }
}

//自定义运行时异常
class AgeIllegalRuntimeException extends RuntimeException{
    public AgeIllegalRuntimeException(){}
    public AgeIllegalRuntimeException(String message){
        super(message);
    }
}