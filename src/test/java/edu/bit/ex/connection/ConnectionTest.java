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
public class ConnectionTest {				// 클래스 이름은 자의적으로 정하는데, 프로젝트용으로는 좀 더 의미있게 짓자!
											// 커넥션풀 테스트는 반드시 하고, 프로젝트 문서에 넣자!
											// 1. 스프링을 테스트하기 위해서는 web.xml의 역할을 대신하는 @RunWith이 필요. 스프링은 ioc 컨테이너를 기반으로 돌아가므로, 반드시 ioc 컨테이너를 만들고 @RunWith를 통해 컨테이너 검사를 해야 함.
											// 2. 스프링을 읽어들이는 @ContextConfiguration으로 root-context.xml 위치를 알려줌
											// 3. @Log4j - src/test/resources 파일에도 log4j와 properties 파일 복사 붙여넣기 하고 원래 스프링 환경과 똑같이 설정함.
	
		// 1. 커넥션풀을 기본적으로 테스트 = 오라클과 접속이 잘 되는가
	   @Autowired		// inject 사용해도 되는데, 이때 임포트에서 애먹음
	   DataSource dataSource;			
	   
	   @Test
	   public void testDataSource() {
	      assertNotNull(dataSource);
	   }
	   
	   
}
