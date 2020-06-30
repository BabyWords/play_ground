package com.wujunwen.springbootplay.BO;


import java.net.ConnectException;

public class BOService {
    private IBO ibo;

    private BOServiceProxy boServiceProxy;
    @ReTryable(retryBy = ConnectException.class,reTryTime = 3)
    public void Save(BO bo) throws Exception{
        boServiceProxy.Save(this,bo);
        throw new ConnectException();
    }
}
