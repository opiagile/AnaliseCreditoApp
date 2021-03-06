package br.com.dock.analiseapp.api.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import br.com.dock.analiseapp.api.enums.Permissao;
import br.com.dock.analiseapp.api.models.Usuario;
import br.com.dock.analiseapp.api.repositories.UsuarioRepository;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Configuration
public class PopularTableUsuario {

	@Bean
	CommandLineRunner initDatabase(UsuarioRepository usuarioRepository) throws NoSuchAlgorithmException {

		List<String[]> usuario = usuarioCSV();
		MessageDigest md = MessageDigest.getInstance("MD5");		
		return args -> {
            for (String[] record : usuario) {             	
            	md.update(record[2].getBytes());
            	usuarioRepository.save(new Usuario(record[0], record[1], md.digest().toString(), Integer.parseInt(record[3]) == 0 ? Permissao.ANALISTA : Permissao.CAPTADOR));
            }
		};

	}
	
    private List<String[]> usuarioCSV() {
        List<String[]> usuario = null;
        
        try {
            Reader reader = Files.newBufferedReader(Paths.get(".\\dados\\usuarios.csv"));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            usuario = csvReader.readAll(); 
            csvReader.close();
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
	
}
