package json.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * @author: 杨欢
 * @created: 2019-05-09 23:18
 * @description:
 */
public class JacksonTest {

	// java对象转json
	@Test
	public void test1() throws IOException {
		Person person = new Person();
		person.setAge(11);
		person.setName("张三");
		person.setGender("男");

		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writeValueAsString(person);

		System.out.println(s);

//		mapper.writeValue(new File("/Users/hyder/a.txt"), person);
		mapper.writeValue(new FileWriter("/Users/hyder/a.txt"), person);
	}

	@Test
	public void test2() throws JsonProcessingException {
		Person person = new Person();
		person.setAge(11);
		person.setName("张三");
		person.setGender("男");
		person.setBirthday(new Date());

		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writeValueAsString(person);

		System.out.println(s);
	}
}
