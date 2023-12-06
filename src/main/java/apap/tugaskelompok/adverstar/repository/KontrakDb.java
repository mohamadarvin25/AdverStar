package apap.tugaskelompok.adverstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import apap.tugaskelompok.adverstar.model.KontrakModel;
import apap.tugaskelompok.adverstar.dto.KontrakCountDAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface KontrakDb extends JpaRepository<KontrakModel, Integer>{
    Optional<KontrakModel> findByIdKontrak(int idKontrak);
    @Query(value = "SELECT new apap.tugaskelompok.adverstar.dto.KontrakCountDAO(i.nama, k.jenis, count(k)) FROM IdolModel i JOIN i.listKontrak k where i.nama = :nama GROUP BY i.nama, k.jenis")
    List<KontrakCountDAO> countByJenisAndNameEquals(@Param(value = "nama") String nama);


}
