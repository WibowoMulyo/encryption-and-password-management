package tugas.week3;

public class App {
    public static void main(String[] args) throws Exception {
        PasswordStore pass1 = new PasswordStore("Akun BCA", "1122334455", "RahasiaNegara");
        PasswordStore pass2 = new PasswordStore("Akun Mandiri", "085765432098", "RahasiaLoh", PasswordStore.CAT_MOBILEAPP);
        System.out.println(pass1 + "\n");
        System.out.println(pass2);
    }
}
