package org.example.framework.base;


import static org.example.framework.util.logs.Log.error;

public class FrameworkException extends  Exception{
    public  static  final long serialVersionUID = 700L;
    public FrameworkException(){
    }

    public FrameworkException(String message){
        super(message);
        error(message);
    }

    public FrameworkException(String message, Exception e){
        this(message);
        error(e.getMessage());
    }

}
