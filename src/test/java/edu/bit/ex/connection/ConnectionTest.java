package edu.bit.ex.connection;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

//import javax.inject.Inject;
//import javax.sql.DataSource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//
//import lombok.extern.log4j.Log4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ConnectionTest {				// Ŭ���� �̸��� ���������� ���ϴµ�, ������Ʈ�����δ� �� �� �ǹ��ְ� ����!
											// Ŀ�ؼ�Ǯ �׽�Ʈ�� �ݵ�� �ϰ�, ������Ʈ ������ ����!
											// 1. �������� �׽�Ʈ�ϱ� ���ؼ��� web.xml�� ������ ����ϴ� @RunWith�� �ʿ�. �������� ioc �����̳ʸ� ������� ���ư��Ƿ�, �ݵ�� ioc �����̳ʸ� ����� @RunWith�� ���� �����̳� �˻縦 �ؾ� ��.
											// 2. �������� �о���̴� @ContextConfiguration���� root-context.xml ��ġ�� �˷���
											// 3. @Log4j - src/test/resources ���Ͽ��� log4j�� properties ���� ���� �ٿ��ֱ� �ϰ� ���� ������ ȯ��� �Ȱ��� ������.
	
		// 1. Ŀ�ؼ�Ǯ�� �⺻������ �׽�Ʈ = ����Ŭ�� ������ �� �Ǵ°�
	   @Autowired		// inject ����ص� �Ǵµ�, �̶� ����Ʈ���� �ָ���
	   DataSource dataSource;			
	   
	   @Test
	   public void testDataSource() {
	      assertNotNull(dataSource);
	   }
	   
	   
}
