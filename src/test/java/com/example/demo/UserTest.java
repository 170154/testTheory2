package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserTest {
	static User user = null;
	static String name = "aiueo";
	static String code = "setNo1";
	static int age = 20;

	@BeforeAll
	static void テスト前処理() {
		user = new User(null);
	}

//	@Test
//	void addテスト_正常() {
//		assertEquals(user.add(1, 3), 4);
//		assertThat(user.add(1, 3)).isEqualTo(4);
//	}
	@Test
	void 正常系_ユーザ管理コード登録参照() {
		user.setCode(code);
		assertEquals(user.getCode(), code);
	}

	@Test
	void 正常系_名前登録参照() {
		user.setName(name);
		assertEquals(user.getName(), name);
	}

	@Test
	void 正常系_年齢登録参照() {
		user.setAge(age);
		assertEquals(user.getAge(), age);
	}

	@Test
	void 異常系_範囲外年齢登録() {
		user.setAge(200);
		assertEquals(user.getAge(), -1);
	}

	@Test
	void 異常系_NoName() {
		assertEquals(user.getAge(), -1);

	}

	@AfterAll
	static void テスト後処理() {
		user = null;
	}
}
