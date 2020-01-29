package hu.tosad2019.groep4.generator.application.application;

import com.mysql.cj.xdevapi.Table;
import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.Range;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.interentitycomparerule.InterEntityCompareRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.interentitycomparerule.InterEntityCompareRuleContext;
import hu.tosad2019.groep4.generator.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.generator.dataaccess.communication.ServerListener;
import hu.tosad2019.groep4.generator.dataaccess.dbaccess.DbConnection;
import hu.tosad2019.groep4.generator.dataaccess.dbaccess.OracleDbConnection;

import java.sql.SQLException;
import java.util.HashMap;


public class Main
{
	public static void main(String[] args) {
		ServerListener server;
		try {
			server = ServerListener.create(8000);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
