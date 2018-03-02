package kr.co.dy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.dy.mongo.dao.MongoDAO;
import kr.co.dy.mongo.vo.MongoTestVo;

@Controller
public class MongoTestController {

	@Autowired
	MongoDAO mongoDao;

	@RequestMapping(value = "/save")
	@ResponseBody
	public String saveTest() {

		MongoTestVo mongoTestVo = new MongoTestVo();
		mongoTestVo.set_id("1");
		mongoTestVo.setData1("data1");
		mongoTestVo.setData2("data2");

		mongoDao.saveMongoData(mongoTestVo);

		return mongoTestVo.toString();
	}

	@RequestMapping(value = "/find")
	@ResponseBody
	public String findTest() {
		return mongoDao.findMongoData("_id", "1").toString();
	}

}
