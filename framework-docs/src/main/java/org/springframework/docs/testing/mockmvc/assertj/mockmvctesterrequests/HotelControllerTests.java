/*
 * Copyright 2002-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.docs.testing.mockmvc.assertj.mockmvctesterrequests;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Stephane Nicoll
 */
public class HotelControllerTests {

	private final MockMvcTester mockMvc = MockMvcTester.of(new HotelController());


	void createHotel() {
		// tag::post[]
		assertThat(mockMvc.post().uri("/hotels/{id}", 42).accept(MediaType.APPLICATION_JSON))
				. // ...
				// end::post[]
				hasStatusOk();
	}

	void createHotelMultipleAssertions() {
		// tag::post-exchange[]
		MvcTestResult result = mockMvc.post().uri("/hotels/{id}", 42)
				.accept(MediaType.APPLICATION_JSON).exchange();
		assertThat(result). // ...
				// end::post-exchange[]
				hasStatusOk();
	}

	void queryParameters() {
		// tag::query-parameters[]
		assertThat(mockMvc.get().uri("/hotels?thing={thing}", "somewhere"))
				. // ...
				// end::query-parameters[]
				hasStatusOk();
	}

	void parameters() {
		// tag::parameters[]
		assertThat(mockMvc.get().uri("/hotels").param("thing", "somewhere"))
				. // ...
				// end::parameters[]
				hasStatusOk();
	}

	static class HotelController {}
}
