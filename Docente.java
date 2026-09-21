public class Docente {
    private String nombre, especialidad;
    private int DNI, añosExperiencia;

    public Docente(String nombre, String especialidad, int DNI, int añosExperiencia){
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.DNI = DNI;
        this.añosExperiencia = añosExperiencia;
    }

    public String getNombre(){
        return nombre;
    }
    public String getEspecialidad(){
        return especialidad;
    }
    public int getDNI(){
        return DNI;
    }
    public int getAñosExperiencia(){
        return añosExperiencia;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
    public void setDNI(int DNI){
        this.DNI = DNI;
    }
    public void setAñosExperiencia(int añosExperiencia){
        this.añosExperiencia = añosExperiencia;
    }
}
