package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.News;

public interface NewsRepository extends JpaRepository<News, Long> {

	@Query(value = "SELECT * FROM intranetPortal.news;", nativeQuery=true)
	public List<News> getNewsList(); 
	
	@Query(value = "SELECT * FROM intranetPortal.news GROUP BY id_news DESC LIMIT 3 ;", nativeQuery=true)
	public List<News> getLatestNewsList(); 
	
	@Modifying
	@Query(value = "DELETE FROM intranetPortal.news WHERE title=:newsTitle ;", nativeQuery=true)
	public void deleteNewsFromTitle(@Param("newsTitle") String title); 
	
	@Query(value = "SELECT * FROM intranetPortal.news WHERE intranetPortal.news.title=:newsTitle LIMIT 1;", nativeQuery=true)
	public News getNewsFromTitle(@Param("newsTitle") String title); 
	
	@Modifying
	@Query(value = "UPDATE intranetPortal.news "
			+ "SET title=:newsTitle , "
			+ " description=:newsDescription , "
			+ " image=:newsImage , "
			+ " date=:newsDate , "
			+ " is_active=:newsIsActive "
			+ "WHERE id_news=:newsId LIMIT 1;", nativeQuery=true)
	public void updateNews(@Param("newsId") Long id, @Param("newsTitle") String title, @Param("newsDescription") String description,
			@Param("newsImage") String image, @Param("newsDate") String date, @Param("newsIsActive") boolean isActive); 
	
	
}
