package com.wujunwen.springbootplay.BO2;

import com.wujunwen.springbootplay.BO.BO;
import com.wujunwen.springbootplay.BO.IBO;

import java.net.ConnectException;

public class IBOimpl implements IBO {
    @Override
    public void Save(BO bo) throws ConnectException {
        System.out.println("add bo");
    }
}
