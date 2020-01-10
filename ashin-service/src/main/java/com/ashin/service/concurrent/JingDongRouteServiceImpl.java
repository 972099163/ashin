package com.ashin.service.concurrent;

import com.ashin.model.entity.EbCustomer;
import com.ashin.service.utils.ContextUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class JingDongRouteServiceImpl {


    private static final int LIMIT_SIZE = 10000;//分页查询1万条记录
    private static final int SHOW_SIZE = 1000;//1000条就显示

    public void jingDongRoute() {
        DataSource dataSourceMain= (DataSource) ContextUtils.getBean("dataSource");
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceMain);
        AtomicInteger rsCount = new AtomicInteger(0);
        AtomicLong idMax = new AtomicLong(0);
        List<EbCustomer> enCustomerList=new ArrayList<>();
        while (true) {
            jdbcTemplate.query(con -> {
                PreparedStatement preparedStatement =
                        con.prepareStatement( sql(),
                                ResultSet.TYPE_FORWARD_ONLY,
                                ResultSet.CONCUR_READ_ONLY);
                preparedStatement.setLong(1,idMax.get());

                preparedStatement.setString(4, "Y");
                preparedStatement.setInt(5, LIMIT_SIZE);
                preparedStatement.setFetchSize(SHOW_SIZE);
                preparedStatement.setFetchDirection(ResultSet.FETCH_FORWARD);
                return preparedStatement;
            }, rs -> {
                rsCount.incrementAndGet();
                if (rsCount.get() == LIMIT_SIZE){
                    idMax.set(rs.getLong("ETOR_ID"));
                }
                EbCustomer ebCustomer=toEtOrderModel(rs);

            if(StringUtils.isEmpty(ebCustomer.getUserName()))
            {
                return;
            }
                enCustomerList.add(ebCustomer);
            if(enCustomerList.size()==SHOW_SIZE)
            {
                //调用服务

            }


        });
            if (rsCount.get() < LIMIT_SIZE){
                break;
            }
            rsCount.compareAndSet(LIMIT_SIZE,0);

    }
        if(enCustomerList.size()>0)  //判断空
        {
            //调用服务

            enCustomerList.clear();
        }

    }

    private EbCustomer toEtOrderModel(ResultSet rs) {
        EbCustomer ebCustomer=new EbCustomer();
        try {
            ebCustomer.setId(rs.getInt("ETOR_ID"));
          /*  etOrderBean.setEtorId(rs.getLong("ETOR_ID"));
            etOrderBean.setEtorSoNo(rs.getString("ETOR_SO_NO"));
            etOrderBean.setEtorOrderNo(rs.getString("ETOR_ORDER_NO"));
            etOrderBean.setEtorExpress(rs.getString("ETOR_EXPRESS"));
            etOrderBean.setEtorExpressNumber(rs.getString("ETOR_EXPRESS_NUMBER"));*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ebCustomer;
    }

    private String sql()
    {
        StringBuffer  sqlBuffer = new StringBuffer();
        sqlBuffer.append("SELECT rownum,t.* from (");
        sqlBuffer.append("SELECT ");
        sqlBuffer.append("ETOR_ID, ");
        sqlBuffer.append("ETOR_SO_NO, ");
        sqlBuffer.append("ETOR_ORDER_NO, ");
        sqlBuffer.append("ETOR_EXPRESS, ");
        sqlBuffer.append("ETOR_EXPRESS_NUMBER ");
        sqlBuffer.append("from ET_ORDER etor ");
        sqlBuffer.append("WHERE ETOR_ID>? ");
        sqlBuffer.append("AND ETOR_OPERATE_ESST_CODE=? ");
        sqlBuffer.append("AND ETOR_STATUS=? ");
        sqlBuffer.append("AND ETOR_IS_SEND=? ");
        sqlBuffer.append(" ORDER BY ETOR_ID ");
        sqlBuffer.append(") t ");
        sqlBuffer.append("where rownum<? ");
        return sqlBuffer.toString();
    }
}
