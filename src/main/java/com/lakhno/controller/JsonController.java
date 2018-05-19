package com.lakhno.controller;

import com.lakhno.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Simple JSON controller.
 *
 * Created by Lakhno Anton
 * at 23:38 17.05.2018.
 *
 * @author Lakhno Anton
 * @version 1.0.1
 * @since 1.0.1
 */
@Controller
@RequestMapping(value = "/json")
public class JsonController {

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public @ResponseBody Person getPersonById(@PathVariable("id") Long personId) {
		Person mick = new Person();
		mick.setId(personId);
		mick.setName("Mick");
		mick.setAge(24);
		mick.setSex(Person.Sex.MALE);
		mick.setNativeLanguage(Person.NativeLanguage.ENGLISH);
		return mick;
	}

}
