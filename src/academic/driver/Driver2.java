package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 12S23006 - Cardolan Sinaga
 * 12S23050 - Theresia Silaban
 */
public class Driver2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] segments = input.split("#");
            if (segments.length > 0) {
                String command = segments[0];
                switch (command) {
                    case "course-add":
                        if (segments.length == 5) {
                            String code = segments[1];
                            String name = segments[2];
                            int credits = Integer.parseInt(segments[3]);
                            String grade = segments[4];
                            if (!isCourseExist(courses, code)) {
                                courses.add(new Course(code, name, credits, grade));
                                System.out.println("Added course: " + code);
                            } else {
                                System.out.println("Course already exists: " + code);
                            }
                        } else {
                            System.out.println("Invalid input format for course-add. Please enter data in the format: course-add#code#name#credits#grade");
                        }
                        break;
                    case "student-add":
                        if (segments.length == 5) {
                            String nim = segments[1];
                            String nama = segments[2];
                            int angkatan = Integer.parseInt(segments[3]);
                            String prodi = segments[4];
                            if (!isStudentExist(students, nim)) {
                                students.add(new Student(nim, nama, angkatan, prodi));
                                System.out.println("Added student: " + nim);
                            } else {
                                System.out.println("Student already exists: " + nim);
                            }
                        } else {
                            System.out.println("Invalid input format for student-add. Please enter data in the format: student-add#nim#nama#angkatan#prodi");
                        }
                        break;
                    case "enrollment-add":
                        if (segments.length == 5) {
                            String courseCode = segments[1];
                            String studentNim = segments[2];
                            String academicYear = segments[3];
                            String semester = segments[4];
                            if (!isEnrollmentExist(enrollments, courseCode, studentNim, academicYear, semester)) {
                                if (isCourseExist(courses, courseCode)) {
                                    if (isStudentExist(students, studentNim)) {
                                        enrollments.add(new Enrollment(courseCode, studentNim, academicYear, semester));
                                        System.out.println("Added enrollment: " + courseCode + " - " + studentNim);
                                    } else {
                                        System.out.println("invalid student|" + studentNim);
                                    }
                                } else {
                                    System.out.println("invalid course|" + courseCode);
                                }
                            } else {
                                System.out.println("Enrollment already exists: " + courseCode + " - " + studentNim);
                            }
                        } else {
                            System.out.println("Invalid input format for enrollment-add. Please enter data in the format: enrollment-add#courseCode#studentNim#academicYear#semester");
                        }
                        break;
                    default:
                        System.out.println("Unknown command: " + command);
                        break;
                }
            } else {
                System.out.println("Invalid input format. Please enter a valid command.");
            }
        }

        for (Course course : courses) {
            System.out.println(course);
        }

        for (Student student : students) {
            System.out.println(student);
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        scanner.close();
    }

    private static boolean isCourseExist(List<Course> courses, String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStudentExist(List<Student> students, String nim) {
        for (Student student : students) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEnrollmentExist(List<Enrollment> enrollments, String courseCode, String studentNim, String academicYear, String semester) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseCode().equals(courseCode) &&
                enrollment.getStudentNim().equals(studentNim) &&
                enrollment.getAcademicYear().equals(academicYear) &&
                enrollment.getSemester().equals(semester)) {
                return true;
            }
        }
        return false;
    }
}