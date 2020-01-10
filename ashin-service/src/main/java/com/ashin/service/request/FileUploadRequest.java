package com.ashin.service.request;/**
 * Created by Administrator on 2019/10/27.
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/10/27 11:15
 **/
@Data
public class FileUploadRequest implements Serializable{

    private String itemName;

    private String itemCode;

    private Long  itemTotal;

}


























