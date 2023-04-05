package cl.corona.bbooksize.repository;

import cl.corona.bbooksize.model.BbookEnviaSize;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BbookEnviaSizeRepository extends CrudRepository<BbookEnviaSize, String> {

    public List<BbookEnviaSize> findAllByTranType(String tranType);

    @Modifying(clearAutomatically = true)
    @Query(value = "update app_sam.sdi_sdivpcmst s set s.download_date_1 = sysdate where rowid = :id", nativeQuery = true)
    public void updSdiSdivpcmst(@Param("id") String id);
}
