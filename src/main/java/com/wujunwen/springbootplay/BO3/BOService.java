package com.wujunwen.springbootplay.BO3;


import com.wujunwen.springbootplay.BO.BO;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.ConnectException;

public class BOService {

    @Autowired
    IBO ibo;

    @ReTryable(retryTime = 3,retryException = ConnectException.class)
    public void Save(BO bo) {
        ibo.Save(bo);
    }
}
