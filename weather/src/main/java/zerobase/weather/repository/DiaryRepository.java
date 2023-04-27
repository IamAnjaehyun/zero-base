package zerobase.weather.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.weather.domain.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary,Integer> {
}
