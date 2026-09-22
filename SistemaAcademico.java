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

    // Getters de las listas
    public ArrayList<Alumno> getAlumnos() { return alumnos; }
    public ArrayList<Curso> getCursos() { return cursos; }
    public ArrayList<Docente> getDocentes() { return docentes; }

    // --- BÚSQUEDAS ---
    public Alumno buscarAlumnoPorCodigo(int codigo) {
        for (Alumno a : alumnos) {
            if (a.getCódigo() == codigo) return a;
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(int codigo) {
        for (Curso c : cursos) {
            if (c.getCódigo() == codigo) return c;
        }
        return null;
    }

    public Docente buscarDocentePorDNI(int dni) {
        for (Docente d : docentes) {
            if (d.getDNI() == dni) return d;
        }
        return null;
    }

    // --- REGISTROS CON VALIDACIÓN ---

    // 1. Registrar Alumno (Validación: Código Único)
    public boolean registrarAlumno(String nombre, int codigo) {
        if (buscarAlumnoPorCodigo(codigo) != null) {
            System.out.println(" ERROR: El código de alumno " + codigo + " ya existe.");
            return false;
        }
        alumnos.add(new Alumno(nombre, codigo));
        System.out.println(" Alumno registrado correctamente.");
        return true;
    }

    // 2. Registrar Docente (Validación: DNI Único)
    public boolean registrarDocente(String nombre, String especialidad, int dni, int experiencia) {
        if (buscarDocentePorDNI(dni) != null) {
            System.out.println(" ERROR: El docente con DNI " + dni + " ya existe.");
            return false;
        }
        docentes.add(new Docente(nombre, especialidad, dni, experiencia));
        System.out.println(" Docente registrado correctamente.");
        return true;
    }

    // 3. Registrar Curso asociado a un Docente
    public boolean registrarCurso(int codigo, String nombre, String nombreDocente) {
        if (buscarCursoPorCodigo(codigo) != null) {
            System.out.println(" ERROR: El código de curso " + codigo + " ya existe.");
            return false;
        }
        cursos.add(new Curso(codigo, nombre, nombreDocente));
        System.out.println(" Curso registrado correctamente y asignado a " + nombreDocente + ".");
        return true;
    }

    // 4. Matricular Alumno en un Curso
    public boolean matricularAlumno(int codigoAlumno, int codigoCurso) {
        Alumno alumno = buscarAlumnoPorCodigo(codigoAlumno);
        Curso curso = buscarCursoPorCodigo(codigoCurso);

        if (alumno == null) {
            System.out.println(" ERROR: Alumno no encontrado.");
            return false;
        }
        if (curso == null) {
            System.out.println(" ERROR: Curso no encontrado.");
            return false;
        }

        curso.matricularAlumno(alumno);
        System.out.println(" Alumno " + alumno.getNombres() + " matriculado en " + curso.getNombre() + ".");
        return true;
    }

    // --- REPORTES Y CÁLCULOS ---

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
        System.out.println("\n=== ALUMNOS EN CURSO: " + curso.getNombre() + " ===");
        if (curso.getAlumnos().isEmpty()) {
            System.out.println("No hay alumnos matriculados en este curso.");
            return;
        }

        for (Alumno alumno : curso.getAlumnos()) { 
            double promedio = curso.promedioAlumno(alumno);
            if (promedio >= 10.5) {
                System.out.println(" [APROBADO] " + alumno.getNombres() + " (Cód: " + alumno.getCódigo() + ") - Promedio: " + String.format("%.2f", promedio));
            } else {
                System.out.println(" [DESAPROBADO] " + alumno.getNombres() + " (Cód: " + alumno.getCódigo() + ") - Promedio: " + String.format("%.2f", promedio));
            }
        }
    }
}