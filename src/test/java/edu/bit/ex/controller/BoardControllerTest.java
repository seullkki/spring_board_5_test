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
	// 테스트 부분은 jUnit에서 제공하는 환경에서 실행해보는 것이고, 톰캣에서 실행하는 것이 아니므로 컨트롤러 테스트가 까다로움
	// jUnit은 "함수"를 테스트해야하는데, get/post로 들어오는 데이터나 url을 처리해야 하므로 까다롭다는 것
	// httpRequest.. 부분은 서버에서 작동하는 것이기 때문.
	// 따라서 컨트롤러 부분은 세부적인 테스트까지는 불가능하고, 대략적인 환경을 조성해 구동할 수 있음.
	// 그 방법은 Mok이라는 객체를 이용해 가상환경을 조성해주는 방법임.

	// 1. 어노테이션 붙여넣기 → 가상환경을 조성해야 하기 때문에, ioc 컨테이너 두개를 모두 가져와야 함
	// 2. 아래 작성

	@Setter(onMethod_ = { @Autowired }) // setter = 아래 객체에 다른 객체를 넣어주려면 setter 필요
	private WebApplicationContext ctx; // WebApplicationContext = 두 개의 ioc 컨테이너를 가져올 때 사용했던 객체
										// 여기에 위해서 받아온 xml 두 개를 읽어와서 객체를 만들어 주입하게(@Autowired) 됨.

	private MockMvc mockMvc; // MockMvc란?
								// 실제 객체와 비슷하지만 테스트에 필요한 기능만 가지는 가짜 객체를 만들어서
								// 애플리케이션 서버에 배포하지 않고도 스프링 MVC 동작을 재현할 수 있는 클래스를 의미.

	@Before // @Before = 테스트 초기화 (@test 전에 미리 세팅되어야 하는 것들을 정의하는 것)
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); // MockMvc의 객체를 만드는 방법.
																		// MockMvcBuilders = static
																		// ctx와 연결되어서 객체를 가져온다고 추측할 수 있음.
	}

	// 3. 기본 세팅 후 본격적 테스트하기
	// cf. ctrl+shift+f : 빨간 줄 한번에 잡아줌
	// get 방식으로 /list를 받는다는 의미
	// forwardedUrl은 진짜 브라우저에 포워드하는 게 아니라, 가상 환경에서 테스트만 한다는 뜻.
	// 테스트 실행 후 콘솔 내용 확인해보기
	// 컨트롤러는 사실 실제 환경에서 돌려야 하기 때문에, 이 정도만 하고 단위 테스트를 했다는 것만 증명하자.
	
	@Test
	public void testList() throws Exception {
		mockMvc.perform(get("/board/list"))		// 맵핑을 GET 방식으로 받는다.
		.andExpect(status().isOk())				// 응답 검증
		.andDo(print())							// 검증되면 print 한다.
		.andExpect(forwardedUrl("/WEB-INF/views/list.jsp"));		// 명시한 url로 포워딩
	}
	
	@Test
	public void testContentView() throws Exception {
		mockMvc.perform(get("/board/content_view"))		
		.andExpect(status().isOk())						
		.andDo(print())									
		.andExpect(forwardedUrl("/WEB-INF/views/content_view.jsp"));
	}


}
