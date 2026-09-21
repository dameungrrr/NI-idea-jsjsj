import java.util.*;
public class Curso {
    private int código;
    private String nombre, docente;
    private ArrayList<Alumno> alumnos;
    private HashMap<Alumno, ArrayList<Double>> notas;
    Scanner sc = new Scanner(System.in);

    public Curso(int código, String nombre, String docente){
        this.código = código;
        this.nombre = nombre;
        this.docente = docente;
        this.notas = new HashMap<>();
        this.alumnos = new ArrayList<>();
    }

    public int getCódigo(){
        return código;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDocente(){
        return docente;
    }
    public void setCódigo(int código){
        this.código = código;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDocente(String docente){
        this.docente = docente;
    }
    public void matricularAlumno(Alumno alumno){
        alumnos.add(alumno);
        notas.put(alumno, new ArrayList<>());
        alumno.agregarCursoALista(this); 
    }
    public double promedioAlumno(Alumno alumno){
        // 1. CONTROL DE SEGURIDAD: Si el alumno no está matriculado en el curso o no tiene notas, devolvemos 0
        if (!notas.containsKey(alumno) || notas.get(alumno).isEmpty()) {
            return 0.0;
        }
        
        // 2. EXTRAER EL REGISTRO: Traemos el ArrayList de notas de este alumno desde el HashMap
        ArrayList<Double> notasAlumno = notas.get(alumno);
        
        double suma = 0;
        for (double nota : notasAlumno) {
            suma += nota; // Sumamos la nota actual
        }
        
        // 4. DIVIDIR SOBRE .SIZE(): Retornamos la suma total dividida entre el número de notas
        return suma / notasAlumno.size();
    }

    public ArrayList<Double> registrarNotas(Alumno alumno, int cantidad){
        ArrayList<Double> registro = new ArrayList<>();
        for (int i=0; i<cantidad; i++) {
            System.out.println("Ingresa la nota "+i);
            double nota = sc.nextDouble();
            registro.add(nota);
        }
        this.notas.put(alumno, registro);
        return registro;
    }
}
