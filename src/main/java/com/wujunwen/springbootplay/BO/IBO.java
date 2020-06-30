package com.wujunwen.springbootplay.BO;

import java.net.ConnectException;

public   interface IBO {
    void Save (BO bo) throws ConnectException;
}
