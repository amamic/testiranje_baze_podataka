public class Main {

    public static void main(String[] args) {

        Patient p1 = new Patient("Pero", "Perić", "pero.peric@gmail.com", "22.10.1986.");
        Patient p2 = new Patient("Ivo", "Ivić", "ivo.ivic@gmail.com", "22.12.1986.");
        Patient p3 = new Patient("Mato", "Matić", "mato.matic@gmail.com", "22.01.1986.");

        BloodPressureRecord r1 = new BloodPressureRecord("22.10.1986.","pero.peric@gmail.com", "130", "80", "opis1");
        BloodPressureRecord r2 = new BloodPressureRecord("22.10.1986.","ivo.ivic@gmail.com", "150", "100", "opis2");

        DatabaseManagerPatient databaseManager = new DatabaseManagerPatient();
        DatabaseManagerRecord databaseManagerRecord = new DatabaseManagerRecord();

        databaseManager.createNewDatabase("test_patients.db");
        databaseManager.addPatient(p1);
        databaseManager.addPatient(p2);
        databaseManager.addPatient(p3);

        databaseManagerRecord.createNewDatabase("test_patients.db");
        databaseManagerRecord.addRecord(r1);
        databaseManagerRecord.addRecord(r2);






    }
}
