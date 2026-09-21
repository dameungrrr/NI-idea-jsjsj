import java.util.*;
public class Alumno {
    private String nombres;
    private int código;
    private ArrayList<Curso> cursos;

    public Alumno(String nombre, int código){
        this.nombres = nombre;
        this.código = código;
        this.cursos = new ArrayList<>();
    }

    public String getNombres(){
        return nombres;
    }
    public int getCódigo(){
        return código;
    }
    public void setNombres(String nombre){
        this.nombres = nombre;
    }
    public void setCódigo(int código){
        this.código = código;
    }
    public void agregarCursoALista(Curso curso) {
        this.cursos.add(curso);
    }
    public double promedioPonderado(){
        // 1. Si el alumno no se ha matriculado en ningún curso todavía, su promedio es 0
        if (this.cursos.isEmpty()) {
            return 0.0;
        }

        double sumaPromedios = 0;

        // 2. Recorremos con un bucle cada curso que lleva el alumno
        for (Curso cursoActual : this.cursos) {
            // 3. Le pedimos al curso actual el promedio de ESTE alumno ('this')
            double promCurso = cursoActual.promedioAlumno(this);
            sumaPromedios += promCurso;
        }

        // 4. Retornamos la suma total dividida entre el número de cursos matriculados
        return sumaPromedios / this.cursos.size();
    }

}
//Kiara : el promedio de las notas 
//676766767676767676767676767676767676767676767676767676767676767676767676767676767676767676767676767676767 vas a caer