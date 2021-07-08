package arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gravador {
	
	public void gravarProduto(List<String> texto, String nomeDoArquivo) throws IOException {
		BufferedWriter escritor = null;
		try {
			escritor = new BufferedWriter(new FileWriter(nomeDoArquivo));
			for (String s : texto) {
				escritor.write(s + "\n");
			}
		} finally {
			if (escritor != null) {
				escritor.close();
			}
		}
	}
	
	public List<String> buscarProduto(String nomeDoArquivo) throws IOException {
		BufferedReader leitor = null;
		List<String> produtos = new ArrayList<String>();
		try {
			leitor = new BufferedReader(new FileReader(nomeDoArquivo));
			String total = null;
			do {
				total = leitor.readLine();
				if (total != null) {
					produtos.add(total);
				}
			} while (total != null);
			
		} finally {
			if (leitor != null) {
				leitor.close();
			}
		}
		return produtos;
	}

}
