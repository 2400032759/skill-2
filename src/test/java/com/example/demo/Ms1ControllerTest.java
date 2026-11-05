package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(Ms1Controller.class)
class Ms1ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void addWithNegativeAndPositiveReturnsZero() throws Exception {
		// Step 1: Build test request -> GET /ms1/add?a=-5&b=5
		mockMvc.perform(get("/ms1/add")
						.param("a", "-5")
						.param("b", "5"))
				// Step 2: Validate status and plain-text payload
				.andExpect(status().isOk())
				.andExpect(content().string("MS 1.1 - Additon = 0"));
	}

}
