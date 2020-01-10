package com.ashin.service.dto;/**
 * Created by Administrator on 2019/8/27.
 */

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/8/27 9:41
 **/
@Data
public class ArticleQueryDto implements Serializable{

    @NotNull
    private Integer pageNo=1;

    @NotNull
    private Integer pageSize=10;

    //待搜索的内容
    private String search;
}