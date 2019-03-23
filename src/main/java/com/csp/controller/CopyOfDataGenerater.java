package com.csp.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.jupiter.api.Test;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class CopyOfDataGenerater {
	@Resource(name = "dsJdbcTemplate")
	private JdbcTemplate dsJdbcTemplate;

	public RestTemplate graphRestTemplate() {
		PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager();
		int poolSize = 4;
		connMgr.setMaxTotal(poolSize + 1);
		connMgr.setDefaultMaxPerRoute(poolSize);
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connMgr).build();
		return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
	}

	@Test //同手机不同人，小环形
	public void data() throws Exception {
		List<JSONObject> list = new ArrayList<>();
		int MAX_LEN = 8;
		for (int i = 0; i < MAX_LEN; i++) {
			JSONObject jo = new JSONObject();
			jo.put("graph_table_name", "AuditObject");
			jo.put("frms_trans_time", "1543657092000");
			jo.put("DGDQZHJ_ZHBH", "dgzh006"); //对公定期账户  nodeID 11   
			jo.put("DGDQZHJ_KHBH", "kh006"+i);
			jo.put("DGDQZHJ_KHMC", "mc006"+i);
			jo.put("DGDQZHJ_KHJGMC", "khmc06"+i);
			jo.put("DGDQZHJ_KHJGBH", "jg006"+i);
			jo.put("DGDQZHJ_KHSJ", "sj006"+i);


			jo.put("NBZHD_ZHBH", "nbzh006"); //内部账户   nodeID 72   
			jo.put("NBZHD_KHMC", "nbmc006"+i);
			jo.put("NBZHD_KHJGMC","nbjg006"+i);
			jo.put("NBZHD_KHJGBH","nbbm006"+i);
			jo.put("NBZHD_SFKTZ","是");

			jo.put("DGHQZHJ", "dghqzh006"); //对公活期账户  nodeID 90  
			jo.put("DGHQZHJ_KHBH", "kh006"+i);
			jo.put("DGHQZHJ_KHMC", "mc006"+i);
			jo.put("DGHQZHJ_KHJGMC", "khmc006"+i);
			jo.put("DGHQZHJ_KHJGBH", "jg006"+i);
			jo.put("DGHQZHJ_KHSJ", "sj006"+i);
            
 			jo.put("DSZH","dszh006"+i);//证件(对私账户)  nodeID 10     
			jo.put("DSZHJ_DGFRZJH","dsid006"+i);
			jo.put("DSZHJ_FRXM", "dsmx006"+i);
            
            jo.put("DEHSR", "dehsr006"+i); //大额核实人  nodeID 91
			jo.put("DEHSR_KHBH", "kh006"+i);
			jo.put("DEHSR_KHMC", "mc006"+i);
			jo.put("DEHSR_KHJGMC", "khmc006"+i);
			jo.put("DEHSR_KHJGBH", "jg006"+i);
			jo.put("DEHSR_KHSJ", "sj006"+i);


            jo.put("DGKH", "dgkh006"+i); //对公客户  nodeID 92
			jo.put("DGKH_KHBH", "kh006"+i);
			jo.put("DGKH_KHMC", "mc006"+i);
			jo.put("DGKH_KHJGMC", "khmc006"+i);
			jo.put("DGKH_KHJGBH", "jg006"+i);
			jo.put("DGKH_KHSJ", "sj006"+i);

			jo.put("WYSQR", "wysqr006"+i); //网银授权人  nodeID 93
			jo.put("WYSQR_KHBH", "kh006"+i);
			jo.put("WYSQR_KHMC", "mc006"+i);
			jo.put("WYSQR_KHJGMC", "khmc006"+i);
			jo.put("WYSQR_KHJGBH", "jg006"+i);
			jo.put("WYSQR_KHSJ", "sj006"+i);

			jo.put("WYIP", "wyip006"+i); //网银IP  nodeID 94
			jo.put("WYIP_KHBH", "kh006"+i);
			jo.put("WYIP_KHMC", "mc006"+i);
			jo.put("WYIP_KHJGMC", "khmc006"+i);
			jo.put("WYIP_KHJGBH", "jg006"+i);
			jo.put("WYIP_KHSJ", "sj006"+i);


			/*jo.put("frms_idcard", "20180810"+(i));*/
			jo.put("HWZH", "hwzh006");//行外账户(对私账户) nodeID 12

			jo.put("DSKHGH", "gh006"+i);//固话（对私账户）  nodeID 9 
			jo.put("DSKHGHXM", "111266"+i);
			jo.put("DSKHGHZJH", "229866"+i);
            jo.put("JLSJ", "2029866"+i);


            //交易边优先级设置  对公活期账户90 -大额核实人 91
			jo.put("DGHQZH_DEHSR_JYJE_1M", "18922266"+i); //对公活期账户-大额核实人 近一个月交易金额   prioritylevel 50
            jo.put("DGHQZH_DEHSR_JYCS_1M", "26871966"+i); //对公活期账户-大额核实人 近一个月交易次数  
            jo.put("DGHQZH_DEHSR_JYJE_2M", "1000966"+i); //对公活期账户-大额核实人 近二个月交易金额
            jo.put("DGHQZH_DEHSR_JYCS_2M", "78781966"+i); //对公活期账户-大额核实人 近二个月交易次数  prioritylevel 51
            jo.put("DGHQZH_DEHSR_JYJE_3M", "1080966"+i); //对公活期账户-大额核实人 近三个月交易金额
            jo.put("DGHQZH_DEHSR_JYCS_3M", "27881966"+i); //对公活期账户-大额核实人 近三个月交易次数  prioritylevel 52




            //交易边优先级设置  对公活期账户90 -对公客户 92
			jo.put("DGHQZH_DGKH_JYJE_1M", "1000966"+i); //对公活期账户-对公客户 近一个月交易金额   prioritylevel 53
            jo.put("DGHQZH_DGKH_JYCS_1M", "27818966"+i); //对公活期账户-对公客户 近一个月交易次数  
            jo.put("DGHQZH_DGKH_JYJE_2M", "10008966"+i); //对公活期账户-对公客户 近二个月交易金额   
            jo.put("DGHQZH_DGKH_JYCS_2M", "27818966"+i); //对公活期账户-对公客户 近二个月交易次数  prioritylevel  54
            jo.put("DGHQZH_DGKH_JYJE_3M", "1009866"+i); //对公活期账户-对公客户 近三个月交易金额   
            jo.put("DGHQZH_DGKH_JYCS_3M", "26718966"+i); //对公活期账户-对公客户 近三个月交易次数  prioritylevel   55

            //交易边优先级设置  对公活期账户90 -网银授权人 93
			jo.put("DGHQZH_WYSQR", "1000966"+i); //对公活期账户-网银授权人    prioritylevel 49

			//交易边优先级设置  对公活期账户90 -网银IP 94
			jo.put("DGHQZH_WYIP", "1008966"+i); //对公活期账户-网银ip    prioritylevel 48

			//交易边优先级设置  对公活期账户90 -固话 9
			jo.put("DGHQZH_GH", "1008966"+i); //对公活期账户-固话    prioritylevel 47






            //交易边优先级设置   对公定期账户11 - 内部账户 72
			jo.put("DGDQZH_NBZH_JYJE_1M", "1009866"+i); //对公定期账户- 内部账户 近一个月交易金额  prioritylevel 7
			jo.put("DGDQZH_NBZH_JYCS_1M", "26818966"+i);
			/*jo.put("frms_ip", "bigipa1.1.1.0"+(i));*/
			jo.put("DGDQZH_NBZH_JYJE_2M", "26779866"+i);//对公定期账户- 内部账户 近二个月交易金额  prioritylevel 8
            jo.put("DGDQZH_NBZH_JYCS_2M", "26719866"+i);

			//交易边优先级设置  对公定期账户11- 行外账户 12
            jo.put("DGDQZH_HWZH_JYJE_1M", "26718966"+i);//对公定期账户-行外账户 近一个月交易金额  prioritylevel 9
            jo.put("DGDQZH_HWZH_JYCS_1M", "26718966"+i);
            jo.put("DGDQZH_HWZH_JYJE_3M", "26778966"+i);//对公定期账户-行外账户 近三个月交易金额  prioritylevel 10
            jo.put("DGDQZH_HWZH_JYCS_3M", "26718966"+i);

			jo.put("DG_DS_JYJE_3M", "26888866"+i); //prioritylevel 6
			jo.put("DG_DS_JYCS_3M", "18979866"+i);

			//交易边优先级设置  对公定期账户11 -固话 9 prioritylevel 4
            jo.put("DQDQZH_GH", "26889866"+i);
			//交易边优先级设置  证件10 -固话 9
			jo.put("USE_PHONE", "28818966"+i); //prioritylevel 5

			//交易边优先级设置  对公定期账户11 -证件10
			jo.put("DGDQZH_DSZH", "1008966"+i); //对公定期账户-账户    prioritylevel 40
    
	
            

//			jo.put("type1", "招商");
//			jo.put("frms_city", "city0001"+(i));
//			jo.put("carea", "归属地");
//			jo.put("frms_external", "big0001"+(i)) ;
//			jo.put("count", "2");
			list.add(jo);
		}
		// 导入payorder表

		RestTemplate client = graphRestTemplate();
		System.out.println("Post one time");
		client.postForObject("http://10.100.1.155:7077/analysis/ds/insert", list, Void.class);
		
	}
	
	

}
