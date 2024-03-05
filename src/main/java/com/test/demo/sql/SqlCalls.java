package com.test.demo.sql;

public class SqlCalls {

	public static String sql1() {
		String x = "EXEC ADMIN..aprt_sel_testmka" + " "
				+ "EXEC ADMIN..aprt_sel_testmkos @test_int=0 , @test_int=0 , @test_vr='12'" + " "
				+ "create table #aprt_imp_01" + "(" + "aidprt char(7) null  /* code portef */" + ")\n"
				+ "create unique clustered index #aprt_imp_01 on  #aprt_imp_01(aidprt)\n"
				+ "exec ADMIN..aprt_sel_testmka \n" + "exec ADMIN..aprt_sel_20";
		return x;
	}

	
	public static String aadc1dtyprech_01(String p01_xclg_xidclg, String p02_typrech) {
		return "                declare @xidclg char(3),\n" + "			@aidrech char(1)\n" + "\n"
				+ "		select @xidclg   = " + p01_xclg_xidclg + ",\n" + "			@aidrech = " + p02_typrech + " \n"
				+ "\n" + "                select  librech  = librech \n" + "		from #aadc_vw_03 \n"
				+ "                where aidrech  = @aidrech\n" + "		and xidclg = @xidclg \n" + "        \n";
	}

}