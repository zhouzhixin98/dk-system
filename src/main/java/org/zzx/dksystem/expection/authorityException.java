package org.zzx.dksystem.expection;

public class authorityException extends RuntimeException {
    private static final long serialVersionUID = 48L;
    public authorityException(){}
    public authorityException(String msg){
        super(msg);
    }
}
