package deliveryMuchTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;

public class DeliveryMuch {

	@Before
	public void baseUri() {
		RestAssured.baseURI = "http://challengeqa.staging.devmuch.io";
	}

	@Test
	public void testDeliveryPortugues1() {

		RestAssured.given().get("/10000").then().assertThat().statusCode(200).body("extenso",
				Matchers.equalTo("dez mil"));
	}

	@Test
	public void testDeliveryPortugues2() {

		RestAssured.given().get("/-10000").then().assertThat().statusCode(200).body("extenso",
				Matchers.equalTo("menos dez mil"));
	}

	@Test
	public void testDeliveryPortugues3() {

		RestAssured.given().get("/-10001").then().assertThat().statusCode(400).body("extenso",
				Matchers.equalTo("Invalid data"));
	}

	@Test
	public void testDeliveryPortugues4() {

		RestAssured.given().get("/10001").then().assertThat().statusCode(400).body("extenso",
				Matchers.equalTo("Invalid data"));
	}

	@Test
	public void testDeliveryPortugues5() {

		RestAssured.given().get("/0").then().assertThat().statusCode(200).body("extenso", Matchers.equalTo("zero"));
	}

	@Test
	public void testDeliveryIngles1() {

		RestAssured.given().get("/en/10000").then().assertThat().statusCode(200).body("full",
				Matchers.equalTo("ten thousand"));
	}

	@Test
	public void testDeliveryIngles2() {

		RestAssured.given().get("/en/-10000").then().assertThat().statusCode(200).body("full",
				Matchers.equalTo("minus ten thousand"));
	}

	@Test
	public void testDeliveryIngles3() {

		RestAssured.given().get("/en/-10001").then().assertThat().statusCode(400).body("full",
				Matchers.equalTo("Invalid data"));
	}

	@Test
	public void testDeliveryIngles4() {

		RestAssured.given().get("/en/10001").then().assertThat().statusCode(400).body("full",
				Matchers.equalTo("Invalid data"));
	}

	@Test
	public void testDeliveryIngles5() {

		RestAssured.given().get("/en/0").then().assertThat().statusCode(200).body("full", Matchers.equalTo("zero"));
	}
}
