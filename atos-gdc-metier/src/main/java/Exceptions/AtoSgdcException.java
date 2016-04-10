/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import java.io.Serializable;
import javax.ejb.ApplicationException;

/**
 *
 * @author Ahmet Dame CISSE
 */
@ApplicationException(rollback = true)
public class AtoSgdcException  extends RuntimeException implements Serializable{
    private int code=0;

    public AtoSgdcException() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AtoSgdcException(String message, int code) {
        super(message);
        setCode(code);
    }

    public AtoSgdcException(String message, Throwable cause, int code) {
        super(message, cause);
        setCode(code);
    }

    public AtoSgdcException(Throwable cause, int code) {
        super(cause);
        setCode(code);
    }

    public AtoSgdcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
