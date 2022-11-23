package cl.msapp.employee.service;

import cl.msapp.employee.entity.Employee;
import cl.msapp.employee.repository.EmployeeRepository;
import com.google.common.collect.Table;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService{

    @Autowired
    private final EmployeeRepository employeeRepository;

    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {

        Employee employeeDB = employeeRepository.findByRut(employee.getRut());
        if(employeeDB != null)
        {
            return employeeDB;
        }
        employeeDB = employeeRepository.save(employee);
        return employeeDB;
    }

    public Employee updateEmployee(Employee employee) {
        Employee employeeDB = getEmployee(employee.getId());
        if (employeeDB == null){
            return null;
        }
        employeeDB.setRut(employee.getRut());
        employeeDB.setNames(employee.getNames());
        employeeDB.setLastNames(employee.getLastNames());
        employeeDB.setBornDate(employee.getBornDate());
        employeeDB.setCategory(employee.getCategory());
        employeeDB.setEntryDate(employee.getEntryDate());
        return employeeRepository.save(employeeDB);
    }

    public Employee deleteEmployee(Long id) {
        Employee employeeDB = getEmployee(id);
        if (employeeDB == null){
            return null;
        }
        employeeRepository.delete(employeeDB);
        return employeeDB;
    }

    public Employee findByRut(String rut) {
        return employeeRepository.findByRut(rut);
    }

    public List<Employee> findByCategory(String category) {
        return employeeRepository.findByCategory(category);
    }

    public List<Employee> findByEntryDate(String entryDate) {
        return employeeRepository.findByEntryDate(entryDate);
    }

    public List<Employee> findByBornDate(String bornDate) {
        return employeeRepository.findByBornDate(bornDate);
    }

    public Employee deleteByRut(String rut) {
        Employee employeeDB = findByRut(rut);
        if (employeeDB == null){
            return null;
        }
        employeeRepository.delete(employeeDB);
        return employeeDB;
    }

    //Funcion que dado un objeto List<Employee> exporta un archivo xls con los datos de los empleados
    public void exportToXls(List<Employee> employees) {
        //Verificar si la lista de empleados no es nula
        if (employees == null) {
            return;
        }

        //Se ve si hay una carpeta llamada "export" en el directorio raiz del proyecto
        //Si no existe, se crea
        File exportFolder = new File("export");
        if (!exportFolder.exists()) {
            exportFolder.mkdir();
        }

        //Ver si ya existe un archivo llamado "empleados.xls" en la carpeta "export"
        //Si existe, se borra
        File xlsFile = new File("export/empleados.xls");
        if (xlsFile.exists()) {
            xlsFile.delete();
        }


        //Por medio de la libreria POI se crea un libro de excel
        Workbook workbook = new HSSFWorkbook();

        //Se crea una hoja de excel
        Sheet sheet = workbook.createSheet("Employees");

        //Se crea una fila en la hoja de excel
        org.apache.poi.ss.usermodel.Row headerRow = sheet.createRow(0);

        //Se crea una celda en la fila
        headerRow.createCell(0).setCellValue("Rut");
        headerRow.createCell(1).setCellValue("Nombres");
        headerRow.createCell(2).setCellValue("Apellidos");
        headerRow.createCell(3).setCellValue("Fecha de nacimiento");
        headerRow.createCell(4).setCellValue("Categoria");
        headerRow.createCell(5).setCellValue("Fecha de ingreso");

        //Se recorre la lista de empleados
        int rowNum = 1;
        for (Employee employee : employees) {
            org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(employee.getRut());
            row.createCell(1).setCellValue(employee.getNames());
            row.createCell(2).setCellValue(employee.getLastNames());
            row.createCell(3).setCellValue(employee.getBornDate());
            row.createCell(4).setCellValue(employee.getCategory());
            row.createCell(5).setCellValue(employee.getEntryDate());
        }

        //Se crea el archivo xls
        try {
            FileOutputStream outputStream = new FileOutputStream("export/employees.xls");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Se cierra el libro de excel
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Se imprime un mensaje de confirmacion
        System.out.println("Archivo generado con exito");

    }
}
