package com.wujunwen.springbootplay.BO3;

import com.wujunwen.springbootplay.BO.BO;
import org.springframework.stereotype.Repository;

@Repository
public interface IBO {

    void Save(BO bo) ;
}
