package backend.repository;

import backend.model.NilaiSiswa;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Author : akbar.lazuardi@yahoo.com | akbarlaz@github.com
 */

public interface NilaiSiswaRepository {
    
    NilaiSiswa save(NilaiSiswa nilaiSiswa);
    NilaiSiswa update(Long id, NilaiSiswa nilaiSiswa);
    List<NilaiSiswa> findAll();
    //List<Object> findGroup();
    NilaiSiswa findById(@NotNull Long id);
    void deleteById(@NotNull Long id);

}