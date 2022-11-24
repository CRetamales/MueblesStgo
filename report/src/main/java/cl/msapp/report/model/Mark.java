package cl.msapp.report.model;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Data
public class Mark {

    private Long id;

    private String rut;

    private String date;

    private String hour;

    public int getDia(){
        return Integer.parseInt(this.date.substring(8,10));
    }

    public int getAhno(){
        return Integer.parseInt(this.date.substring(0,4));
    }

    public int getMes(){
        return Integer.parseInt(this.date.substring(5,7));
    }

    public int getHoras() {
        return Integer.parseInt(hour.substring(0, 2));
    }

    public int getMinutos() {
        return Integer.parseInt(hour.substring(3, 5));
    }

    /**
     * Funcion que dado la marca de salida calcula la cantidad de horas trabajadas
     * @param salida - Marca de salida
     * @return - Cantidad de horas trabajadas
     */
    public int calcularHorasTrabajadas(Mark salida) {
        int horaEntradaInt = this.getHoras();
        int horaSalidaInt =  salida.getHoras();
        int minutosEntradaInt = this.getMinutos();
        int minutosSalidaInt =  salida.getMinutos();
        int horasTrabajadas = horaSalidaInt - horaEntradaInt;
        int minutosTrabajados = minutosSalidaInt - minutosEntradaInt;
        if (minutosTrabajados < 0) {
            horasTrabajadas -= 1;
        }
        return horasTrabajadas;
    }

    /**
     * Funcion que dado la marca de entrada y la marca de salida calcula la cantidad de horas extras trabajadas
     * @param entrada - Marca de entrada
     * @param salida - Marca de salida
     * @return - Cantidad de horas extras trabajadas
     */
    public int calcularHorasExtras(Mark entrada, Mark salida) {
        int horaEntradaInt = entrada.getHoras();
        int horaSalidaInt = salida.getHoras();
        int minutosEntradaInt = entrada.getMinutos();
        int minutosSalidaInt = salida.getMinutos();
        int horasTrabajadas = horaSalidaInt - horaEntradaInt;
        int minutosTrabajados = minutosSalidaInt - minutosEntradaInt;
        if (minutosTrabajados < 0) {
            horasTrabajadas -= 1;
        }
        if (horasTrabajadas > 10) {
            return horasTrabajadas - 10;
        } else {
            return 0;
        }
    }

    /**
     * Funcion que determina cuantos minutos se ha retrasado
     * @return - Cantidad de minutos de retraso
     */
    public int calcularRetraso() {
        int horaEntradaInt = this.getHoras();
        int minutosEntradaInt = this.getMinutos();
        int minutosRetraso = 0;
        if (horaEntradaInt > 8) {
            minutosRetraso += (horaEntradaInt - 8) * 60;
        }
        if (minutosEntradaInt > 0) {
            minutosRetraso += minutosEntradaInt;
        }
        return minutosRetraso;
    }

    public int getCantidadAnhos_Actual(String fecha1){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        int anhoActual = Integer.parseInt(formatter.format(new java.util.Date()));
        int anho = Integer.parseInt(fecha1.substring(0,4));
        return anhoActual - anho;
    }


    /**
     * Funcion que retorna si es dia habil o no
     * @return true si es dia habil, false si no lo es
     */
    public boolean esDiaHabil() {
        int anho = this.getAhno();
        int mes = this.getMes();
        int dia = this.getDia();
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            if (dia >= 1 && dia <= 31) {
                return true;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia >= 1 && dia <= 30) {
                return true;
            }
        } else if (mes == 2) {
            if (anho % 4 == 0) {
                if (dia >= 1 && dia <= 29) {
                    return true;
                }
            } else {
                if (dia >= 1 && dia <= 28) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Funcion que retorna si el dia se encuentra entre el lunes y el viernes
     * @return true si se encuentra entre lunes y viernes, false si no lo esta
     */
    public boolean isRangeLunesViernes(){
        Calendar c = Calendar.getInstance();
        c.set(this.getAhno(), this.getMes(), this.getDia());
        int dia = c.get(Calendar.DAY_OF_WEEK);
        if(dia >= 2 && dia <= 6){
            return true;
        }
        return false;
    }


    /**
     * Funcion que retorna un listado de dias habiles,dado un mes y un año
     * @param mes - int
     * @param anho - int
     *        Formato: yyyy/mm/dd
     *             Ejemplo: 2019/01/01
     * @return listado de dias habiles (String)
     */
    public List<String> getDiasHabiles(int mes, int anho){
        List<String> listado = null;
        for(int i = 1; i <= 31; i++){
            this.date = anho + "/" + mes + "/" + i;
            if(this.esDiaHabil()){
                listado.add(this.date);
            }
        }
        return listado;
    }
}
