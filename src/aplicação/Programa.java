package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Programa {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);

		Scanner leitor = new Scanner(System.in);

		List<Produto> produto = new ArrayList<>();

		System.out.print("Informe a quantidade de produtos: ");
		Integer n = leitor.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Descrição do " + i + "º produto: ");
			System.out.print("COMUM, USADO ou IMPORTATO - (C/U/I): ");
			char esc = leitor.next().charAt(0);
			System.out.print("Nome: ");
			leitor.nextLine();
			String nome = leitor.nextLine();
			System.out.print("Preço: ");
			Double preco = leitor.nextDouble();
			if (esc == 'c' || esc == 'C') {
				produto.add(new Produto(nome, preco));
			} else if (esc == 'u' || esc == 'U') {
				System.out.print("Data de fabricação: (DD/MM/AAAA): ");
				Date dataFabri = sdf.parse(leitor.next());
				produto.add(new ProdutoUsado(nome, preco, sdf, dataFabri));
			} else {
				System.out.print("Valor taxa de importação: ");
				Double taxa = leitor.nextDouble();
				produto.add(new ProdutoImportado(nome, preco, taxa));
			}
		}
		System.out.println();
		System.out.println("Etiqueta de preços: ");
		for (Produto produtos : produto) {
			System.out.println(produtos.etiquetaPreco());
		}
		leitor.close();
	}
}