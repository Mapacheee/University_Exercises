#include <iostream>
#include <list>
#include <string>
using namespace std;

class Student;

class Project {
    private:
        string projectName;
        string guideTeacher;
        list<Student*> students;

    public:
        Project(string name, string teacher) : projectName(move(name)), guideTeacher(move(teacher)) {}

        string getGuideTeacher() const { return guideTeacher; }
        string getProjectName() const { return projectName; }

        void addStudent(Student* s) {
            students.push_back(s);
        }

        const list<Student*>& getStudents() const {
            return students;
        }

        void showStudents() const;
};

class Student {
    private:
        string name;
        string rut;
        list<Project*> projects;

    public:
        Student(string n, string r) : name(move(n)), rut(move(r)) {}

        string getName() const { return name; }
        string getRut() const { return rut; }

        void addProject(Project* p) {
            projects.push_back(p);
        }

        const list<Project*>& getProjects() const {
            return projects;
        }

        void showProjects() const {
            cout << "Proyectos de " << name << ":\n";
            for (const auto& p : projects) {
                cout << "- " << p->getProjectName() << " (Profesor: " << p->getGuideTeacher() << ")\n";
            }
        }
};

void Project::showStudents() const {
    cout << "Estudiantes en el proyecto '" << projectName << "':\n";
    for (const auto& s : students) {
        cout << "- " << s->getName() << " (RUT: " << s->getRut() << ")\n";
    }
}

int main() {
    list<Student*> students;
    list<Project*> projects;

    int option;
    do {
        cout << "\n--- Proyectos estudiantiles ---\n";
        cout << "1. Registrar estudiante\n";
        cout << "2. Registrar proyecto\n";
        cout << "3. Asignar estudiante a proyecto\n";
        cout << "4. Ver proyectos de un estudiante\n";
        cout << "5. Ver estudiantes de un proyecto\n";
        cout << "6. Salir\n";
        cout << "Seleccione una opción: ";
        cin >> option;
        cin.ignore();

        if (option == 1) {
            string name, rut;
            cout << "Nombre del estudiante: ";
            getline(cin, name);
            cout << "RUT del estudiante: ";
            getline(cin, rut);

            students.push_back(new Student(name, rut));
            cout << "Estudiante registrado correctamente.\n";

        } else if (option == 2) {
            string name, teacher;
            cout << "Nombre del proyecto: ";
            getline(cin, name);
            cout << "Nombre del profesor guía: ";
            getline(cin, teacher);

            projects.push_back(new Project(name, teacher));
            cout << "Proyecto registrado correctamente.\n";

        } else if (option == 3) {
            string rut, nameProject;
            cout << "RUT del estudiante: ";
            getline(cin, rut);
            cout << "Nombre del proyecto: ";
            getline(cin, nameProject);

            Student* student = nullptr;
            Project* project = nullptr;

            for (auto& s : students) {
                if (s->getRut() == rut) {
                    student = s;
                    break;
                }
            }

            for (auto& p : projects) {
                if (p->getProjectName() == nameProject) {
                    project = p;
                    break;
                }
            }

            if (student && project) {
                student->addProject(project);
                project->addStudent(student);
                cout << "Estudiante asignado." << endl;;
            } else {
                cout << "Estudiante o proyecto no encontrado." << endl;
            }

        } else if (option == 4) {
            string rut;
            cout << "RUT del estudiante: ";
            getline(cin, rut);

            Student* estudiante = nullptr;
            for (auto& s : students) {
                if (s->getRut() == rut) {
                    estudiante = s;
                    break;
                }
            }

            if (estudiante) {
                estudiante->showProjects();
            } else {
                cout << "Estudiante no encontrado.\n";
            }

        } else if (option == 5) {
            string projectName;
            cout << "Nombre del proyecto: ";
            getline(cin, projectName);

            Project* project = nullptr;
            for (auto& p : projects) {
                if (p->getProjectName() == projectName) {
                    project = p;
                    break;
                }
            }

            if (project) {
                project->showStudents();
            } else {
                cout << "Proyecto no encontrado.\n";
            }

        } else if (option == 6) {
            cout << "Adios.\n";
        } else {
            cout << "Opción inválida.\n";
        }

    } while (option != 6);

    for (auto s : students) delete s;
    for (auto p : projects) delete p;

    return 0;
}