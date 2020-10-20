package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalcTest {
	static Calc calc = null;

	@BeforeAll
	static void テスト前処理() {
		calc = new Calc();
	}

	@Test
	void addテスト_正常() {
		assertEquals(calc.add(1, 3), 4);
		assertThat(calc.add(1, 3)).isEqualTo(4);
	}

	@AfterAll
	static void テスト後処理() {
		calc = null;
	}

}
