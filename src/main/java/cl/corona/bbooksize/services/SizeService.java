package cl.corona.bbooksize.services;

import cl.corona.bbooksize.model.BbookEnviaSize;
import cl.corona.bbooksize.model.JsonCab;
import cl.corona.bbooksize.model.JsonDet;
import cl.corona.bbooksize.repository.BbookEnviaSizeRepository;
import cl.corona.bbooksize.utilities.Utility;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SizeService {

    @Value("${api_url}")
    private String apiurl;

    @Value("${token_uri}")
    private String token;

    @Autowired
    BbookEnviaSizeRepository updsdirepository;

    private static final Logger LOG = LoggerFactory.getLogger(SizeService.class);

    public void EnvioSize(List<BbookEnviaSize> bbookcollection, String tipo) {

        Gson g = new Gson();
        JsonCab jsoncab = null;
        List<JsonDet> json = new ArrayList<>();
        HttpEntity<String> entity = null;

        try{

            for (BbookEnviaSize row : bbookcollection) {
               json.add(new JsonDet(String.valueOf(row.getTypeId()), row.getTypeName(), row.getSizes(), row.getInactive()));

            }

            jsoncab = new JsonCab(json);
            //jsonend = new JsonEnd(jsoncab);

            HttpHeaders headers = new HttpHeaders();
            headers.set("user-agent", "Application");

            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-Bbook-Token", token);

            entity = new HttpEntity<String>(g.toJson(jsoncab), headers);

        }catch (Exception e) {

            LOG.error("Error al cargar json", e);

        }

        String responses = null;

        try {

            responses = Utility.BulkUpdateApiPoster(entity, apiurl, tipo);

        }catch (Exception e) {

            LOG.error("Error al enviar datos", e);

            responses = "No se pudo informar Marca";
        }

        for (BbookEnviaSize row : bbookcollection) {
            updsdirepository.updSdiSdivpcmst(row.getId());
        }
    }
}
