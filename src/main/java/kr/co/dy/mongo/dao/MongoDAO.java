package kr.co.dy.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import kr.co.dy.mongo.vo.MongoTestVo;

@Component
public class MongoDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	public void saveMongoData(MongoTestVo mongoTestVo) {
		mongoTemplate.save(mongoTestVo);
	}

	public MongoTestVo findMongoData(String key, String value) {
		// MongoTemplate에서 조건을 검색하기 위해 Criteria 클래스를 사용
		Criteria criteria = new Criteria(key);
		criteria.is(value); // 일치하는 값을 찾기위해 is 메소드 사용

		// 쿼리를 사용한 조회
		Query query = new Query(criteria);

		MongoTestVo vo = mongoTemplate.findOne(query, MongoTestVo.class);

		return vo;
	}

}
