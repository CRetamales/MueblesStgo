package cl.msapp.template.service;

import cl.msapp.template.client.ReportClient;
import cl.msapp.template.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

    @Autowired
    ReportClient reportClient;

    public List<Report> listAllReport(){
        return reportClient.listAllEmployee().getBody();
    }
}
