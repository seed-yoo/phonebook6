package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {

	@Autowired
	private PhonebookService phonebookService;

	// 수정폼
	// localhost:8080/phonebook5/phone/modifyform
	@RequestMapping(value = "/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model) {
		System.out.println("/phone/modifyForm.jsp");

		PersonVo personVo = phonebookService.exeModifyForm(no);

		model.addAttribute("pVo", personVo);
		return "/modifyForm";
	}

	// 수정폼2
	// localhost:8080/phonebook5/phone/modifyform
	@RequestMapping(value = "/modifyform2", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm2(@RequestParam(value = "no") int no, Model model) {
		System.out.println("phonebookController.modifyform2()");
		System.out.println(no);

		Map<String, Object> pMap = phonebookService.exeModifyForm2(no);
		model.addAttribute("pMap", pMap);

		return "/modifyForm2";

	}

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("phonebookController.list()");

		// 자동연결
		List<PersonVo> personList = phonebookService.exeList();

		model.addAttribute("pList", personList);

		return "/list";

	}

	// 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {

		System.out.println("phonebookController.modify()");

		// System.out.println(personVo);

		phonebookService.exeModify(personVo);

		// 리스트로 리다이렉트
		return "redirect:/phone/list";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {

		System.out.println("phonebookController.delete()");

		// System.out.println(personId);

		phonebookService.exeDelete(no);

		// 리스트로 리다이렉트
		return "redirect:/phone/list";

	}

	// 등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write()");

		// System.out.println(personVo);

		phonebookService.exeWrite(personVo);

		return "redirect:/phone/list";
	}

	// 등록폼
	@RequestMapping(value = "/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");

		return "writeForm";
	}
}
