package ma.enset.patientsmvc;

import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
   // @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null,"hassan",new Date(),false,12)
            );
            patientRepository.save(
                    new Patient(null,"fatima",new Date(),true,16)
            );
            patientRepository.save(
                    new Patient(null,"mohammed",new Date(),false,22)
            );
            patientRepository.save(
                    new Patient(null,"aissam",new Date(),false,12)
            );
            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient.getName());
            });
        };
    }

}
