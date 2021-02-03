package edu.bit.ex.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTest {
	// �׽�Ʈ �κ��� jUnit���� �����ϴ� ȯ�濡�� �����غ��� ���̰�, ��Ĺ���� �����ϴ� ���� �ƴϹǷ� ��Ʈ�ѷ� �׽�Ʈ�� ��ٷο�
	// jUnit�� "�Լ�"�� �׽�Ʈ�ؾ��ϴµ�, get/post�� ������ �����ͳ� url�� ó���ؾ� �ϹǷ� ��ٷӴٴ� ��
	// httpRequest.. �κ��� �������� �۵��ϴ� ���̱� ����.
	// ���� ��Ʈ�ѷ� �κ��� �������� �׽�Ʈ������ �Ұ����ϰ�, �뷫���� ȯ���� ������ ������ �� ����.
	// �� ����� Mok�̶�� ��ü�� �̿��� ����ȯ���� �������ִ� �����.

	// 1. ������̼� �ٿ��ֱ� �� ����ȯ���� �����ؾ� �ϱ� ������, ioc �����̳� �ΰ��� ��� �����;� ��
	// 2. �Ʒ� �ۼ�

	@Setter(onMethod_ = { @Autowired }) // setter = �Ʒ� ��ü�� �ٸ� ��ü�� �־��ַ��� setter �ʿ�
	private WebApplicationContext ctx; // WebApplicationContext = �� ���� ioc �����̳ʸ� ������ �� ����ߴ� ��ü
										// ���⿡ ���ؼ� �޾ƿ� xml �� ���� �о�ͼ� ��ü�� ����� �����ϰ�(@Autowired) ��.

	private MockMvc mockMvc; // MockMvc��?
								// ���� ��ü�� ��������� �׽�Ʈ�� �ʿ��� ��ɸ� ������ ��¥ ��ü�� ����
								// ���ø����̼� ������ �������� �ʰ� ������ MVC ������ ������ �� �ִ� Ŭ������ �ǹ�.

	@Before // @Before = �׽�Ʈ �ʱ�ȭ (@test ���� �̸� ���õǾ�� �ϴ� �͵��� �����ϴ� ��)
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); // MockMvc�� ��ü�� ����� ���.
																		// MockMvcBuilders = static
																		// ctx�� ����Ǿ ��ü�� �����´ٰ� ������ �� ����.
	}

	// 3. �⺻ ���� �� ������ �׽�Ʈ�ϱ�
	// cf. ctrl+shift+f : ���� �� �ѹ��� �����
	// get ������� /list�� �޴´ٴ� �ǹ�
	// forwardedUrl�� ��¥ �������� �������ϴ� �� �ƴ϶�, ���� ȯ�濡�� �׽�Ʈ�� �Ѵٴ� ��.
	// �׽�Ʈ ���� �� �ܼ� ���� Ȯ���غ���
	// ��Ʈ�ѷ��� ��� ���� ȯ�濡�� ������ �ϱ� ������, �� ������ �ϰ� ���� �׽�Ʈ�� �ߴٴ� �͸� ��������.
	
	@Test
	public void testList() throws Exception {
		mockMvc.perform(get("/board/list"))		// ������ GET ������� �޴´�.
		.andExpect(status().isOk())				// ���� ����
		.andDo(print())							// �����Ǹ� print �Ѵ�.
		.andExpect(forwardedUrl("/WEB-INF/views/list.jsp"));		// ����� url�� ������
	}
	
	@Test
	public void testContentView() throws Exception {
		mockMvc.perform(get("/board/content_view"))		
		.andExpect(status().isOk())						
		.andDo(print())									
		.andExpect(forwardedUrl("/WEB-INF/views/content_view.jsp"));
	}


}
