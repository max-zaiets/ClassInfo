import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву класу:");
        String className = scanner.next();
        Class<?> cl1;
        try {
            cl1 = Class.forName("java.lang." + className);
        } catch (ClassNotFoundException e) {
            cl1 = Class.forName("java.util." + className);
        }
        System.out.println((char) 27 + "[34m" + "Інформація про клас " + (char) 27 + "[39m");
        System.out.print("   ");
        System.out.println(cl1);
        System.out.println((char) 27 + "[34m" + "Модифікатори класу " + (char) 27 + "[39m");
        System.out.print("   ");
        modifierInfo(cl1);
        System.out.println((char) 27 + "[34m" + "Поля класу " + (char) 27 + "[39m");
        printMembers(cl1.getFields());
        System.out.println((char) 27 + "[34m" + "Конструктори класу " + (char) 27 + "[39m");
        printMembers(cl1.getConstructors());
        System.out.println((char) 27 + "[34m" + "Методи класу " + (char) 27 + "[39m");
        printMembers(cl1.getMethods());
        System.out.println((char) 27 + "[34m" + "Анотації класу " + (char) 27 + "[39m");
        System.out.print("   ");
        System.out.println(Arrays.toString(cl1.getAnnotations()));
        System.out.println((char) 27 + "[34m" + "Пакет класу " + (char) 27 + "[39m");
        System.out.print("   ");
        System.out.println(cl1.getPackageName());
        System.out.println((char) 27 + "[34m" + "Реалізовані інтерфейси" + (char) 27 + "[39m");
        System.out.print("   ");
        System.out.println(Arrays.toString(cl1.getInterfaces()));
        System.out.println((char) 27 + "[34m" + "Супер клас" + (char) 27 + "[39m");
        System.out.print("   ");
        System.out.println(cl1.getSuperclass());
        System.out.println((char) 27 + "[34m" + "Просте ім'я класу " + (char) 27 + "[39m");
        System.out.print("   ");
        System.out.println(cl1.getSimpleName());
    }

    private static void printMembers(Member[] members) {
        for (Member member : members) {
            if (member.getDeclaringClass() == Object.class) {
                continue;
            }
            String decl = member.toString();
            System.out.print("   ");
            System.out.println(decl);
        }
    }

    private static void modifierInfo(Class<?> cl) {
        int mods = cl.getModifiers();
        if (Modifier.isPrivate(mods)) {
            System.out.print("private ");
        }
        if (Modifier.isAbstract(mods)) {
            System.out.print("abstract ");
        }
        if (Modifier.isStatic(mods)) {
            System.out.print("static ");
        }
        if (Modifier.isFinal(mods)) {
            System.out.print("final ");
        }
        System.out.println();
    }
}
