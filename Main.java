import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaAcademico sistema = new SistemaAcademico();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n===========================================");
            System.out.println("       SISTEMA ACADÉMICO DE CURSOS         ");
            System.out.println("===========================================");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Registrar Docente");
            System.out.println("3. Registrar Curso");
            System.out.println("4. Matricular Alumno en Curso");
            System.out.println("5. Registrar Notas a Alumno (Mínimo 3)");
            System.out.println("6. Mostrar Alumno con Mayor Promedio Ponderado");
            System.out.println("7. Listar Aprobados y Desaprobados por Curso");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
            } else {
                sc.nextLine();
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del Alumno: ");
                    String nomA = sc.nextLine();
                    System.out.print("Ingrese código del Alumno: ");
                    int codA = sc.nextInt();
                    sistema.registrarAlumno(nomA, codA);
                    break;

                case 2:
                    System.out.print("Ingrese nombre del Docente: ");
                    String nomD = sc.nextLine();
                    System.out.print("Ingrese especialidad: ");
                    String espD = sc.nextLine();
                    System.out.print("Ingrese DNI: ");
                    int dniD = sc.nextInt();
                    System.out.print("Ingrese años de experiencia: ");
                    int expD = sc.nextInt();
                    sistema.registrarDocente(nomD, espD, dniD, expD);
                    break;

                case 3:
                    System.out.print("Ingrese código del Curso: ");
                    int codC = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese nombre del Curso: ");
                    String nomC = sc.nextLine();
                    System.out.print("Ingrese nombre del Docente asignado: ");
                    String docC = sc.nextLine();
                    sistema.registrarCurso(codC, nomC, docC);
                    break;

                case 4:
                    System.out.print("Ingrese el código del Alumno: ");
                    int codAluMat = sc.nextInt();
                    System.out.print("Ingrese el código del Curso: ");
                    int codCurMat = sc.nextInt();
                    sistema.matricularAlumno(codAluMat, codCurMat);
                    break;

                case 5:
                    System.out.print("Ingrese el código del Curso: ");
                    int codCurNota = sc.nextInt();
                    Curso cursoNotas = sistema.buscarCursoPorCodigo(codCurNota);
                    if (cursoNotas == null) {
                        System.out.println(" Curso no encontrado.");
                        break;
                    }
                    System.out.print("Ingrese el código del Alumno: ");
                    int codAluNota = sc.nextInt();
                    Alumno aluNotas = sistema.buscarAlumnoPorCodigo(codAluNota);
                    if (aluNotas == null) {
                        System.out.println(" Alumno no encontrado.");
                        break;
                    }

                    int cant = 0;
                    while (cant < 3) {
                        System.out.print("Ingrese la cantidad de notas a registrar (Mínimo 3 evaluacciones): ");
                        cant = sc.nextInt();
                        if (cant < 3) {
                            System.out.println(" La guía exige evaluar MÍNIMO 3 notas.");
                        }
                    }
                    
                    cursoNotas.registrarNotas(aluNotas, cant);
                    System.out.println(" Notas registradas exitosamente.");
                    break;

                case 6:
                    Alumno mejor = sistema.obtenerAlumnoMejorPromedio();
                    if (mejor != null) {
                        System.out.println("\n ALUMNO CON MAYOR PROMEDIO PONDERADO:");
                        System.out.println("Nombre: " + mejor.getNombres());
                        System.out.println("Código: " + mejor.getCódigo());
                        System.out.println("Promedio General: " + String.format("%.2f", mejor.promedioPonderado()));
                    } else {
                        System.out.println("No hay alumnos o notas registradas aún.");
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el código del Curso a consultar: ");
                    int codCurRep = sc.nextInt();
                    Curso cursoRep = sistema.buscarCursoPorCodigo(codCurRep);
                    if (cursoRep != null) {
                        sistema.listarAprobadosYDesaprobados(cursoRep);
                    } else {
                        System.out.println(" Curso no encontrado.");
                    }
                    break;

                case 8:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);

        sc.close();
    }
}