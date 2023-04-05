package cl.corona.bbooksize.scheduler;


import cl.corona.bbooksize.model.BbookEnviaSize;
import cl.corona.bbooksize.repository.BbookEnviaSizeRepository;
import cl.corona.bbooksize.services.SizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTasks {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    private SizeService sizeService;

    private BbookEnviaSizeRepository bbookenviosizerepository;


    @Autowired
    public ScheduledTasks(BbookEnviaSizeRepository bbookenviosizerepository) {
        this.bbookenviosizerepository = bbookenviosizerepository;
    }

    @Scheduled(cron = "${cron.expression}")
    public void scheduledBbook() throws InterruptedException {
        LOG.info("{} : Generacion periodica para el envio de Colores  - {}",
                dateTimeFormatter.format(LocalDateTime.now()));

        // Date exceptions
        LocalDate today = LocalDate.now();
        int count = 0;
        List<BbookEnviaSize> Bbboksize = new ArrayList<>();

        try {
            String statusBrand = "T";
            Bbboksize = (List<BbookEnviaSize>) bbookenviosizerepository.findAllByTranType("A");

        } catch (InvalidDataAccessResourceUsageException e) {
            LOG.error("{}: Ocurrio un error al momento de rescatar las Marcas: ", e);
            return;
        }

        LOG.info("Cantidad de Marcas para generar: {}", Bbboksize.size());

        if (Bbboksize.size() > 0) {
            sizeService.EnvioSize(Bbboksize, "A");
        }

        try {
            String statusBrand = "T";
            Bbboksize = (List<BbookEnviaSize>) bbookenviosizerepository.findAllByTranType("C");

        } catch (InvalidDataAccessResourceUsageException e) {
            LOG.error("{}: Ocurrio un error al momento de rescatar las Marcas: ", e);
            return;
        }

        LOG.info("Cantidad de Marcas para generar: {}", Bbboksize.size());

        if (Bbboksize.size() > 0) {
            sizeService.EnvioSize(Bbboksize, "C");
        }

        try {
            String statusBrand = "T";
            Bbboksize = (List<BbookEnviaSize>) bbookenviosizerepository.findAllByTranType("D");

        } catch (InvalidDataAccessResourceUsageException e) {
            LOG.error("{}: Ocurrio un error al momento de rescatar las Marcas: ", e);
            return;
        }

        LOG.info("Cantidad de Marcas para generar: {}", Bbboksize.size());

        if (Bbboksize.size() > 0) {
            sizeService.EnvioSize(Bbboksize, "D");
        }
    }
}
