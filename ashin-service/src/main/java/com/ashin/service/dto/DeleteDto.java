package com.ashin.service.dto;/**
 * Created by Administrator on 2019/8/27.
 */

import lombok.Data;
import java.io.Serializable;
import java.util.Set;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/8/27 10:09
 **/
@Data
public class DeleteDto implements Serializable{

    private Set<Integer> ids;
}