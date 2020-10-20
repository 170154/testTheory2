package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserManagerTest {
	static UserManager userManager = null;
	static List<User> userList = new ArrayList<User>();// (Arrays.asList("Apple", "Orange", "Melon"));
	static String testNameList[] = { "Itiro", "Jiro", "Saburo" };

	@BeforeAll
	static void テスト前処理() {
		userManager = UserManager.getInstance();
		User user1 = new User("1");
		for (String str : testNameList) {
			user1.setName(str);
			userList.add(user1);
		}
	}

	@AfterEach
	void 各テスト前処理() {
		userManager.deleteAllUser();
	}

	@Test
	void 正常系UserManagerインスタンス同一() {
		UserManager userManager1 = UserManager.getInstance();
		UserManager userManager2 = UserManager.getInstance();
		UserManager userManager3 = UserManager.getInstance();

		assertEquals(userManager1, userManager2);
		assertEquals(userManager2, userManager3);
		assertEquals(userManager3, userManager1);
	}

	@Test
	void 正常系_userList登録参照() {
		UserManager test1 = UserManager.getInstance();
		User user1 = new User("1");
		User user2 = new User("2");
		User user3 = new User("3");
		test1.setUserToList(user1);
		test1.setUserToList(user2);
		test1.setUserToList(user3);

		assertThat(test1.getUserList()).contains(user1, user2, user3);

	}

	@Test
	void 正常系_userMap登録参照() {
		UserManager test1 = UserManager.getInstance();
		User user1 = new User("1");
		User user2 = new User("2");
		User user3 = new User("3");
		test1.setUserToMap(user1);
		test1.setUserToMap(user2);
		test1.setUserToMap(user3);

		assertThat(test1.getUserMap()).containsValues(user1, user2, user3);
	}

	@Test
	void 正常系_user全削除() {
		UserManager test1 = UserManager.getInstance();
		User user1 = new User("1");
		User user2 = new User("2");
		User user3 = new User("3");
		test1.setUserToList(user1);
		test1.setUserToList(user2);
		test1.setUserToList(user3);

		test1.deleteAllUser();

		assertThat(test1.getUserList()).doesNotContain(user1, user2, user3);

	}

	@Test
	void 正常系_code指定user削除() {
		UserManager test1 = UserManager.getInstance();
		User user1 = new User("1");
		User user2 = new User("2");
		User user3 = new User("3");
		test1.setUserToList(user1);
		test1.setUserToList(user2);
		test1.setUserToList(user3);

		test1.deleteUser("1");

		assertThat(test1.getUserList()).doesNotContain(user1);
//		deleteUser(String)

	}

	@Test
	void 異常系_ex() {
		UserManager test1 = UserManager.getInstance();
		User user1 = new User("1");
		User user2 = new User("2");
		User user3 = new User("3");
		test1.setUserToList(user1);
		test1.setUserToList(user2);
		test1.setUserToList(user3);
		test1.setUserToList(user1);
		test1.deleteUser("1");

		assertThat(test1.getUserList()).isNotIn(user1);
		System.out.println(test1.getUserList());
	}

	// 課題5
	@Test
	void 正常系_MapList初期生成() {
		UserManager test1 = UserManager.getInstance();
		User mapUser1 = new User("1");
		User listUser1 = new User("2");
		test1.setUserToMap(mapUser1);
		test1.setUserToList(listUser1);

		test1.deleteAllUser();

		assertThat(test1.getUserList()).isNotNull();
		assertThat(test1.getUserMap()).isNotNull();

	}

	void 正常系_List登録順序保持() {
		UserManager test1 = UserManager.getInstance();
		User user1 = new User("1");
		User user2 = new User("2");
		User user3 = new User("3");
		test1.setUserToList(user1);
		test1.setUserToList(user2);
		test1.setUserToList(user3);

		assertThat(test1.getUserList()).doesNotContain(user1);
	}

	void 正常系_Mapキー確認() {
		UserManager test1 = UserManager.getInstance();
		User mapUser1 = new User("1");
		test1.setUserToMap(mapUser1);
//		assertThat(test1.getUserMap()).
	}

	@AfterAll
	static void テスト後処理() {
		userManager = null;
	}
}
