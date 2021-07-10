package com.doodla.engine.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doodla.engine.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {

	@Query("SELECT count(*) FROM Follow f WHERE f.parent = :parentId and f.child = :childId")
	int countMapping(@Param("parentId")long parentId, @Param("childId") long childId);
	
	@Modifying
	@Transactional
	@Query("UPDATE Follow f SET f.status=true where f.parent = :parentId and f.child = :childId")
	Follow updateStatus(long parentId, long childId);
	
	@Modifying
	@Query("DELETE Follow f where f.parent = :parentId and f.child = :childId")
	Follow delete(long parentId, long childId);


}