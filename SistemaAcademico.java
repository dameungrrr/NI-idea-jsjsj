import java.util.*;
public class SistemaAcademico {
    private ArrayList<Alumno> alumnos;
    private ArrayList<Curso> cursos;
    private ArrayList<Docente> docentes;

    public SistemaAcademico() {
        this.alumnos = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.docentes = new ArrayList<>();
    }


    public Alumno obtenerAlumnoMejorPromedio() {
        if (alumnos.isEmpty()) return null;

        Alumno mejorAlumno = alumnos.get(0);
        for (Alumno a : alumnos) {
            if (a.promedioPonderado() > mejorAlumno.promedioPonderado()) {
                mejorAlumno = a;
            }
        }
        return mejorAlumno;
    }


    public void listarAprobadosYDesaprobados(Curso curso) {
        System.out.println("=== ALUMNOS APROBADOS Y DESAPROBADOS: " + curso.getNombre() + " ===");
        
        for (Alumno alumno : curso.getAlumnos()) { 
            double promedio = curso.promedioAlumno(alumno);
            if (promedio >= 10.5) {
                System.out.println("[APROBADO] " + alumno.getNombres() + " - Nota: " + promedio);
            } else {
                System.out.println("[DESAPROBADO] " + alumno.getNombres() + " - Nota: " + promedio);
            }
        }
    }
}