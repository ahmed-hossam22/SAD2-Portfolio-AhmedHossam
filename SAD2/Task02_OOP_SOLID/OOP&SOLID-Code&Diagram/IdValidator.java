import java.util.List;

public class IdValidator {

    public boolean doctorIdExists(int id, List<Doctor> doctors) {
        if (doctors == null) return false;
        for (Doctor d : doctors) {
            if (d.getId() == id) return true;
        }
        return false;
    }

    public boolean patientIdExists(int id, List<Patient> patients) {
        if (patients == null) return false;
        for (Patient p : patients) {
            if (p.getId() == id) return true;
        }
        return false;
    }
}
