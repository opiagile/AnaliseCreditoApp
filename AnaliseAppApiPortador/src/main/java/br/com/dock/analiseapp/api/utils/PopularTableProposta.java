package br.com.dock.analiseapp.api.utils;

import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import br.com.dock.analiseapp.api.enums.Status;
import br.com.dock.analiseapp.api.models.Portador;
import br.com.dock.analiseapp.api.models.Proposta;
import br.com.dock.analiseapp.api.repositories.PortadorRepository;
import br.com.dock.analiseapp.api.repositories.PropostaRepository;

@Configuration
public class PopularTableProposta {

	@Bean
	CommandLineRunner initDatabase(PropostaRepository propostaRepository, PortadorRepository portadorRepository) throws NoSuchAlgorithmException {

		List<String[]> proposta = propostaCSV();		
		List<String[]> portador = portadorCSV();
		
		return args -> {
			for (String[] record : proposta) {
				Status status;
				switch (Integer.parseInt(record[1])) {
				case 0:
					status = Status.PENDENTE;
					break;
				case 1:
					status = Status.APROVADO;
					break;
				case 2:
					status = Status.NEGADO;
					break;
				default:
					status = Status.PENDENTE;
					break;
				}
				
				propostaRepository.save(new Proposta(BigDecimal.valueOf(Double.parseDouble(record[0])), status));				
			}
			for (String[] record : portador) {				
				portadorRepository.save(new Portador(record[0], record[1], propostaRepository.findById(Long.parseLong(record[2])).get()));				
			}						
			
		};
	}

	private List<String[]> propostaCSV() {
		List<String[]> proposta = null;

		try {
			Reader reader = Files.newBufferedReader(Paths.get(".\\dados\\propostas.csv"));
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			proposta = csvReader.readAll();
			csvReader.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proposta;
	}

	private List<String[]> portadorCSV() {
		List<String[]> proposta = null;

		try {
			Reader reader = Files.newBufferedReader(Paths.get(".\\dados\\portador.csv"));
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			proposta = csvReader.readAll();
			csvReader.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proposta;
	}
}
