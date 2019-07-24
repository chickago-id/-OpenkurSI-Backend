package backend;

import backend.model.*;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Delete;
import io.micronaut.validation.Validated;
import io.micronaut.http.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

@Validated
@Controller("/materi")
public class MateriController {

    private MateriRepository materiRepository;

    public MateriController(MateriRepository materiRepository) {
        this.materiRepository = materiRepository;
    }

    @Get("/")
    public String index() {
        try {
            List<Materi> materi = materiRepository.findAll();

            MateriResponse response = new MateriResponse("ok", "Data materi", materi);

            return new Gson().toJson(response);
        } catch(Exception e) {
            String message = e.getMessage();

            MateriResponse response = new MateriResponse("error", message);

            return new Gson().toJson(response);
        }
    }

    @Post("/")
    public String create(@Body String userData) {

        try {

            JsonObject data = new JsonParser().parse(userData).getAsJsonObject();
            String kodeMateri = data.get("kode").getAsString();
            String namaMateri = data.get("nama").getAsString();

            Materi materi = new Materi();
            materi.setKodeMateri(kodeMateri);
            materi.setNamaMateri(namaMateri);

            Materi result = materiRepository.save(materi);

            MateriResponse response = new MateriResponse("ok", "Data materi", result);

            return new Gson().toJson(response);


        } catch(Exception e) {
            String message = e.getMessage();

            MateriResponse response = new MateriResponse("error", message);

            return new Gson().toJson(response);
        }

    }

    @Get("/{id}")
    public String show(Long id) {

        try {

            Materi materi = materiRepository.findById(id);

            MateriResponse response = new MateriResponse("ok", "Data materi", materi);

            return new Gson().toJson(response);

        } catch(Exception e) {

            String message = e.getMessage();

            MateriResponse response = new MateriResponse("error", message);

            return new Gson().toJson(response);
        }
        
    }
}
