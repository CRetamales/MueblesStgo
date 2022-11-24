package cl.msapp.report.model;


import lombok.Data;

@Data
public class Employee {

    private Long id;

    private String rut;

    private String names;

    private String lastNames;

    private String bornDate;

    private String category;

    private String entryDate;

    //Metodo que dado una fecha calcula los años hasta la fecha de entryDate
    public int getYearsCompany(){
        //Formato de fecha: yyyy/mm/dd
        String[] dateParts = entryDate.split("/");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        //fecha actual con date
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
        String currentDate = sdf.format(date);
        String[] currentDateParts = currentDate.split("/");
        int currentYear = Integer.parseInt(currentDateParts[0]);
        int currentMonth = Integer.parseInt(currentDateParts[1]);
        int currentDay = Integer.parseInt(currentDateParts[2]);

        int years = currentYear - year;
        if (currentMonth < month){
            years--;
        }else if (currentMonth == month){
            if (currentDay < day){
                years--;
            }
        }
        return years;
    }

}
