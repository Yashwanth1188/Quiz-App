package com.innobyte.quiz.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innobyte.quiz.entity.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question,Long>  {

	public List<Question> findBySubject(String category);

	@Query(value="SELECT DISTINCT subject from question",nativeQuery =true)
	public List<String> fetchAllCategories();

	public Page<Question> findBySubject(String category,Pageable pageable);


}
