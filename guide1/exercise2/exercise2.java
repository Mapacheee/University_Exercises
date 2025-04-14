import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Project {
        private String projectName;
        private String guideTeacher;
        private ArrayList<Student> students;

        public Project(String name, String teacher) {
            this.projectName = name;
            this.guideTeacher = teacher;
            this.students = new ArrayList<>();
        }

        public String getProjectName() {
            return projectName;
        }

        public String getGuideTeacher() {
            return guideTeacher;
        }

        public void addStudent(Student s) {
            students.add(s);
        }

        public ArrayList<Student> getStudents() {
            return students;
        }

        public void showStudents() {
            System.out.println("Estudiantes en el proyecto '" + projectName + "':");
            for (Student s : students) {
                System.out.println("- " + s.getName() + " (RUT: " + s.getRut() + ")");
            }
        }
    }

    static class Student {
        private String name;
        private String rut;
        private ArrayList<Project> projects;

        public Student(String n, String r) {
            this.name = n;
            this.rut = r;
            this.projects = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public String getRut() {
            return rut;
        }

        public void addProject(Project p) {
            projects.add(p);
        }

        public ArrayList<Project> getProjects() {
            return projects;
        }

        public void showProjects() {
            System.out.println("Proyectos de " + name + ":");
            for (Project p : projects) {
                System.out.println("- " + p.getProjectName() + " (Profesor: " + p.getGuideTeacher() + ")");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Proyectos estudiantiles ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar proyecto");
            System.out.println("3. Asignar estudiante a proyecto");
            System.out.println("4. Ver proyectos de un estudiante");
            System.out.println("5. Ver estudiantes de un proyecto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            option = Integer.parseInt(scanner.nextLine());

            if (option == 1) {
                System.out.print("Nombre del estudiante: ");
                String name = scanner.nextLine();
                System.out.print("RUT del estudiante: ");
                String rut = scanner.nextLine();

                students.add(new Student(name, rut));
                System.out.println("Estudiante registrado correctamente.");

            } else if (option == 2) {
                System.out.print("Nombre del proyecto: ");
                String name = scanner.nextLine();
                System.out.print("Nombre del profesor guía: ");
                String teacher = scanner.nextLine();

                projects.add(new Project(name, teacher));
                System.out.println("Proyecto registrado correctamente.");

            } else if (option == 3) {
                System.out.print("RUT del estudiante: ");
                String rut = scanner.nextLine();
                System.out.print("Nombre del proyecto: ");
                String nameProject = scanner.nextLine();

                Student student = null;
                Project project = null;

                for (Student s : students) {
                    if (s.getRut().equals(rut)) {
                        student = s;
                        break;
                    }
                }

                for (Project p : projects) {
                    if (p.getProjectName().equals(nameProject)) {
                        project = p;
                        break;
                    }
                }

                if (student != null && project != null) {
                    student.addProject(project);
                    project.addStudent(student);
                    System.out.println("Estudiante asignado.");
                } else {
                    System.out.println("Estudiante o proyecto no encontrado.");
                }

            } else if (option == 4) {
                System.out.print("RUT del estudiante: ");
                String rut = scanner.nextLine();

                Student estudiante = null;
                for (Student s : students) {
                    if (s.getRut().equals(rut)) {
                        estudiante = s;
                        break;
                    }
                }

                if (estudiante != null) {
                    estudiante.showProjects();
                } else {
                    System.out.println("Estudiante no encontrado.");
                }

            } else if (option == 5) {
                System.out.print("Nombre del proyecto: ");
                String projectName = scanner.nextLine();

                Project project = null;
                for (Project p : projects) {
                    if (p.getProjectName().equals(projectName)) {
                        project = p;
                        break;
                    }
                }

                if (project != null) {
                    project.showStudents();
                } else {
                    System.out.println("Proyecto no encontrado.");
                }

            } else if (option == 6) {
                System.out.println("Adios.");
            } else {
                System.out.println("Opción inválida.");
            }

        } while (option != 6);

        scanner.close();
    }
}
